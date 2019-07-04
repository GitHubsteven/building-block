package com.variety.shop.indi.netWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class SimpleTcpClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Socket socket=null;
		BufferedReader br=null;
		PrintWriter pw=null;
		BufferedReader brTemp=null;
		
		try {
			socket = new Socket(InetAddress.getLocalHost(), 5678);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
			brTemp = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				String line = brTemp.readLine();
				pw.println(line);
				pw.flush();
				if (line.equals("end"))
					break;
				System.out.println(br.readLine());
			} 
		} catch (Exception ex) {
			System.out.println(ex.getMessage());// TODO: handle exception
		}
		finally
		{
			if(socket!=null) socket.close();
			if(br!=null) br.close();
			if(brTemp!=null) brTemp.close();
			if(pw!=null) pw.close();
		}
			
	}

}
