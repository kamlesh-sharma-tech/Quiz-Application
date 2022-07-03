package com.android.onlineexamination;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText usernametv,passwordtv;
    Button loginbtn;
    TextView registertv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernametv = findViewById(R.id.usernametv);
        passwordtv = findViewById(R.id.passwordtv);
        loginbtn = findViewById(R.id.loginbtn);
        registertv = findViewById(R.id.registertv);
        loginbtn.setOnClickListener(this);
        registertv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.loginbtn:
                String uname = getIntent().getStringExtra("username");
                String password = getIntent().getStringExtra("password");
                if(usernametv.getText().toString().isEmpty()){
                    Toast.makeText(this, "Username cannot be empty!", Toast.LENGTH_SHORT).show();
                    usernametv.requestFocus();
                }
                else if(passwordtv.getText().toString().isEmpty()){
                    Toast.makeText(this, "Password cannot be empty!", Toast.LENGTH_SHORT).show();
                    passwordtv.requestFocus();
                }
                else if(!usernametv.getText().toString().equals(uname) || !passwordtv.getText().toString().equals(password)){
                    Toast.makeText(this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this,RulesActivity.class);
                    intent.putExtra("username",uname);
                    Toast.makeText(this, "LoggedIn Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(intent);
                }
                break;
            case R.id.registertv:
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}