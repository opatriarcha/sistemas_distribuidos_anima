package org.sd.tcp.legado.original;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author bmoritani
 */
public class Conexao {

    public static void send(Socket socket, String txt) {
        OutputStream out;
        try {
            out = socket.getOutputStream();
            out.write(txt.getBytes());
        } catch (Exception e) {
            System.err.println("Excecao no OutputStream");
        }
    }
    
    public static String receive(Socket socket) {
        InputStream in;
        int bt;
        byte btxt[];
        String txt = "";
        btxt = new byte[100];
        try {
            in = socket.getInputStream();
            bt = in.read(btxt);
            if (bt > 0) {
                txt = new String(btxt);                
            }
        } catch (IOException e) {
            System.err.println("Excecao no InputStream: " + e);
        }
        return txt;
    }
}

