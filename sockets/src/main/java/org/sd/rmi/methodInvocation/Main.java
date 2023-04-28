package org.sd.rmi.methodInvocation;

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
public class Main {

    PersonGatewayService service;

    public void startServer() {
        try {
            this.service = new PersonGatewayServiceImpl();
            this.service.createStubAndBind();
        } catch (RemoteException e) {
            System.out.println("Exception Occurred: " + e);
        }
    }

    public void executeClienteInvocation() {
        Registry registry;
        try {
            registry = LocateRegistry.getRegistry();
            PersonGatewayService server = (PersonGatewayService) registry.lookup("PersonGatewayService");
            final String PERSON_KEY = "1";


            Person result = server.retrievePerson(PERSON_KEY);

            System.out.println("Resultado da invocação:" + result);
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        Main main = new Main();
        main.startServer();
        main.executeClienteInvocation();
        System.exit(0);
    }
}
