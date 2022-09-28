package org.sd.rmi.simpleRmi;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orlando
 */
public class MessengerClient {

    public static void main(String[] args) {
        Registry registry;
        try {
            registry = LocateRegistry.getRegistry();
            MessengerService server = (MessengerService) registry.lookup("MessengerService");
            String responseMessage = server.sendMessage("Client Message");
            String expectedMessage = "Server Message";
        } catch (RemoteException ex) {
            Logger.getLogger(MessengerClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(MessengerClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
