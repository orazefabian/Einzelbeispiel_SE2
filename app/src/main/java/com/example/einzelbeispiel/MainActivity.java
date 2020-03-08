package com.example.einzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView output;
    TCP_Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.input_txt);
        output = (TextView) findViewById(R.id.output_txt);

    }



    public void sendMessageToServer(View view) {

        //get my input from the text field and send it to the server
        String matrikelnummer = input.getText().toString();
        client = new TCP_Client();
        client.setMatrikelnummer(matrikelnummer);
        client.start();

        String returnMessage = client.getAnswerFromServer();

        output.setText(returnMessage);

    }


}
