package com.example.basic_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewPage extends AppCompatActivity
{
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_page);
    }

    public void goBack(View view)
    {
        Intent it=new Intent(this,MainActivity.class);
        startActivity(it);
    }
}
