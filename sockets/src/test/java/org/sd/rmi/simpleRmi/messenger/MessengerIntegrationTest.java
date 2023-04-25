package org.sd.rmi.simpleRmi.messenger;

import org.junit.Before;
import org.junit.Test;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MessengerIntegrationTest {

    private MessengerServiceImpl messengerService;

    @Before
    public void init() {
        try {
            messengerService = new MessengerServiceImpl();
            messengerService.createStubAndBind();
            
        } catch (RemoteException e) {
            fail("Exception Occurred: " + e);
        }
    }

//    @Test
    public void whenClientSendsMessageToServer_thenServerSendsResponseMessage() {
        System.out.println("EXECUTANDO MÉTODO REMOTO STRING");
        try {
            Registry registry = LocateRegistry.getRegistry();
            MessengerService server = (MessengerService) registry.lookup(MessengerService.MESSENGER_SERVICE_NAME);
            
            String responseMessage = server.sendMessage("Client Message");
            System.out.println("MENSAGEM ENVIADA PELO SERVIDOR: " + responseMessage);
            String expectedMessage = "Server Message";
            
            System.out.println("MENSAGEM ESPERADA: " + expectedMessage);
            
            assertEquals(responseMessage, expectedMessage);
        } catch (RemoteException | NotBoundException e) {
            fail("Exception Occurred: " + e);
        }
    }
    
    @Test
    public void whenClientSendsMessageTypedToServer_thenServerSendsResponseMessage(){
        System.out.println("EXECUTANDO MÉTODO REMOTO TIPADO");
        try{
            Registry registry = LocateRegistry.getRegistry();
            MessengerService server = (MessengerService) registry.lookup(MessengerService.MESSENGER_SERVICE_NAME);
            Message responseMessage = server.sendMessage( new Message("Client Message", "text"));
            System.out.println(" MENSAGEM ENVIADA PELO SERVIDOR: " + responseMessage.getMessageText());
            
            Message expectedMessage = new Message("Server Message", "text");
            System.out.println("MENSAGEM ESPERADA: " + expectedMessage.getMessageText());
            
            assertEquals(expectedMessage, responseMessage);
        }catch( Exception ex ){
            ex.printStackTrace();
        }
    }

}