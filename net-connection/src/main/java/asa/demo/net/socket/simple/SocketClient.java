package asa.demo.net.socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/29
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class SocketClient {
    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket("localhost", 10001);
        System.out.println("client start successfully!");
        BufferedReader out = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        while (true) {
            final String str = out.readLine();
            if ("".equals(str) || str == null || "exit".equals(str)) {
                break;
            }
            printWriter.println(str);
            printWriter.flush();
        }

        printWriter.close();
        socket.close();
    }
}
