
package org.sd.tcp.simpleSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orlando
 */
public class SimpleServer {
    
    private int port = 3322;

    public SimpleServer(int port) {
        this.port = port;
    }
    
    public void start(){
        try {
            ServerSocket server = new ServerSocket(this.port);
            System.out.println("Servidor iniciado na porta: " + this.port);

            Socket cliente = server.accept();
            System.out.println("Cliente conectado do IP " + cliente.getInetAddress().getHostAddress());
            Scanner entrada = new Scanner(cliente.getInputStream());
            
            while(entrada.hasNextLine()){
                System.out.println(entrada.nextLine());
            }

            entrada.close();
            server.close();

        } catch (IOException ex) {
            Logger.getLogger(SimpleServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        SimpleServer server = new SimpleServer(3322);
        server.start();
    }
    
}
