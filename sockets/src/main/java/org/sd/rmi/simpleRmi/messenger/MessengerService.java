package org.sd.rmi.simpleRmi.messenger;

/**
 *
 * @author orlando
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MessengerService extends Remote {
        public static final String MESSENGER_SERVICE_NAME = "MessengerService";

	public String sendMessage(String clientMessage) throws RemoteException;

	public Message sendMessage(Message clientMessage) throws RemoteException;
}
