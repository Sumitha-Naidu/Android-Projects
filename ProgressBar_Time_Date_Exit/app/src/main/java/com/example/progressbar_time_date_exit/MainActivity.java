package com.example.progressbar_time_date_exit;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void launchTimeTrigger(View view)
    {
        TimePickerDialog tpd;
        Calendar calendar = Calendar.getInstance();
        int hr = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int mt = calendar.get(Calendar.MONTH);
        TimePickerDialog.OnTimeSetListener tms = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(getApplicationContext(),"Time - "+hourOfDay+" : "+minute,Toast.LENGTH_LONG).show();
            }
        };
        tpd = new TimePickerDialog(this,tms,hr,min,true);
        tpd.show();
    }
    public void launchDatePicker(View view)
    {
        DatePickerDialog dpd;
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int mon = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(getApplicationContext(),"Date : "+dayOfMonth+"/"+month+"/"+year,Toast.LENGTH_LONG).show();
            }
        };
        dpd = new DatePickerDialog(this,listener,year,mon,day);
        dpd.show();
    }
    public void showProgressBar(View view)
    {
        pd = new ProgressDialog(this);
        pd.setMax(100);
        pd.setTitle("Progress Dialog");
        pd.setMessage("Loading....");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while (pd.getProgress() <= pd.getMax()){
                        Thread.sleep(2000);
                        handler.sendMessage(handler.obtainMessage());
                        if (pd.getProgress() <= pd.getMax())
                            pd.dismiss();
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    Handler handler = new Handler()
    {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            pd.incrementProgressBy(1);
        }
    };
    public void launchExit(View view)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Confirm Exit!!!!!");
        alert.setMessage("Are you sure to exit??");
        alert.setIcon(R.drawable.ic_launcher_background);
        alert.setCancelable(true);
        alert.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"You clicked on Cancel",Toast.LENGTH_SHORT);
            }
        });
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"You clicked on No",Toast.LENGTH_SHORT);
            }
        });
        //AlertDialog ad = alert.create();
        alert.show();
    }
}
