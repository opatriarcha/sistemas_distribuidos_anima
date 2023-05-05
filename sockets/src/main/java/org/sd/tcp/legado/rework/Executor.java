package org.sd.tcp.legado.rework;

import java.net.Socket;

/**
 *
 * @author orlando
 */
public class Executor {
    
    private Servidor servidor = new Servidor();
    
    public static void main(String args[]) {
        String texto = "";
        String resposta = "Hello World!!!!";
        Servidor servidor = new Servidor();
        Conexao c = new Conexao();
        while (true) {
            Socket client = servidor.connect();
            if (client.isConnected()) {

                texto = c.receive(client);
                System.out.println("Cliente enviou: " + texto.trim());      // fase de dados
                c.send(client, resposta +" -> "  +  texto);

                try {
                    client.close();

                } catch (Exception e) {
                    System.err.println("Não encerrou a conexao corretamente" + e.getMessage());
                }
            }
        }

    }
    
}
