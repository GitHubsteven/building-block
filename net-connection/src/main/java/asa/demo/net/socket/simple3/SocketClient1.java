package asa.demo.net.socket.simple3;
import java.io.BufferedReader;
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


public class SocketClient1 {
    public static void main(String args[])throws Exception{
        Socket socket = new Socket("192.168.10.2", 5208);
        System.out.println("小一连接成功");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        while(true){
            pw.println("小一说："+br.readLine());
            pw.flush();
        }
    }
}
