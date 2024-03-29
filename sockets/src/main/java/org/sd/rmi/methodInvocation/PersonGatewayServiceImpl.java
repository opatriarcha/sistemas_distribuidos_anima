package org.sd.rmi.methodInvocation;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


/**
 *
 * @author orlando
 */
public class PersonGatewayServiceImpl implements PersonGatewayService {
	
        @Override
	public void createStubAndBind() throws RemoteException {
		
		PersonGatewayService stub = (PersonGatewayService) UnicastRemoteObject.exportObject((PersonGatewayService) this, 0);
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.rebind("PersonGatewayService", stub);
	}
	
        @Override
	public Person retrievePerson(String thePerson) throws RemoteException {
               PersonHolder holder = new PersonHolder();
               return holder.retrievePerson(thePerson);
	}
	
}    

