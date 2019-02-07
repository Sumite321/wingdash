package uk.wingdash.server;

import java.net.Socket;

public class Client {

	private int clientNumber = 0;
	Socket socket = null;
	
	private Client(int clientNumber, Socket socket) {
		
		this.clientNumber = clientNumber;
		this.socket = socket;
		
	}

	public int getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
}
