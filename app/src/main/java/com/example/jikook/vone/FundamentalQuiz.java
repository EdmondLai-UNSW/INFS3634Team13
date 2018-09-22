package com.example.jikook.vone;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class FundamentalQuiz extends AppCompatActivity {
    //this is the actual quiz class (topic 1 - fundamental)

TextView mark;  //the textview that displays the mark dynamically

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fundamental_quiz);

        mark = findViewById(R.id.mark);
        mark.setText(0);   //display default mark of 0, change to different values when user answer correct or wrong

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
