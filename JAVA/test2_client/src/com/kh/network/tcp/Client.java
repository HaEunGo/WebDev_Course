package com.kh.network.tcp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	
	public void client() {
		int port = 3000;
		String serverIP = "192.168.20.34";
		
		try {
				serverIP = InetAddress.getLocalHost().getHostAddress();
				Socket Socket = new Socket(serverIP, port);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
			
		}
		
	}



}
