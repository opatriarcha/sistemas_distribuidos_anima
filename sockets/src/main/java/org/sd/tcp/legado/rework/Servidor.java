package org.sd.tcp.legado.rework;


import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author opatriarcha
 */
public class Servidor {

    ServerSocket serversocket;
//    Socket client_socket;
//    Conexao c;
//    String msg;

    public Servidor() {
        try {
            //bind e criacao do socket do servidor
            serversocket = new ServerSocket(9600);
            System.out.println("Criado o Server Socket");
        } catch (Exception e) {
            System.err.println("Nao criei o Server Socket...");
        }
    }

    

    public Socket connect() {
        Socket clientSocket = null;
        try {
            clientSocket = serversocket.accept();  // aceitar a conexao
//            return clientSocket;
        } catch (Exception e) {
            System.err.println("Nao fez conexao" + e.getMessage());
        }
        return clientSocket;
    }
}