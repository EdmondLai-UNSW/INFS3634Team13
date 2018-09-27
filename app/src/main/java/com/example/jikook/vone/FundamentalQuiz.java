package com.example.jikook.vone;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FundamentalQuiz extends AppCompatActivity {
    //this is the actual quiz class (topic 1 - fundamental)

TextView mark;  //the textview that displays the mark dynamically
TextView question;
static int score = 0;
static int questionNo = 1;
static int correctAns = 0;
static int wrongAns = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fundamental_quiz);
        mark = findViewById(R.id.mark);
        mark.setText(Integer.toString(score));   //display default mark of 0, change to different values when user answer correct or wrong

       question = findViewById(R.id.questionBox);


        String[] myArray = getResources().getStringArray(R.array.fund_quiz);

        question.setText(myArray[0]);

        for(;questionNo <= 10;questionNo++){

            //each time user answer a questio, show them which question they are on and update the score
        }

        //display quiz content (using fragment /arraylist??????)
        //
        //
        //
        //

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

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
                    Toast.makeText(getApplicationContext(),"Within a quiz already!", Toast.LENGTH_SHORT).show();
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
