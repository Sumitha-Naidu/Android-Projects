package com.example.basic_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText e1,e2;
    Button b1,b2,b3,b4;
    int n1,n2,res;
    TextView t1;
    Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.ed1);
        e2=findViewById(R.id.ed2);
        b1=findViewById(R.id.bt1);
        b2=findViewById(R.id.bt2);
        b3=findViewById(R.id.btn3);
        b4=findViewById(R.id.btn4);
        t1=findViewById(R.id.textView3);
    }

    public void addNum(View view)
    {
        try
        {
            n1 = Integer.parseInt(e1.getText().toString());
            n2 = Integer.parseInt(e2.getText().toString());
            res = n1 + n2;
            //Toast.makeText(getApplicationContext(),"Addition is : "+res,Toast.LENGTH_LONG).show();
            //t1.setText("Addition is  : "+res);
            it = new Intent(this, NewPage.class);
            startActivity(it);
        }
        catch (Exception ex)
        {
            t1.setText(ex.getMessage());
        }
    }

    public void subNum(View view)
    {
        try
        {
        n1=Integer.parseInt(e1.getText().toString());
        n2=Integer.parseInt(e2.getText().toString());
        res=n1-n2;
        //Toast.makeText(getApplicationContext(),"Subtraction is : "+res,Toast.LENGTH_LONG).show();
        t1.setText("Subtraction is  : "+res);
        }
        catch (Exception ex)
        {
            t1.setText(ex.getMessage());
        }
    }

    public void mulNum(View view)
    {
        try {
            n1 = Integer.parseInt(e1.getText().toString());
            n2 = Integer.parseInt(e2.getText().toString());
            res = n1 * n2;
            //Toast.makeText(getApplicationContext(),"Multiplication is : "+res,Toast.LENGTH_LONG).show();
            t1.setText("Multiplication is  : " + res);
        }
        catch (Exception ex)
        {
            t1.setText(ex.getMessage());
        }
    }

    public void divNum(View view)
    {
        try
        {
        n1=Integer.parseInt(e1.getText().toString());
        n2=Integer.parseInt(e2.getText().toString());
        res=n1/n2;
        //Toast.makeText(getApplicationContext(),"DIvision is : "+res,Toast.LENGTH_LONG).show();
        t1.setText("Division is  : "+res);
        }
        catch (Exception ex)
        {
            t1.setText(ex.getMessage());
        }
    }

    public void modNum(View view)
    {
        try {
            n1 = Integer.parseInt(e1.getText().toString());
            n2 = Integer.parseInt(e2.getText().toString());
            res = n1 % n2;
            //Toast.makeText(getApplicationContext(),"DIvision is : "+res,Toast.LENGTH_LONG).show();
            t1.setText("Remainder is  : " + res);
        }
        catch (Exception ex)
        {
            t1.setText(ex.getMessage());
        }
    }

}
