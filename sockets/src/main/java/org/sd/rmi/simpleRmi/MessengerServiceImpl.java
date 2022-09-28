package org.sd.rmi.simpleRmi;

public class MessengerServiceImpl implements MessengerService { 
 
    @Override 
    public String sendMessage(String clientMessage) { 
        return "Client Message".equals(clientMessage) ? "Server Message" : null;
    }

    public String unexposedMethod() { 
    /* code */ 
        return "unexposedMethod return"; 
    }
}
