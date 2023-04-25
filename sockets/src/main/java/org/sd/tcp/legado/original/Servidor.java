package org.sd.tcp.legado.original;


import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author bmoritani
 */
public class Servidor {

    static ServerSocket serversocket;
    static Socket client_socket;
    static Conexao c;
    static String msg;

    public Servidor() {
        try {
            //bind e criacao do socket do servidor
            serversocket = new ServerSocket(9600);
            System.out.println("Criado o Server Socket");
        } catch (Exception e) {
            System.err.println("Nao criei o Server Socket...");
        }
    }

    public static void main(String args[]) {
        String texto = "";
        String resposta = "Hello World!!!!";
        new Servidor();

        while (true) {
            if (connect()) {

                texto = c.receive(client_socket);
                System.out.println("Cliente enviou: " + texto.trim());      // fase de dados
                c.send(client_socket, resposta);

                try {
                    client_socket.close();

                } catch (Exception e) {
                    System.err.println("Não encerrou a conexao corretamente" + e.getMessage());
                }
            }
        }

    }

    static boolean connect() {
        boolean ret;
        try {
            client_socket = serversocket.accept();  // aceitar a conexao
            ret = true;
        } catch (Exception e) {
            System.err.println("Nao fez conexao" + e.getMessage());
            ret = false;
        }
        return ret;
    }
}