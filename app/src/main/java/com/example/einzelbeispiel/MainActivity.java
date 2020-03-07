package com.example.einzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    TextView out1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.input_txt);
        out1 = (TextView)findViewById(R.id.output_txt);
    }

    public void send(View v){
        MessageSender messageSender = new MessageSender();
        messageSender.execute(e1.getText().toString());
    }


}
