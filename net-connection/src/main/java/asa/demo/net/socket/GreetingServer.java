package asa.demo.net.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/29
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class GreetingServer extends Thread {
    private ServerSocket serverSocket;

    public GreetingServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(0);
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
                System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
                final DataOutputStream out = new DataOutputStream(server.getOutputStream());
                final DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println("<<<：" + in.readUTF());
                final String response = scanner.nextLine();
                System.out.println(">>>" + server.getLocalAddress().getHostAddress());
                out.writeUTF(response);
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        final int port = args.length > 1 ? Integer.parseInt(args[0]) : 9001;
        try {
            final GreetingServer server = new GreetingServer(port);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
