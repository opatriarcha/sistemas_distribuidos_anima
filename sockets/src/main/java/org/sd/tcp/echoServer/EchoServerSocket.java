package org.sd.tcp.echoServer;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orlando.patriarcha
 */
public class EchoServerSocket {
    
    private int port = 3322;

    public EchoServerSocket(int port) {
        this.port = port;
    }
    
    public void start(){
        try {
            ServerSocket server = new ServerSocket(this.port);
            System.out.println("Servidor iniciado na porta 3322");

            Socket cliente = server.accept();
            System.out.println("Cliente conectado do IP " + cliente.getInetAddress().getHostAddress());
            Scanner entrada = new Scanner(cliente.getInputStream());
            
            while(entrada.hasNextLine()){
                System.out.println(entrada.nextLine());
            }

            entrada.close();
            server.close();

        } catch (IOException ex) {
            Logger.getLogger(EchoServerSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
