package asa.demo.net.socket.simple3;

import java.io.IOException;
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
        ServerSocket serverSocket = new ServerSocket(10001);
        System.out.println("服务器启动成功");

        while (true) {
            final Socket socket = serverSocket.accept();
            System.out.println("上线通知： " + socket.getInetAddress() + ":" + socket.getPort());
            new Thread(new ServerThread(socket)).start();
        }
    }
}
