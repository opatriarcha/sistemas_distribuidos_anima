package org.sd.udp.simpleUdp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orlando
 */
public class Client {

    public void connectAndSendMessage(final String host, final int port, final String mensagem) {
        DatagramSocket socket = null;
        InetAddress ip = null;
        try {
            socket = new DatagramSocket();

            ip = InetAddress.getByName(host);
           
            DatagramPacket pacote = new DatagramPacket(mensagem.getBytes(), mensagem.getBytes().length, ip, port);

            socket.send(pacote);

        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, "Erro ao estabelecer conexão: ", ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, "Host desconhecido: " + ip.getHostAddress(), ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, "Erro genérico ao enviar pacote.", ex);
        } finally {
            if (socket != null) 
                socket.close();
            socket = null;
        }
    }
    
    
    public static void main(String[] args) {
        Client client = new Client();
        client.connectAndSendMessage("127.0.0.1", 3000, "Uma mensagem qualquer");
    }
}
