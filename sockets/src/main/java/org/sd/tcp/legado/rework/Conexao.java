package org.sd.tcp.legado.rework;

import org.sd.tcp.legado.original.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author bmoritani
 */
public class Conexao {

    public void send(Socket socket, String msg) {
        OutputStream out;
        try {
            out = socket.getOutputStream();
            out.write(msg.getBytes());
        } catch (Exception e) {
            System.err.println("Excecao no OutputStream");
        }
    }
    
    public String receive(Socket socket) {
        InputStream in;
        int bytesQuantity;
        byte bytesMessage[];
        String message = "";
        bytesMessage = new byte[100];
        try {
            in = socket.getInputStream();
            bytesQuantity = in.read(bytesMessage);
            if (bytesQuantity > 0) {
                message = new String(bytesMessage);                
            }
        } catch (IOException e) {
            System.err.println("Excecao no InputStream: " + e);
        }
        return message;
    }
}

