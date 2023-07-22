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

public class loan extends AppCompatActivity {

    Button loo;
    TextView l;
    database DB;
    String numm;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);

        loo = findViewById(R.id.loan1);
        l = findViewById(R.id.confirm11);
        DB = new database(this);


        loo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String loan = l.getText().toString();
                if (loan==null)
                {
                    loan = "0";
                }

                DB.insertbalance(loan);
                startActivity(new Intent(loan.this, home.class));

            }
        });
    }
}