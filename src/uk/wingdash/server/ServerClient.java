package uk.wingdash.server;

import java.net.Socket;

public class ServerClient {

	private int clientNumber = 0;
	Socket socket = null;
	
	private ServerClient(int clientNumber, Socket socket) {
		
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
