package com.ramaria.androidexamplecalculogorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.sax.TextElementListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    protected TextView textPorcent;
    protected TextView textGorjeta;
    protected TextView textTotal;
    protected TextInputEditText textEditValor;
    protected SeekBar seekBarGorjeta;

    protected double porcent = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textPorcent = findViewById(R.id.textPorcent);
        textGorjeta = findViewById(R.id.textGorjeta);
        textTotal = findViewById(R.id.textTotal);
        textEditValor = findViewById(R.id.textEditValor);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);

        //listener Seekbar
        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                porcent = i;
                textPorcent.setText(Math.round(porcent) + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    public void calcular(){

        String valorRec = textEditValor.getText().toString();
        if (valorRec == null || valorRec.equals("")){
            Toast.makeText(getApplicationContext(), "Digite um valor!", Toast.LENGTH_SHORT).show();

        }else{
            double valorDig = Double.parseDouble(valorRec);
            double gorjeta = valorDig * (porcent/100);
            double total = gorjeta +valorDig;
            textGorjeta.setText("R$ " + gorjeta);
            textTotal.setText("R$ " + total);
        }

    }
}
