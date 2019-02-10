package uk.wingdash.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Handshake {

        /*
    possible part of handshake between two clients, to be changed to handshake.java
     */


    public void Handshake(){
    }

    public boolean connectTo(Client destination) {

        try {

            // the outstream of the socket
            PrintWriter outStream = new PrintWriter(destination.getSocket().getOutputStream(), true);

            // check if connected with no errors
            if (!outStream.checkError()) {
                HTMLCode.SUCCESS.toString();
            }

            outStream.println("YouReachedMe");
            return true;
        } catch (IOException e) {
            HTMLCode.FAILED.toString();
        }

        return false;
    }
}
