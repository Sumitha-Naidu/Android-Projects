package com.example.sqllitedatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Database_Helper db;
    EditText e1,e2,e3;
    Button b1,b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText) findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        db = new Database_Helper(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean chk=db.insertData(e1.getText().toString(),e2.getText().toString(),e3.getText().toString());
                if(chk == true)
                    Toast.makeText(getApplicationContext(),"Record Inserted Successfully!!",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Record not Inserted !!",Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean chk=db.updateData(e1.getText().toString(),e2.getText().toString(),e3.getText().toString());
                if(chk == true)
                    Toast.makeText(getApplicationContext(),"Record Updated Successfully!!",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Record not Updated !!",Toast.LENGTH_SHORT).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c = db.deleteData(e1.getText().toString());
                if(c > 0)
                    Toast.makeText(getApplicationContext(),"Record Deleted Successfully!!",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Record not Deleted",Toast.LENGTH_SHORT).show();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cs = db.viewData();
                if(cs.getCount()==0) {
                    showmesage("Error","Nothing Found");
                    Toast.makeText(getApplicationContext(),"No Record Found",Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    StringBuffer sb = new StringBuffer();
                    while (cs.moveToNext()) {
                        sb.append("Roll No : "+cs.getInt(0)+"\n");
                        sb.append("Name : "+cs.getString(1)+"\n");
                        sb.append("Age : "+cs.getInt(2)+"\n\n");
                    }
                    showmesage("Data",sb.toString());
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
                e2.setText("");
                e3.setText("");
            }
        });
    }
    public void showmesage(String title, String message) {
        AlertDialog.Builder ab = new AlertDialog.Builder(this);
        ab.setCancelable(true);
        ab.setTitle(title);
        ab.setMessage(message);
        ab.show();
    }
}
