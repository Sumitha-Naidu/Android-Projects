package com.example.activitylifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycle","onCreate Invoked");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle","onStart Invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle","onResume Invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle","onPause Invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle","onStop Invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle","onDestroy Invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle","onRestart Invoked");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Lifecycle", "onSaveInstance Invoked");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("Lifecycle", "onRestoreInstance Invoked");
    }
}
