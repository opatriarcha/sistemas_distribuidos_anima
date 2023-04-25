package org.sd.tcp.legado.rework;


import org.sd.tcp.legado.original.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author opatriarcha
 */
public class Servidor {

    static ServerSocket serversocket;
    static Socket client_socket;
    static Conexao c;
    static String msg;

    public Servidor() {
        try {
            //bind e criacao do socket do servidor
            serversocket = new ServerSocket(9601);
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