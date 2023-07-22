package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class login extends AppCompatActivity {

    TextView user, pass;
    Button login, signup;
    database DB;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
        DB = new database(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = user.getText().toString();
                String password = pass.getText().toString();
                if(username.length()==0 || password.length()==0){
                    Toast.makeText(login.this, "Please fill all", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean check = DB.checkusernamepassword(username, password);
                    if (check==true){
                            Toast.makeText(login.this, "Login Success", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(login.this,home.class));
                    }
                    else {
                        Toast.makeText(login.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this,signup.class));

            }
        });
    }
}