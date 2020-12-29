package asa.demo.net.socket.simple2;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/29
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class SocketService {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(10001);
        System.out.println("服务器启动成功");
        Socket socket = server.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader out = new BufferedReader(new InputStreamReader(System.in));
        try (PrintWriter pw = new PrintWriter(socket.getOutputStream())) {
            while (true) {
                System.out.println("客户端说：" + in.readLine());
                String str = out.readLine();
                pw.println(str);
                if (StringUtils.equalsIgnoreCase("exit", str)) {
                    break;
                }
                pw.flush();
                System.out.println("服务器说：" + str);
            }
        }

        System.out.println("connect end!");
    }
}
