package uk.wingdash.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Connection extends Thread {
    private Socket socket;
    private int clientNumber;
    private PrintWriter out;
    private Client _userToConnect = null;

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

    private boolean connectToOtherUser(){

        Handshake performHandshakeCheck = new Handshake();

        // get the socket that needs connection
        _userToConnect = getUsers().get(String.valueOf(2));
        if(performHandshakeCheck.attemptConnection(_userToConnect)){
            return true;
        }
        return false;
    }

    private void log(String message) {
        System.out.println(message);
    }

    private HashMap<String,Client> getUsers() {

        return ServerInit.users;
    }
}