package asa.demo.net.socket.simple3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/29
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class ServerThread implements Runnable {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            while (true) {
                final String received = input.readLine();
                System.out.println(received);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
