package com.example.dell.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    SeekBar seekbar;
    TextView text, text2, text3;
    RadioButton rbuton, rbuton1;
    Button buton;

    int progres = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.editText);
        seekbar = findViewById(R.id.seekBar);
        text = findViewById(R.id.textView3);
        text2 = findViewById(R.id.textsonn);
        text3 = findViewById(R.id.textson);
        buton = findViewById(R.id.button);
        rbuton = findViewById(R.id.radioButton);
        rbuton1 = findViewById(R.id.radioButton2);


        seekbar.setMax(200);
        seekbar.setProgress(progres);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                progres = i;
                text.setText("" + progres);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbuton.isChecked()) {

                    float index = 0;
                    float boy = Float.parseFloat(edit.getText().toString());
                    float ideal = (float) (50 + (2.3 / 2.54) * (boy - (152.4)));
                    boy = (boy / 100) * (boy / 100);

                    index = progres / boy;

                    text2.setText("" + ideal);

                    if (index < 20.7) {
                        text3.setText("zayıf durumdasınız.");
                        text3.setBackgroundColor(Color.RED);
                    } else if (index >= 20.7 && index < 26.4) {
                        text3.setText("normal durumdasınız");
                        text3.setBackgroundColor(Color.YELLOW);
                    } else if (index >= 26.4 && index < 31.1) {
                        text3.setText("fazla kilolusunuz");
                        text3.setBackgroundColor(Color.GREEN);
                    } else if (index >= 31.1) {
                        text3.setText("obez durumdasınız.");
                        text3.setBackgroundColor(Color.RED);
                    }
                } else {

                    float index = 0;
                    float boy = Float.valueOf(edit.getText().toString());
                    float ideal = (float) (45.5 + (2.3 / 2.54) * (boy - (152.4)));
                    boy = (boy / 100) * (boy / 100);

                    index = progres / boy;

                    text2.setText("" + ideal);

                    if (index < 19.1) {
                        text3.setText("zayıf durumdasınız.");
                        text3.setBackgroundColor(Color.RED);
                    } else if (index >= 19.1 && index < 25.8) {
                        text3.setText("normal durumdasınız");
                        text3.setBackgroundColor(Color.YELLOW);
                    } else if (index >= 25.8 && index < 32.3) {
                        text3.setText("fazla kilolusunuz");
                        text3.setBackgroundColor(Color.GREEN);
                    } else if (index >= 32.3) {
                        text3.setText("obez durumdasınız.");
                        text3.setBackgroundColor(Color.RED);
                    }
                }
            }
        });
    }
}