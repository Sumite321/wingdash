package uk.wingdash.server;

import javax.swing.text.html.HTML;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Handshake {

    private String[] packet= new String[2];
    private String _AUTH = "58a6sd*&^7y&T£";

    public void Handshake(){
    }

    public boolean attemptConnection(Client destination) {

        try {

            // the outstream of the socket
            PrintWriter outStream = new PrintWriter(destination.getSocket().getOutputStream(), true);

            // check if connected with no errors
            if (!outStream.checkError()) {
                HTMLCode.SUCCESS.toString();
                packet[0] = HTMLCode.SUCCESS.toString();
                packet[1] = _AUTH;
                outStream.println(packet);
            }


            return true;
        } catch (IOException e) {
            HTMLCode.FAILED.toString();
        }

        return false;
    }

    public boolean authoriseHandshake(String[] packet){
        //decode the code

        return packet[1] == _AUTH;

    }
}
