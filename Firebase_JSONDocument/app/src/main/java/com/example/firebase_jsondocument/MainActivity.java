package com.example.firebase_jsondocument;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    FirebaseDatabase fb;
    DatabaseReference dr;
    Employee e;
    AlertDialog.Builder ab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.ed1);
        e2 = findViewById(R.id.ed2);
        e3 = findViewById(R.id.ed3);
        fb =FirebaseDatabase.getInstance();
        dr = fb.getReference();
    }
    public void createJSONDoc(View view) {
        e = new Employee(e1.getText().toString(),e2.getText().toString(),e3.getText().toString());
        dr.child("Employee1").setValue(e);
        Toast.makeText(getApplicationContext(),"Data Inserted Successfully into Firebase Database.",Toast.LENGTH_SHORT).show();
    }
    public void retrieveDoc(View view) {
        ab = new AlertDialog.Builder(MainActivity.this);
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Employee emp = null;
                for(DataSnapshot data : dataSnapshot.getChildren()) {
                    emp = data.getValue(Employee.class);
                }
                ab.setCancelable(true);
                ab.setTitle("Data");
                ab.setMessage(emp.getId()+"\n"+emp.getName()+"\n"+emp.getSalary());
                ab.show();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });
    }
}