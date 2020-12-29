package http.connect.pool;

import org.apache.http.HttpHost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/29
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class SocketFactoryTest {
    public static void main(String[] args) throws IOException {
        final HttpClientContext clientContext = HttpClientContext.create();
        final PlainConnectionSocketFactory socketFactory = PlainConnectionSocketFactory.getSocketFactory();
        final Socket socket = socketFactory.createSocket(clientContext);
        //ms
        int timeout = 1000;
        final HttpHost target = new HttpHost("localhost");
        final InetSocketAddress remoteAddress = new InetSocketAddress(InetAddress.getByAddress(new byte[]{127, 0, 0, 1}), 80);

        socketFactory.connectSocket(timeout, socket, target, remoteAddress, null, clientContext);

    }
}
