package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class payment extends AppCompatActivity {

    Button with;
    TextView ch, num;
    database DB;
    String numm;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        with = findViewById(R.id.with);
        ch = findViewById(R.id.choose);
        num = findViewById(R.id.confirm8);
        DB = new database(this);


        with.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pay = num.getText().toString();
                if (pay==null)
                {
                    pay = "0";
                }
                int a = -Integer.parseInt(pay);
                String b = Integer.toString(a);
                DB.insertbalance(b);

                startActivity(new Intent(payment.this, home.class));



            }
        });
    }
}