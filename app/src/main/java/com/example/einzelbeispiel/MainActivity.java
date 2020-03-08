package com.example.einzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView output;
    Button send;
    Button calc;
    TextView outputCalc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.input_txt);
        output = (TextView) findViewById(R.id.output_txt);
        send = (Button) findViewById(R.id.btn_send);
        calc = (Button) findViewById(R.id.btn_calc);
        outputCalc = (TextView) findViewById(R.id.output_calc_text);

        //create actions when send and calc button are pressed
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToServer();
            }
        });
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateOutput();
            }
        });


    }

    private void calculateOutput() {

        String matrikelnummer = input.getText().toString();
        outputCalc.setText(Calculator.calculate_Common_factors(matrikelnummer));

    }

    private void sendToServer() {
        TCP_Client client = new TCP_Client(input.getText().toString());
        client.start();
        try {
            client.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        output.setText(client.getAnswerFromServer());

    }


}
