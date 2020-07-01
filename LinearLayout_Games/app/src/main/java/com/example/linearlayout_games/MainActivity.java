package com.example.linearlayout_games;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends Activity {
    ListView listView;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=(TextView) findViewById(R.id.t1);
        listView = findViewById(R.id.games_list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),position+"",Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0: t.setText("Candy Crush Game");
                        return;
                    case 1: t.setText("8 Ball Pool Game");
                        return;
                    case 2: t.setText("Subway Surfers Game");
                        return;
                    case 3: t.setText("Sudoku Game");
                        return;
                    case 4: t.setText("Word Search Game");
                        return;
                    case 5: t.setText("PUBG Game");
                        return;
                    case 6: t.setText("Chess Game");
                        return;
                    case 7: t.setText("Cube Game");
                        return;
                    case 8: t.setText("Ludo Game");
                        return;
                    case 9: t.setText("UNO Game");
                        return;
                }
            }
        });
    }
}
