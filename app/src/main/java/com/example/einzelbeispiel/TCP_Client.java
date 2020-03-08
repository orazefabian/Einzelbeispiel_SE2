package com.example.einzelbeispiel;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCP_Client extends Thread {


    private String matrikelnummer;
    private String answerFromServer;
    private DataOutputStream out;
    private BufferedReader in;
    private Socket socket = null;

    public TCP_Client(String matrikelnummer){
        this.matrikelnummer = matrikelnummer;
    }

    @Override
    public void run() {

        try {
            socket = new Socket("se2-isys.aau.at", 53212);
            out = new DataOutputStream(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.writeBytes(matrikelnummer);
            answerFromServer = in.readLine();
            out.flush();
            in.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String getAnswerFromServer() {

        return answerFromServer;
    }



}
