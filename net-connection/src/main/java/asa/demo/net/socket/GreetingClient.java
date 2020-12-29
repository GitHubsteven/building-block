package asa.demo.net.socket;

import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/29
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class GreetingClient {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String serverName = args.length > 1 ? args[0] : "10.0.1.32";
        int port = args.length > 2 ? Integer.parseInt(args[1]) : 9001;
        while (true) {
            try {
                final Socket client = new Socket(serverName, port);
                System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
                OutputStream outToServer = client.getOutputStream();
                DataOutputStream out = new DataOutputStream(outToServer);
                final String message = scanner.nextLine();
                out.writeUTF(client.getLocalSocketAddress() + ">>>" + message);
                InputStream inFromServer = client.getInputStream();
                DataInputStream in = new DataInputStream(inFromServer);
                final String to = in.readUTF();
                System.out.println("<<<： " + to);
                client.close();
                if (StringUtils.equalsIgnoreCase("exit", to)) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

    }
}
