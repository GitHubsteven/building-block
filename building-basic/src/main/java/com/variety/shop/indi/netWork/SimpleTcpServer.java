package com.variety.shop.indi.netWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleTcpServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server=null;
		Socket client=null;
		BufferedReader br=null;
		PrintWriter pw=null;
		
		try {
			server =new ServerSocket(5678);
			client =server.accept();
			br=new BufferedReader(new InputStreamReader(client.getInputStream()));
			pw=new PrintWriter(client.getOutputStream());
			
			while (true)
			{
				String line=br.readLine();
				pw.println("response:"+line);
				pw.flush();
				if(line.equals("end")) break;
			}
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			System.err.println(ex.getMessage());
		}
		finally
		{
			if(server!=null) server.close();
			if(client!=null) client.close();
			if(br!=null) br.close();
			if(pw!=null) pw.close();
		}
	}

}
