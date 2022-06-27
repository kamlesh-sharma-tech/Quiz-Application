package com.android.onlineexamination;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question1Activity extends AppCompatActivity{
    RadioGroup radioGroup;
    Button nextbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        radioGroup = findViewById(R.id.radioGroup);
        nextbtn = findViewById(R.id.nextbtn);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answerRadioButtonId = radioGroup.getCheckedRadioButtonId();
                int count = 0;
                if (answerRadioButtonId != -1) {
                    RadioButton answer = findViewById(answerRadioButtonId);
                    if (answer.getText().equals("Dr. Narendra Modi")){
                        Toast.makeText(Question1Activity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                        count = count + 5;
                    } else {
                        Toast.makeText(Question1Activity.this, "Incorrect Answer", Toast.LENGTH_SHORT).show();
                        count=0;
                    }
                    Intent intent = new Intent(Question1Activity.this,Question2Activity.class);
                    intent.putExtra("result",count);
                    startActivity(intent);
                } else {
                    Toast.makeText(Question1Activity.this, "Please select a answer", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}