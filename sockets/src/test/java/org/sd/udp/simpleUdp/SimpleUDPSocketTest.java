/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package org.sd.udp.simpleUdp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author orlando
 */
public class SimpleUDPSocketTest {
    
    private Server server;
    
    private static final String HOST_OK = "127.0.0.1";
    private static final int PORT_OK = 3000;
    
    private static final String HOST_ERRO = "127.19.0.1";
    private static final int PORT_ERROR = 6969;
    
    private static final String MESSAGE_SAMPLE = "Uma mensagem de exemplo";
    
    public SimpleUDPSocketTest() {
    }
    
    @Before
    public void setUp() {
        this.server = new Server();
        this.server.startServer();
    }
    
    @After
    public void tearDown() {
        this.server = null;
    }

    
    @Test
    public void testConnectAndSendMessageOK() {
        System.out.println("Rodando teste testConnectAndSendMessageOK");
        new Client().connectAndSendMessage(HOST_OK, PORT_OK, MESSAGE_SAMPLE);
        assertTrue(true);
    }
    
    @Test
    public void testConnectAndSendMessageWrongHost() {
        System.out.println("Rodando teste testConnectAndSendMessageWrongHost");
        new Client().connectAndSendMessage(HOST_ERRO, PORT_OK, MESSAGE_SAMPLE);
        assertTrue(false);
    }
    
    @Test
    public void testConnectAndSendMessageWrongPort() {
        System.out.println("Rodando teste testConnectAndSendMessageWrongPort");
        new Client().connectAndSendMessage(HOST_OK, PORT_ERROR, MESSAGE_SAMPLE);
        assertTrue(false);
    }
    
}
