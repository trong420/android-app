package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class balance extends AppCompatActivity {

    Button conf;
    TextView baa;
    String pay, loan, tran;
    database DB;
    String numm;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);

        conf = findViewById(R.id.backk);
        baa = findViewById(R.id.balance1);
        DB = new database(this);

        numm = DB.getbalance();
        if(numm==null)
        {
            numm = "0";
        }


        baa.setText(numm);

        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(balance.this, home.class));
            }
        });
    }
}