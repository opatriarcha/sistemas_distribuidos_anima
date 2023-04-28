/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sd.rmi.simpleRmi.messenger;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author orlando
 */
public class Main {
    private MessengerServiceImpl messengerService;
    
    public MessengerService startServer(){
        try {
            messengerService = new MessengerServiceImpl();
            messengerService.createStubAndBind();
            
        } catch (RemoteException e) {
            System.out.println("Exception Occurred: " + e);
        }
        return messengerService;
    }
    
    public void executeClientInvocation(){
        System.out.println("EXECUTANDO MÉTODO REMOTO STRING");
        try {
            Registry registry = LocateRegistry.getRegistry();
            MessengerService server = (MessengerService) registry.lookup(MessengerService.MESSENGER_SERVICE_NAME);
            
            String responseMessage = server.sendMessage("Client Message");
            System.out.println("MENSAGEM ENVIADA PELO SERVIDOR: " + responseMessage);
            String expectedMessage = "Server Message";
            
            System.out.println("MENSAGEM ESPERADA: " + expectedMessage);
            
        } catch (RemoteException | NotBoundException e) {
            System.out.println("Exception Occurred: " + e);
        }
    }
    
    public static void main(String[] args) {
        Main main = new Main();
        main.startServer();
        main.executeClientInvocation();
        
        System.exit(0);
    }
    
}
