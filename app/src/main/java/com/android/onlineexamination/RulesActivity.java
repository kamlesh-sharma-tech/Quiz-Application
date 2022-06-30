package com.android.onlineexamination;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RulesActivity extends AppCompatActivity{
    TextView usernametv;
    Button startbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        usernametv = findViewById(R.id.usernametv);
        startbtn = findViewById(R.id.startbtn);
        usernametv.setText("Welcome, "+getIntent().getStringExtra("username"));
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RulesActivity.this,Question1Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}