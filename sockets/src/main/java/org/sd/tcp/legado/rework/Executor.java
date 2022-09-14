/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sd.tcp.legado.rework;

import java.net.Socket;
import static org.sd.tcp.legado.rework.Servidor.c;

/**
 *
 * @author orlando
 */
public class Executor {
    
    Servidor servidor = new Servidor();
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
                c.send(client, resposta);

                try {
                    client.close();

                } catch (Exception e) {
                    System.err.println("Não encerrou a conexao corretamente" + e.getMessage());
                }
            }
        }

    }
    
}
