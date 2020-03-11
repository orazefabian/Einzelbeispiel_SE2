package com.example.einzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.reactivestreams.Subscription;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


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
                String matrikelnummer = input.getText().toString();
                Flowable.fromCallable(() -> sendToServer(matrikelnummer))
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.single())
                        .subscribe(s -> runOnUiThread(() -> output.setText(s)));

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

    private String sendToServer(String matrikelnummer) {
        TCP_Client client = new TCP_Client(matrikelnummer);
        client.connectToServer();
        return client.getAnswerFromServer();
    }


}
