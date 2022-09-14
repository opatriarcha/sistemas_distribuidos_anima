package org.sd.tcp.httpProxySocket;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Socket;
import java.net.URL;

/**
 *
 * @author orlando
 */
public class ClientSocket {
    public static final String SOCKET_SERVER_HOST = "localhost";
    public static final int SOCKET_SERVER_PORT = 90;
    
    public static void main(String[] args) throws MalformedURLException, IOException {
        Proxy socksProxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("127.0.0.1", 1080));
        URL weburl = new URL("www.google.com");
        HttpURLConnection socksConnection = (HttpURLConnection) weburl.openConnection(socksProxy);
        
        InetSocketAddress socketHost = new InetSocketAddress(SOCKET_SERVER_HOST, SOCKET_SERVER_PORT);
        Socket proxySocket = new Socket(socksProxy); 
        proxySocket.connect(socketHost);
    }
}
