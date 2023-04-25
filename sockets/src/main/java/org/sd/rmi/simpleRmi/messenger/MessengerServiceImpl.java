package org.sd.rmi.simpleRmi.messenger;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


/**
 *
 * @author orlando
 */
public class MessengerServiceImpl implements MessengerService {
    
        private static final int PORT = 1099;
        

	public String sendMessage(String clientMessage) {
		
		String serverMessage = null;
		if (clientMessage.equals("Client Message")) {
			serverMessage = "Server Message";
		}
		
		return serverMessage;
	}
	
	public void createStubAndBind() throws RemoteException {
		
		MessengerService stub = (MessengerService) UnicastRemoteObject.exportObject((MessengerService) this, 0);
		Registry registry = LocateRegistry.createRegistry(PORT);
		registry.rebind(MESSENGER_SERVICE_NAME, stub);
	}
	
	public Message sendMessage(Message clientMessage) throws RemoteException {
		
		Message serverMessage = null;
		if (clientMessage.getMessageText().equals("Client Message")) {
			serverMessage = new Message("Server Message", "text/plain");
		}
		
		return serverMessage;
	}
	
}    

