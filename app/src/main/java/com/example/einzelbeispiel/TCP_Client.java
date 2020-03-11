package com.example.einzelbeispiel;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCP_Client {


    private String matrikelnummer;
    private String answerFromServer;
    private DataOutputStream out;
    private BufferedReader in;
    private Socket socket = null;

    public TCP_Client(String matrikelnummer) {
        this.matrikelnummer = matrikelnummer;
    }

    public String connectToServer() {
        try {
            socket = new Socket("se2-isys.aau.at", 53212);
            out = new DataOutputStream(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // necessary otherwise it won't work!
            out.writeBytes(matrikelnummer + "\n");

            answerFromServer = in.readLine();
            socket.close();
            out.flush();
            in.close();
            socket.close();

            return answerFromServer;

        } catch (Exception ex) {
            return null;
        }
    }

    public String getAnswerFromServer() {

        return answerFromServer;
    }


}
