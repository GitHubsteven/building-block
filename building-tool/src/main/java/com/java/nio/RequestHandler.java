/**
 * @author: asx
 * @date: 2023/7/26
 * @descrition:
 */
package com.java.nio;

import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author: asx
 * @date: 2023/7/26
 * @descrition:
 */
public class RequestHandler extends Thread {
    private Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream())) {
            out.println("Hello world!");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
