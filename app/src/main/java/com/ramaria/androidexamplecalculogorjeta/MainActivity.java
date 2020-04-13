package com.ramaria.androidexamplecalculogorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.sax.TextElementListener;
import android.widget.SeekBar;
import android.widget.TextView;

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
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
