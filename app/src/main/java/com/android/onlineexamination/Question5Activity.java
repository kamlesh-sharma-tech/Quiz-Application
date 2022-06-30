package com.android.onlineexamination;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question5Activity extends AppCompatActivity {
    RadioGroup radioGroup;
    Button nextbtn;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        radioGroup = findViewById(R.id.radioGroup);
        nextbtn = findViewById(R.id.nextbtn);
        Intent intent = getIntent();
        count = intent.getIntExtra("result",0);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answerRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (answerRadioButtonId != -1) {
                    RadioButton answer = findViewById(answerRadioButtonId);
                    if (answer.getText().equals("Mark Zuckerburg")){
                        Toast.makeText(Question5Activity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                        count = count + 5;
                    } else {
                        Toast.makeText(Question5Activity.this, "Incorrect Answer", Toast.LENGTH_SHORT).show();
                        count = count - 5;
                    }
                    Intent intent = new Intent(Question5Activity.this,ResultActivity.class);
                    intent.putExtra("result",count);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Question5Activity.this, "Please select a answer", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}