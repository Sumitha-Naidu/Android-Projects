package com.example.feedbackapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    RadioGroup rg1,rg2,rg3;
    int quality = 0,price = 0,value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button);
        rg1 = findViewById(R.id.radgrp1);
        rg2 = findViewById(R.id.radgrp2);
        rg3 = findViewById(R.id.radgrp3);

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.radioButton :
                        quality = 1;
                        break;
                    case R.id.radioButton2 :
                        quality = 2;
                        break;
                    case R.id.radioButton3 :
                        quality = 3;
                        break;
                    case R.id.radioButton4 :
                        quality = 4;
                        break;
                    case R.id.radioButton5 :
                        quality = 5;
                        break;
                }
            }
        });

        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.rb1:
                        price = 1;
                        break;
                    case R.id.rb2:
                        price = 2;
                        break;
                    case R.id.rb3:
                        price = 3;
                        break;
                    case R.id.rb4:
                        price = 4;
                        break;
                    case R.id.rb5:
                        price = 5;
                        break;
                }
            }
        });

        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.rb6:
                        value = 1;
                        break;
                    case R.id.rb7:
                        value = 2;
                        break;
                    case R.id.rb8:
                        value = 3;
                        break;
                    case R.id.rb9:
                        value = 4;
                        break;
                    case R.id.rb10:
                        value = 5;
                        break;
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Quality = "+quality+" star\nPrice = "+price+" star\nValue = "+value+" star",Toast.LENGTH_LONG).show();
            }
        });
    }
}
