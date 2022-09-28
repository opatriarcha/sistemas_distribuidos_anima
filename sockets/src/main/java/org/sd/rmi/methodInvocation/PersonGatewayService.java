package org.sd.rmi.methodInvocation;

/**
 *
 * @author orlando
 */
import org.sd.rmi.simpleRmi.messenger.*;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PersonGatewayService extends Remote {

	public Person retrievePerson(String thePerson) throws RemoteException;
}
