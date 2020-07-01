package com.example.menudemo;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    RelativeLayout r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r=(RelativeLayout)findViewById(R.id.menuex);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.m1 :
                Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_LONG).show();
                return true;
            case R.id.m2 :
                Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_LONG).show();
                return true;
            case R.id.m3 :
                Toast.makeText(getApplicationContext(), "Compose Email", Toast.LENGTH_LONG).show();
                return false;
            case R.id.m4 :
                Toast.makeText(getApplicationContext(), "Feedback", Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
