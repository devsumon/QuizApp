package com.example.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t1 = (TextView)findViewById(R.id.totalquestionid);
        t2 = (TextView)findViewById(R.id.correctanswerid);
        t3 = (TextView)findViewById(R.id.wronganswerid);

        Intent i =getIntent();

        String questions = i.getStringExtra("total");
        String correct   = i.getStringExtra("correct");
        String wrong     = i.getStringExtra("wrong");

        t1.setText(questions);
        t2.setText(correct);
        t3.setText(wrong);

    }


}
