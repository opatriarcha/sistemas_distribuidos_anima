package org.sd.udp.objectTransmission;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author orlando
 */
public class Client {

    public static void main(String[] args) throws Exception {
                
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("127.0.0.1");

        Person person = new Person(1L, "Orlando", "Patriarcha", "34581665298", new Date());

        final ByteArrayOutputStream baos = new ByteArrayOutputStream(6400);
        final ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(person);
        final byte[] data = baos.toByteArray();

        DatagramPacket dp = new DatagramPacket(data, data.length, ip, 3000);
        ds.send(dp);
        ds.close();
    }
}
