package uk.wingdash.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Connection extends Thread {
    private Socket socket;
    private int clientNumber;
    private PrintWriter out;

    public Connection(Socket socket, int clientNumber) {
        this.socket = socket;
        this.clientNumber = clientNumber;
        log("Connected client # " + clientNumber + " at " + socket);
    }

    /*
    thread in charge of handling main [tasks,interactions] with client
     */
    public void run() {
        try {
            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Hello, you are client #" + clientNumber + ".");

            out.println("Enter a line with only a period to quit\n");

        } catch (IOException e) {
            log("Error handling client# " + clientNumber + ": " + e);
        } catch (NullPointerException n) {
            log("The client couldn't be found");
            out.println("The client couldn't be found");
        } finally {
            try {
                socket.close();

            } catch (IOException e) {
                log("Couldn't close a socket, what's going on?");
            }
            log("Connection with client# " + clientNumber + " closed");
            getUsers().remove(String.valueOf(clientNumber));
        }
    }

    private void log(String message) {
        System.out.println(message);
    }

    private HashMap<String,Client> getUsers() {

        return ServerInit.users;
    }

    /*
    possible part of handshake between two clients, to be changed to handshake.java
     */
    private void connectTo(int clientNumber) {

        try {
            // get the socket that needs connection
            Socket user = getUsers().get(String.valueOf(2)).getSocket();

            // the outstream of the socket
            PrintWriter outStream = new PrintWriter(user.getOutputStream(), true);

            // check if connected with no errors
            if (!outStream.checkError()) {
                log("A connected to B");
            }

            outStream.println("YouReachedMe");
        } catch (IOException e) {
            log("Unable to reach client");
        }
    }


}