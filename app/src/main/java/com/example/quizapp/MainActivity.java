package com.example.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapp.Model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4;
    TextView t1_question,timerText;

    int total=0;
    int correct =0;
    DatabaseReference reference;
    int wrong =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.btn1);
        b2 = (Button) findViewById(R.id.btn2);
        b3 = (Button) findViewById(R.id.btn3);
        b4 = (Button) findViewById(R.id.btn4);

        t1_question = (TextView) findViewById(R.id.QuestionTex);
        timerText = (TextView) findViewById(R.id.TimerTexid);


        updateQuestion();
        //change time duration
        reverseTimer(120, timerText);


    }



    //start question update

    private void updateQuestion() {

        total++;
        if (total>10)
        {
            //open the result activity
            Intent i = new Intent(MainActivity.this, ResultActivity.class);
            i.putExtra("total",String.valueOf(total));
            i.putExtra("correct",String.valueOf(correct));
            i.putExtra("incorrect",String.valueOf(wrong));
            startActivity(i);

        }
        else
            {
              reference = FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(total));
              reference.addValueEventListener(new ValueEventListener() {
                  @Override
                  public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                      final Question question = dataSnapshot.getValue(Question.class);

                      t1_question.setText(question.getQuestion());

                      b1.setText(question.getOption1());
                      b2.setText(question.getOption2());
                      b3.setText(question.getOption3());
                      b4.setText(question.getOption4());


                      b1.setOnClickListener(new View.OnClickListener() {
                          @RequiresApi(api = Build.VERSION_CODES.P)
                          @Override
                          public void onClick(View v) {
                              if (b1.getText().toString().equals(question.getAnswer()))
                              {
                                  b1.setBackgroundColor(Color.GREEN);
                                  Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                                  Handler handler = new Handler();
                                  handler.postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          correct++;
                                          b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                          updateQuestion();


                                      }
                                  }, 1500);
                              }
                              else {
                                  //answer is wrong...we will find the correct answer and make it green

                                  wrong++;
                                  Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                                  b1.setBackgroundColor(Color.RED);
                                  if (b2.getText().toString().equals(question.getAnswer())) {
                                      b2.setBackgroundColor(Color.GREEN);
                                  } else if (b3.getText().toString().equals(question.getAnswer())) {
                                      b3.setBackgroundColor(Color.GREEN);
                                  } else if (b4.getText().toString().equals(question.getAnswer())) {
                                      b4.setBackgroundColor(Color.GREEN);
                                  }

                                      Handler handler = new Handler();
                                      handler.postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                          b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                          b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                          b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                          updateQuestion();

                                      }
                                  }, 1500);


                                  }
                          }
                      });


                      b2.setOnClickListener(new View.OnClickListener() {
                          @Override
                          public void onClick(View v) {


                              if (b2.getText().toString().equals(question.getAnswer()))
                              {
                                  b2.setBackgroundColor(Color.GREEN);
                                  Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                                  Handler handler = new Handler();
                                  handler.postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          correct++;
                                          b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                          updateQuestion();


                                      }
                                  }, 1500);
                              }
                              else {
                                  //answer is wrong...we will find the correct answer and make it green

                                  wrong++;
                                  Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                                  b2.setBackgroundColor(Color.RED);
                                  if (b1.getText().toString().equals(question.getAnswer())) {
                                      b1.setBackgroundColor(Color.GREEN);
                                  } else if (b3.getText().toString().equals(question.getAnswer())) {
                                      b3.setBackgroundColor(Color.GREEN);
                                  } else if (b4.getText().toString().equals(question.getAnswer())) {
                                      b4.setBackgroundColor(Color.GREEN);
                                  }

                                  Handler handler = new Handler();
                                  handler.postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                          b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                          b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                          b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                          updateQuestion();

                                      }
                                  }, 1500);


                              }
                          }
                      });

                     b3.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {

                             if (b3.getText().toString().equals(question.getAnswer()))
                             {
                                 b3.setBackgroundColor(Color.GREEN);
                                 Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                                 Handler handler = new Handler();
                                 handler.postDelayed(new Runnable() {
                                     @Override
                                     public void run() {
                                         correct++;
                                         b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                         updateQuestion();


                                     }
                                 }, 1500);
                             }
                             else {
                                 //answer is wrong...we will find the correct answer and make it green

                                 wrong++;
                                 Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                                 b3.setBackgroundColor(Color.RED);
                                 if (b1.getText().toString().equals(question.getAnswer())) {
                                     b1.setBackgroundColor(Color.GREEN);
                                 } else if (b2.getText().toString().equals(question.getAnswer())) {
                                     b2.setBackgroundColor(Color.GREEN);
                                 } else if (b4.getText().toString().equals(question.getAnswer())) {
                                     b4.setBackgroundColor(Color.GREEN);
                                 }

                                 Handler handler = new Handler();
                                 handler.postDelayed(new Runnable() {
                                     @Override
                                     public void run() {
                                         b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                         b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                         b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                         b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                         updateQuestion();

                                     }
                                 }, 1500);


                             }
                         }
                     });


                     b4.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {

                             if (b4.getText().toString().equals(question.getAnswer()))
                             {
                                 b4.setBackgroundColor(Color.GREEN);
                                 Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                                 Handler handler = new Handler();
                                 handler.postDelayed(new Runnable() {
                                     @Override
                                     public void run() {
                                         correct++;
                                         b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                         updateQuestion();


                                     }
                                 }, 1500);
                             }
                             else {
                                 //answer is wrong...we will find the correct answer and make it green

                                 wrong++;
                                 Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                                 b4.setBackgroundColor(Color.RED);
                                 if (b1.getText().toString().equals(question.getAnswer())) {
                                     b1.setBackgroundColor(Color.GREEN);
                                 } else if (b2.getText().toString().equals(question.getAnswer())) {
                                     b2.setBackgroundColor(Color.GREEN);
                                 } else if (b3.getText().toString().equals(question.getAnswer())) {
                                     b3.setBackgroundColor(Color.GREEN);
                                 }

                                 Handler handler = new Handler();
                                 handler.postDelayed(new Runnable() {
                                     @Override
                                     public void run() {
                                         b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                         b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                         b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                         b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                         updateQuestion();

                                     }
                                 }, 1500);


                             }
                         }
                     });




                  }

                  @Override
                  public void onCancelled(@NonNull DatabaseError databaseError) {

                  }
              });
            }
    }

    //end question update

    //Start Timmer

    public void reverseTimer(int seconds, final TextView tv){
        new CountDownTimer(seconds * 1000+1000, 1000){

            public void onTick(long millisUntilFinished){
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText(String.format("%02d", minutes)
                           + ":" + String.format("%02d", seconds));

            }

            @Override
            public void onFinish() {
                tv.setText("Completed");
                Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
                myIntent.putExtra("total",String.valueOf(total));
                myIntent.putExtra("correct",String.valueOf(correct));
                myIntent.putExtra("incorrect", String.valueOf(wrong));
                startActivity(myIntent);


            }
        }.start();

    }
    //End Timmer

    //Start BackPressed end the app activity

    public  void onBackPressed(){
        AlertDialog.Builder alertDialogbuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogbuilder.setTitle("Do you want to exit?");
        alertDialogbuilder.setMessage("Do you want to exit this application");
        alertDialogbuilder.setIcon(R.drawable.ic_launcher_background);
        alertDialogbuilder.setCancelable(false);
        alertDialogbuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();

            }
        });

        alertDialogbuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogbuilder.create();
        alertDialog.show();

    }

    //End BackPressed end the app activity
}
