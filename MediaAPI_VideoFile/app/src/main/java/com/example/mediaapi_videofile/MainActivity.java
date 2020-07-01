package com.example.mediaapi_videofile;
import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
public class MainActivity extends AppCompatActivity {
    VideoView v1;
    MediaController mc;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v1 = findViewById(R.id.videoView2);
        b1 = findViewById(R.id.button);
        mc = new MediaController(this);
        mc.setAnchorView(v1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Playing Video",Toast.LENGTH_SHORT).show();
                v1.setMediaController(mc);
                v1.setVideoURI(Uri.parse("/storage/sdcard1/Sumitha/kannodakannodu.mp4"));//Give your path here
                v1.requestFocus();
                v1.start();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }
}
