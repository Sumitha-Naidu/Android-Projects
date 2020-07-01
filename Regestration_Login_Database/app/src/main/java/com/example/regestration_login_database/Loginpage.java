package com.example.regestration_login_database;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class Loginpage extends AppCompatActivity {
    EditText user1,pass1;
    Database d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        user1 = findViewById(R.id.ed1);
        pass1 = findViewById(R.id.ed2);
        d = new Database(this);
    }
    public void chkLogin(View view) {
        boolean b = d.chkLogin1(user1.getText().toString(),pass1.getText().toString());
        if (b == true)
            Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(), "Login Failed.", Toast.LENGTH_LONG).show();
    }
}
