package com.example.callingapplication;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
EditText e1;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editText);
        b1=(Button)findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Intent.ACTION_CALL);
                String ph = "";
                if(e1.getText().length() == 10) {
                    if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 100);
                        return;
                    }
                    ph = "tel:" + e1.getText().toString();
                    it.setData(Uri.parse(ph));
                    Toast.makeText(getApplicationContext(), e1.getText().toString(), Toast.LENGTH_LONG).show();
                    startActivity(it);
                }
                else
                    Toast.makeText(getApplicationContext(),"Enter Valid Phone Number", Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            Toast.makeText(MainActivity.this,"Phone Permission Granted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this,"Phone Permission Denied", Toast.LENGTH_SHORT).show();
    }
}
