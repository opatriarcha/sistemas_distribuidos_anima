/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sd.rmi.methodInvocation;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sd.rmi.simpleRmi.messenger.MessengerService;
import org.sd.rmi.simpleRmi.messenger.MessengerServiceImpl;

/**
 *
 * @author orlando
 */
public class PersonGatewayServiceIntegrationTest {
    private static PersonGatewayServiceImpl personGateway;

    @BeforeClass
    public static void init() {
        try {
            personGateway = new PersonGatewayServiceImpl();
            personGateway.createStubAndBind();
        } catch (RemoteException e) {
            fail("Exception Occurred: " + e);
        }
    }

    @Test
    public void whenClientAsksForExistingPerson_ServerReturnsTheRightPerson() {
        try {
            Registry registry = LocateRegistry.getRegistry();
            PersonGatewayService server = (PersonGatewayService) registry.lookup("PersonGatewayService");
            String PERSON_KEY = "1";
            
            PersonHolder holder = new PersonHolder();
            
            Person personRetrieved = server.retrievePerson(PERSON_KEY);
            Person expected = holder.retrievePerson(PERSON_KEY);

            assertEquals(personRetrieved, expected);
        } catch (RemoteException | NotBoundException e) {
            fail("Exception Occurred: " + e);
        }
    }
    
    @Test
    public void whenClientAsksForNonExistingPerson_ServerReturnsNull() {
        try {
            Registry registry = LocateRegistry.getRegistry();
            PersonGatewayService server = (PersonGatewayService) registry.lookup("PersonGatewayService");
            String PERSON_KEY = "-1";
            
            PersonHolder holder = new PersonHolder();
            
            Person personRetrieved = server.retrievePerson(PERSON_KEY);
            Person expected = holder.retrievePerson(PERSON_KEY);

            assertEquals(personRetrieved, expected);
            Assert.assertNull(personRetrieved);
        } catch (RemoteException | NotBoundException e) {
            fail("Exception Occurred: " + e);
        }
    }
    
}
