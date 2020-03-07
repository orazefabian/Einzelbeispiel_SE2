package com.example.einzelbeispiel;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MessageSender extends AsyncTask<String,Void,Void> {

    Socket socket;
    DataOutputStream out;
    PrintWriter pw;

    @Override
    protected Void doInBackground(String... voids) {

        String message = voids[0];


        try {
            socket = new Socket(InetAddress.getByName("se2-isys.aau.at"), 53212);
            pw = new PrintWriter(socket.getOutputStream());
            pw.write(message);
            pw.flush();
            pw.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
