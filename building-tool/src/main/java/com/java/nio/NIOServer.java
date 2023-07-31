/**
 * @author: asx
 * @date: 2023/7/27
 * @descrition:
 */
package com.java.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: asx
 * @date: 2023/7/27
 * @descrition:
 */
public class NIOServer extends DemoServer {
    @Override
    public void run() {
        try (Selector selector = Selector.open()) {
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            channel.configureBlocking(false);
            // 注册到selector种，并说明关注点
            channel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                // 阻塞等待就绪的channel
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    sayHelloWorld((ServerSocketChannel) key.channel());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sayHelloWorld(ServerSocketChannel server) throws IOException {
        try (SocketChannel client = server.accept();) {
            client.write(Charset.defaultCharset().encode("Hello world!"));
        }
    }

    @Override
    public int getPort() {
        return 8888;
    }
}
