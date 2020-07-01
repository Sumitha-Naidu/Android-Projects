package com.example.regestration_login_database;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText name,user,age,dob,pass;
    RadioGroup rg;
    RadioButton rb;
    Database d;
    String g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editText2);
        age = findViewById(R.id.editText3);
        dob = findViewById(R.id.editText);
        user = findViewById(R.id.editText4);
        pass = findViewById(R.id.editText5);
        rg = (RadioGroup) findViewById(R.id.rg1);
        rb = (RadioButton)findViewById(rg.getCheckedRadioButtonId());
        d = new Database(this);
    }
    public void register(View view) {
        String n = name.getText().toString();
        String a = age.getText().toString();
        String db = dob.getText().toString();
        String u = user.getText().toString();
        String p = pass.getText().toString();
        boolean res = d.insertData(n, a, g, db, u, p);
        if(res == true)
            Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(),"Error occured while Registering.",Toast.LENGTH_LONG).show();
    }
    public void onclickbuttonMethod(View v){
        int selectedId = rg.getCheckedRadioButtonId();
        rb = (RadioButton) findViewById(selectedId);
        if(selectedId==-1){ }
        else
            g = rb.getText().toString();
    }
    public void login(View view) {
        Intent it = new Intent(this,Loginpage.class);
        startActivity(it);
    }
}
