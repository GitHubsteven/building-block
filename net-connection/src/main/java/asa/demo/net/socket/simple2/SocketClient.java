package asa.demo.net.socket.simple2;

import org.apache.commons.lang.StringUtils;

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
        Socket socket = new Socket(" 10.0.1.32", 10001);
        System.out.println("客户端启动成功");
        try (final BufferedReader out = new BufferedReader(new InputStreamReader(System.in));
             final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream())) {
            while (true) {
                final String input = out.readLine();
                if (StringUtils.equalsIgnoreCase(input, "exit")) {
                    break;
                }
                printWriter.println(input);
                printWriter.flush();
                System.out.println("client says: " + input);
                System.out.println("server says: " + in.readLine());
            }
            System.out.println("connect end!");
        }
    }
}
