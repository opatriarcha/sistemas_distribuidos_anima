package org.sd.udp.simpleUdp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author orlando
 */
public class Server extends Thread{    
    private static final int BUFFER_SIZE = 1024;
    
    public void startServer(){
        DatagramSocket socket = null;
        try{
            socket =new DatagramSocket(3000);
            System.out.println("Servidor iniciado!");
            byte[] buffer = new byte[BUFFER_SIZE];

            DatagramPacket datagrama = new DatagramPacket(buffer, buffer.length);
            socket.receive(datagrama);
            System.out.println("Mensagem recebida no Server");

            String mensagemRecebida =  new String(datagrama.getData());
            System.out.println("Mensagem Recebida no Server: " + mensagemRecebida);
            JOptionPane.showMessageDialog(null, mensagemRecebida, "Mensagem Recebida do Server", JOptionPane.OK_OPTION);
            
        }catch( SocketException socketException ){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "Servidor não iniciado pro problemas técnicos: " + socketException.getMessage());
//            socketException.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "Problema ao receber Dados do cliente: " + ex.getMessage(), ex);
        }
                
    }
    
    public static void main(String[] args) {
        new Server().startServer();
    }
}
