package uk.wingdash.server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;

public class aServer {

	public static HashMap<String,Socket> users = new HashMap<>();

	private static final int PORT = 9898;
	private static final int EC2PORT = 91;

    public static void main(String[] args) throws Exception {
        System.out.println("The  server is running.");
        int clientNumber = 1;
        ServerSocket listener = new ServerSocket(PORT);
        Socket connection;
        try {
            while (true) {
            	connection = listener.accept();
            	users.put(String.valueOf(clientNumber),connection);
                new Connection(connection, clientNumber++).start();

                System.out.println(users.size());
            }

        } finally {
            listener.close();
            
        }
    }

    private boolean checkForValue(){

        return false;
    }

    
    
}