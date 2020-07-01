package com.example.sub_menu_demo;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = findViewById(R.id.rel);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mysubmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.m1: Toast.makeText(getApplicationContext(),"You selected Settings.",Toast.LENGTH_SHORT).show();
                break;
            case R.id.m2: Toast.makeText(getApplicationContext(),"You selected Background.",Toast.LENGTH_SHORT).show();
                break;
            case R.id.m3: Toast.makeText(getApplicationContext(),"You selected Tools.",Toast.LENGTH_SHORT).show();
                break;
            case R.id.sub1: Toast.makeText(getApplicationContext(),"You selected Red Colour.",Toast.LENGTH_SHORT).show();
                relativeLayout.setBackgroundColor(Color.RED);
                break;
            case R.id.sub2: Toast.makeText(getApplicationContext(),"You selected Blue Colour.",Toast.LENGTH_SHORT).show();
                relativeLayout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.sub3: Toast.makeText(getApplicationContext(),"You selected Green Colour.",Toast.LENGTH_SHORT).show();
                relativeLayout.setBackgroundColor(Color.GREEN);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
