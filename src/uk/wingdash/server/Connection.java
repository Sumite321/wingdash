package uk.wingdash.server;

import java.io.*;
import java.net.Socket;
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

    public void run() {
        try {


            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Hello, you are client #" + clientNumber + ".");
            out.println(HTMLCode.SUCCESS.toString());
            out.println("Enter a line with only a period to quit\n");

//            while (true) {
//                String input = in.readLine();
//
//                if (input.equals("avai")) {
//
//                    String connected = " ";
//
//                    for (Socket user : getUsers().values()) {
//
//                        connected += user.getInetAddress().getHostName();
//
//                    }
//                    out.println(connected);
//                } else if (input.contains("connect")) {
//
//                    connectTo(2);
//
//                    out.println("mf");
//
//
//                } else {
//                    out.println(input);
//                }
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

    private HashMap<String, Socket> getUsers() {

        return ServerInit.users;
    }

    
    private void connectTo(int clientNumber) {

        try {
            // get the socket that needs connection
            Socket user = getUsers().get(String.valueOf(2));

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