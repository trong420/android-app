package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    TextView user, pass, confirm;
    Button signup;
    database DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        confirm = findViewById(R.id.confirm);
        signup = findViewById(R.id.signup);
        DB = new database(this);



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = user.getText().toString();
                String password = pass.getText().toString();
                String conf = confirm.getText().toString();
                if(username.length()==0 || password.length()==0 ||conf.length()==0){
                    Toast.makeText(signup.this, "Please fill all", Toast.LENGTH_SHORT).show();
                }if(!password.equals(conf)){
                    Toast.makeText(signup.this, "Please fill correct", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkuser = DB.checkusername(username);
                    if (checkuser==false){
                        Boolean insert = DB.insertData(username, password);
                        if (insert==true){
                            Toast.makeText(signup.this, "Signup Success", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(signup.this,login.class));
                        }
                        else {
                            Toast.makeText(signup.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(signup.this, "User already exists", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}