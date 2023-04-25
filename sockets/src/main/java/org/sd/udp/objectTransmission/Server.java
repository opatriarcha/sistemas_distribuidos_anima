package org.sd.udp.objectTransmission;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author orlando
 */
public class Server {

    public static void main(String[] args) throws Exception {
        //criação do socket
        DatagramSocket ds = new DatagramSocket(3000);
        byte[] buf = new byte[1024];
       
        //criação do datagrama
        DatagramPacket dp = new DatagramPacket(buf, 1024);
        ds.receive(dp);
        
        //declara os streams
        final ByteArrayInputStream baos = new ByteArrayInputStream(buf);
        final ObjectInputStream oos = new ObjectInputStream(baos);
        
        
        //recebe o objeto
        Object returned = oos.readObject();
        Person person = (Person) returned;
        System.out.println(person);
        ds.close();
    }
}
