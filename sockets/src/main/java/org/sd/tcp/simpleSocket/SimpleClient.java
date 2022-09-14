package org.sd.tcp.simpleSocket;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orlando
 */
public class SimpleClient {
    
    private Socket socketClient;
    private Integer port;
    private String ip;

    public SimpleClient(String ip, Integer port) {
        this.port = port;
        this.ip = ip;
    }
    
    
    public void sendMessage( String message ){
        try {
            this.socketClient = new Socket(this.ip, this.port);
            //this.socketClient.bind(bindpoint);
        } catch (IOException ex) {
            Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
