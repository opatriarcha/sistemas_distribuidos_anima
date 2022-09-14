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
    DatagramSocket ds = new DatagramSocket(3000);  
    byte[] buf = new byte[1024];  
    DatagramPacket dp = new DatagramPacket(buf, 1024);  
    ds.receive(dp);  
    final ByteArrayInputStream baos = new ByteArrayInputStream(buf);
    final ObjectInputStream oos = new ObjectInputStream(baos);
    Object returned = oos.readObject();
    Person person = (Person) returned;
//    String str = new String(dp.getData(), 0, dp.getLength());  
    System.out.println(person);  
    ds.close();  
  }  
}