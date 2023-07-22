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

public class transfer extends AppCompatActivity {

    Button trans;
    TextView tr;
    database DB;
    String numm;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        trans = findViewById(R.id.tranfer1);
        tr = findViewById(R.id.tranfer);
        DB = new database(this);


        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tran = tr.getText().toString();
                if (tran==null)
                {
                    tran = "0";
                }

                int a = -Integer.parseInt(tran);
                String b = Integer.toString(a);
                DB.insertbalance(b);
                startActivity(new Intent(transfer.this, home.class));

            }
        });
    }
}