/**
 * @author: asx
 * @date: 2023/7/27
 * @descrition:
 */
package com.java.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author: asx
 * @date: 2023/7/27
 * @descrition:
 */
public class ServerTest {

    public static void main(String[] args) {
        DemoServer server = new NIOServer();
        server.start();
        conCurrentClientSendRequest(10, server);

    }

    public static void conCurrentClientSendRequest(int concurrentCount, DemoServer server) {
        for (int i = 0; i < concurrentCount; i++) {
            clientSendRequest(server);
        }
    }


    private static void clientSendRequest(DemoServer server) {
        try (Socket client = new Socket(InetAddress.getLocalHost(), server.getPort())) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedReader.lines().forEach(System.out::println);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
