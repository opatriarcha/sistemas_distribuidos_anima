package org.sd.tcp.legado.original;


import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author bmoritani
 */
public class Cliente {

    static Conexao c;
    static Socket socket;

    public Cliente() {
        try {
            socket = new Socket("localhost", 9600); // fase de conexao
        } catch (Exception e) {
            System.err.println("Nao consegui resolver o host...");
        }
    }

    public static void main(String args[]) {
        String requisicao = "aham";
        String texto;
        new Cliente();

        c.send(socket, requisicao);
        texto = c.receive(socket);      // fase de dados
        System.out.println("Servidor enviou: " + texto.trim());

        try {
            socket.close();                 // fase de desconexao
        } catch (IOException e) {
            System.err.println("Nao encerrou a conexao corretamente" + e.getMessage());
        }
    }
}
