package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class password extends AppCompatActivity {

    Button pass;
    TextView neww, conf, use;
    database DB;
    String user;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        pass = findViewById(R.id.pass3);
        neww = findViewById(R.id.newpass);
        conf = findViewById(R.id.conf1);
        use = findViewById(R.id.username1);
        DB = new database(this);



        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = neww.getText().toString();
                String match = conf.getText().toString();
                String username = use.getText().toString();

                if(password.equals(match)){
                    int check = DB.updatepassword(username, password);
                    if (check == 1)
                    {
                        startActivity(new Intent(password.this,login.class));
                    }
                    else {
                        Toast.makeText(password.this, "Password Not Change", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(password.this, "Password Not Match", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}