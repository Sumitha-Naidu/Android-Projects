package com.example.radiobuttondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    RadioGroup rg1;
    RadioButton rb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.btn);
        rg1=findViewById(R.id.rg);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sc=rg1.getCheckedRadioButtonId();
                rb1=findViewById(sc);
                Toast.makeText(getApplicationContext(),rb1.getText(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
