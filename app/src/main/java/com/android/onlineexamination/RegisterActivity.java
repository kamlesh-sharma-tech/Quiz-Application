package com.android.onlineexamination;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    EditText usernametv,passwordtv;
    Button registerbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        usernametv = findViewById(R.id.usernametv);
        passwordtv = findViewById(R.id.passwordtv);
        registerbtn = findViewById(R.id.registerbtn);
        registerbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.registerbtn:
                String uname = usernametv.getText().toString();
                String pass = passwordtv.getText().toString();
               if(uname.isEmpty()){
                   Toast.makeText(this, "Username cannot be empty!", Toast.LENGTH_SHORT).show();
                   usernametv.setFocusable(true);
               }else if(pass.isEmpty()){
                   Toast.makeText(this, "Password cannot be empty!", Toast.LENGTH_SHORT).show();
                   passwordtv.setFocusable(true);
               }
                else {
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    intent.putExtra("username",uname);
                    intent.putExtra("password",pass);
                    Toast.makeText(this, "Registered Successfully! You can now login.", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                    break;
                }
        }
    }
}