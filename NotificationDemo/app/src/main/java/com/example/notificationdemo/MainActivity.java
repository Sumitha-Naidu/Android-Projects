package com.example.notificationdemo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    int notifyID = 1;
    int nummessages = 0;
    Button b1,b2;
    NotificationManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.btn);
        b2 = findViewById(R.id.btn2);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nummessages += 1;
                Intent it = new Intent(MainActivity.this, Main2Activity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), it, 0);
                NotificationCompat.Builder n = new NotificationCompat.Builder(MainActivity.this)
                        .setContentTitle("Notification App")
                        .setContentText("Welcome to my Notification")
                        .setContentIntent(pendingIntent)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setNumber(nummessages)
                        .setAutoCancel(true);
                manager.notify(notifyID, n.build());
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Notification Killed",Toast.LENGTH_LONG).show();
                manager.cancel(notifyID);
            }
        });
    }
}
