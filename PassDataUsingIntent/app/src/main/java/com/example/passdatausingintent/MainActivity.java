package com.example.passdatausingintent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Intent it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText) findViewById(R.id.ed1);
        e2=(EditText) findViewById(R.id.ed2);
    }
    public void ChkLogin(View view) {
        if(e1.getText().toString().equals("Sumitha") && e2.getText().toString().equals("123")) {
            Toast.makeText(getApplicationContext(),"Login Success!!!!",Toast.LENGTH_LONG).show();
            it = new Intent(this,LoginPage.class);
            it.putExtra("Fullname",e1.getText().toString());
            startActivity(it);
        }
        else
            Toast.makeText(getApplicationContext(),"Login Failed !!!!",Toast.LENGTH_LONG).show();
    }
}
