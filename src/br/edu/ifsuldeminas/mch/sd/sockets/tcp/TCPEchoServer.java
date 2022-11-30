package br.edu.ifsuldeminas.mch.sd.sockets.tcp;

import java.net.Socket;

public class TCPEchoServer {
	public static void main(String[] args) {
		int serverPort = 3000;
		Socket socket = null;
		Server serverConnection = new Server();
		try {
			serverConnection.start(serverPort);
			while (true) {
				serverConnection.connect();
				socket = serverConnection.getSocket();
				new ServerThread(socket);
			}
		} finally {
			serverConnection.isServerSocketNull();
		}
	}
}