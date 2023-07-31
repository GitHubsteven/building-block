/**
 * @author: asx
 * @date: 2023/7/26
 * @descrition:
 */
package com.java.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: asx
 * @date: 2023/7/26
 * @descrition:
 */
public class DemoServer extends Thread implements IRequestHandler {
    private ServerSocket serverSocket;

    public int getPort() {
        return serverSocket.getLocalPort();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(0);
            while (true) {
                Socket socket = serverSocket.accept();
                RequestHandler handler = new RequestHandler(socket);
                process(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void process(RequestHandler handler) {
        defaultProcess(handler);
    }
}
