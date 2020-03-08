package com.example.einzelbeispiel;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCP_Client extends Thread {


    String matrikelnummer;
    String answerFromServer;
    DataOutputStream out;
    BufferedReader in;


    @Override
    public void run() {

        try {
            Socket socket = new Socket("se2-isys.aau.at", 53212);
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
        //calculate given task via the calculator class
        answerFromServer = Calculator.calculate_Common_factors(matrikelnummer);
        return answerFromServer;
    }

    public void setMatrikelnummer(String matrikelnummer) {
        this.matrikelnummer = matrikelnummer;
    }


}
