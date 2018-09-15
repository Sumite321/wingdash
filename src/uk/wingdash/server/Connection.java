package uk.wingdash.server;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.HashMap;

public class Connection extends Thread {
    private Socket socket;
    private int clientNumber;

    public Connection(Socket socket, int clientNumber) {
        this.socket = socket;
        this.clientNumber = clientNumber;
        log("Connected client # " + clientNumber + " at " + socket);
    }

    public void run() {
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Hello, you are client #" + clientNumber + ".");
            out.println("Enter a line with only a period to quit\n");

            while (true) {
                String input = in.readLine();

                if (input.equals("avai")) {

                    String connected = " ";

                    for (Socket user : getUsers().values()) {

                        connected += user.getInetAddress().getHostName();

                    }
                    out.println(connected);
                } else if (input.contains("connect")) {


                    Socket user = getUsers().get(String.valueOf(2));


                    PrintWriter outStream = new PrintWriter(user.getOutputStream(),true);
                    if(!outStream.checkError()){
                        log("A connected to B");
                    }
                    outStream.println(input);
                    out.println("mf");



                } else {
                    out.println(input);
                }



            }
        } catch (IOException e) {
            log("Error handling client# " + clientNumber + ": " + e);
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

        return aServer.users;
    }

    private void connectTo(int clientNumber) {


    }

    private void connectionStatus() {


    }
}