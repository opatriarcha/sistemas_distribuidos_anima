package org.sd.tcp.simpleSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orlando
 */
public class SimpleClient {
    
    private Socket socketClient;
    private Integer port;
    private String ip;

    public SimpleClient(String ip, Integer port) {
        this.port = port;
        this.ip = ip;
    }
    
    
    public void sendMessage( String message ){
        try {
            this.socketClient = new Socket(this.ip, this.port);
            System.out.println("Connected!");
            this.send(socketClient, "teste");
        } catch (IOException ex) {
            Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void send(Socket socket, String msg) {
        OutputStream out;
        try {
            out = socket.getOutputStream();
            out.write(msg.getBytes());
        } catch (Exception e) {
            System.err.println("Excecao no OutputStream");
        }
    }
    public static void main(String[] args) {
        SimpleClient client = new SimpleClient("127.0.0.1", 3322);
    }
}
