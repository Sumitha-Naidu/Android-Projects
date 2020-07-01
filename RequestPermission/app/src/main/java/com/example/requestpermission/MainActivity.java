package com.example.requestpermission;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Button b1, b2, b3, b4;
    private static final int CAMERA = 100;
    private static final int CALENDAR = 101;
    private static final int CONTACTS = 102;
    private static final int STORAGE = 103;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission(Manifest.permission.CAMERA,CAMERA);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission(Manifest.permission.READ_CONTACTS,CONTACTS);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission(Manifest.permission.READ_CALENDAR,CALENDAR);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE,STORAGE);
            }
        });
    }
    public void checkPermission(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission) == PackageManager.PERMISSION_DENIED)
        {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, requestCode);
        } else {
            Toast.makeText(MainActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case 100 :
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(MainActivity.this,"Camera Permission Granted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Camera Permission Denied", Toast.LENGTH_SHORT).show();
                return;
            case 101 :
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(MainActivity.this,"Calendar Permission Granted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Calendar Permission Denied", Toast.LENGTH_SHORT).show();
                return;
            case 102 :
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(MainActivity.this,"Contacts Permission Granted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Contacts Permission Denied", Toast.LENGTH_SHORT).show();
                return;
            case 103 :
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(MainActivity.this,"Storage Permission Granted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Storage Permission Denied", Toast.LENGTH_SHORT).show();
                return;
        }
    }
}
