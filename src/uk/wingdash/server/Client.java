package uk.wingdash.server;

import java.net.Socket;
import java.util.Date;

public class Client {

	private int clientNumber = 0;
	private Socket socket = null;
	private String STATUS;
	private Date __dateTimeConnected;
	private Date _dateTimeDisconnected;
	private String _connectedTo;
	
	public Client(int clientNumber, Socket socket) {
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

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String STATUS) {
		this.STATUS = STATUS;
	}

	public Date get__dateTimeConnected() {
		return __dateTimeConnected;
	}

	public void set__dateTimeConnected(Date __dateTimeConnected) {
		this.__dateTimeConnected = __dateTimeConnected;
	}

	public Date get_dateTimeDisconnected() {
		return _dateTimeDisconnected;
	}

	public void set_dateTimeDisconnected(Date _dateTimeDisconnected) {
		this._dateTimeDisconnected = _dateTimeDisconnected;
	}

	public String get_connectedTo() {
		return _connectedTo;
	}

	public void set_connectedTo(String _connectedTo) {
		this._connectedTo = _connectedTo;
	}
}
