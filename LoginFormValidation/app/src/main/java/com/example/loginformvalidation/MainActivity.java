package com.example.loginformvalidation;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
    }
    public void validateLogin(View view) {
        if(e1.getText().toString().equals("admin") && e2.getText().toString().equals("12345"))
            Toast.makeText(getApplicationContext(),"Correct Username and Password!!!",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(),"Incorrect Username and Password!!!",Toast.LENGTH_LONG).show();
    }
}
