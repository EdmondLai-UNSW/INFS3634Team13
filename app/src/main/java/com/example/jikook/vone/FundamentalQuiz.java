package com.example.jikook.vone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class FundamentalQuiz extends AppCompatActivity {
    //this is the actual quiz class (topic 1 - fundamental)

    TextView mark;  // display the current mark
    TextView question;  // /display the current question
    Button ansA;   //Button for mcq choice
    Button ansB;
    Button ansC;
    Button ansD;
    Button next;
    Button quitBtn;  //return menu button to return to quiz master branch
    Intent intent;
    TextView feedback; // display each question feedback
    TextView result; // used to display final result at the end
    TextView qno;   //keep track of question no.

    static int score = 0;
    static int questionNo = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fundamental_quiz);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        result = findViewById(R.id.result);
        mark = findViewById(R.id.mark);
        feedback = findViewById(R.id.feedback);
        question = findViewById(R.id.questionBox);
        quitBtn = findViewById(R.id.quitBtn);
        qno = findViewById(R.id.qno);
        ansA = findViewById(R.id.ansA);
        ansB = findViewById(R.id.ansB);
        ansC = findViewById(R.id.ansC);
        ansD = findViewById(R.id.ansD);
        next = findViewById(R.id.next);  //above codes are just all set up

        result.setVisibility(View.INVISIBLE);
        quitBtn.setVisibility(View.INVISIBLE);  //result and return menu botton are set invisible until all 10 questions are answered

        mark.setText(Integer.toString(score));   //display default mark of 0, change to different values when user answer correct or wrong

         //unique xml string values file for each topic question
        String[] myArrayQuestion = getResources().getStringArray(R.array.fund_quiz_question);
        //unique xml string values file for each topic answer
        final String[] myArrayAnswer = getResources().getStringArray(R.array.fund_quiz_answer);

        for (; questionNo <= 10; questionNo++) {  ////****the problem is the loop finished itself when first started)
            qno.setText(Integer.toString(questionNo));  //each round, update question number
            next.setVisibility(View.INVISIBLE);   //each round begins, the next question bottom should be invisible
            feedback.setText(" ");  //clear feedback textview when go to a new question
            mark.setText(Integer.toString(score));  //update score

            if (questionNo < 10) {    //if question number tracking is less than 10, run  the switch, otherwise run else if
                switch (questionNo) {
                    case 1:
                        ////////need to do something to stop the loop until user click an answer

                        question.setText(myArrayQuestion[0]);
                        ansA.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                //correct answer + 10 marks
                                score = +10;
                                feedback.setText("Correct");
                                next.setVisibility(View.VISIBLE);


                            }
                        });


                ;


            ansB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //wrong answer 0 marks
                    feedback.setText(myArrayAnswer[0]);
                    next.setVisibility(View.VISIBLE);
                }
            });
            ansC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ///wrong answer 0 marks
                    feedback.setText(myArrayAnswer[0]);
                    next.setVisibility(View.VISIBLE);
                }
            });
            ansD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ///wrong answer 0 marks
                    feedback.setText(myArrayAnswer[0]);
                    next.setVisibility(View.VISIBLE);
                }
            });

            break; //end of case 1


        }//end of switch statement
    }//end of if section of the if-else statment

            //when all ten questions been answered
            else {
                result.setVisibility(View.VISIBLE);
                quitBtn.setVisibility(View.VISIBLE);
                if (score < 50)
                    question.setText("Your total mark is " + score + ". FAIL");
                else if (score < 65) {
                    question.setText("Your total mark is " + score + ". PASS");
                } else if (score < 75) {
                    question.setText("Your total mark is " + score + ". Credit");
                } else if (score < 85)
                    question.setText("Your total mark is " + score + ". Distinction");
                else if (score < 100)
                    question.setText("Your total mark is " + score + ". High Distinction");

                else question.setText("You have scored an HD faultless.");

                quitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intent = new Intent(getApplicationContext(), Master_Quiz.class);
                        startActivity(intent);
                    }
                });

            }

        }



    }


    //dont tamper code below unless for the pop up warning 

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_content:

                    //warning pop up, if click, user lose current progress
                    finish();
                    return true;


                case R.id.navigation_quiz:
                    //Toast display code referenced from following website:
                    //https://www.viralandroid.com/2015/09/android-toast-example.html
                    //Regmi,P 2018 "Android Toast - How to Display Simple Toast Message in Android"
                    Toast.makeText(getApplicationContext(), "Within a quiz already!", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_settings:

                    //warning pop up, if click, user lose current progress
                    finish();
                    return true;
            }
            return false;
        }
    };
}
