package com.kh.test2.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	public void server() {
		int port = 3000;

		ServerSocket server;
		try {
			server = new ServerSocket(port);
			
			while(true) {
				try {
					Socket client = server.accept();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			
		}
	}



}
