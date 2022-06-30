package com.android.onlineexamination;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity{
    TextView resulttv;
    Button exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resulttv = findViewById(R.id.resulttv);
        exitBtn = findViewById(R.id.exitBtn);

        Intent intent = getIntent();
        resulttv.setText("Your Score is : "+intent.getIntExtra("result",0));

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}