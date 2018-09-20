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

public class QuizMaster extends AppCompatActivity {

    private TextView mTextMessage;
    private Intent intent;
    private Intent directIntent;
    private Button examMode;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_content:
                    intent = new Intent(getApplicationContext(), ContentMaster.class);
                    intent.putExtra("name",(getIntent().getExtras().getString("name")));
                    startActivity(intent);
                    finish();
                    return true;

                case R.id.navigation_quiz:

                    //Toast display code referenced from following website:
                    //https://www.viralandroid.com/2015/09/android-toast-example.html
                    //Regmi,P 2018 "Android Toast - How to Display Simple Toast Message in Android"
                    Toast.makeText(getApplicationContext(),"Already in quiz page", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_settings:
                    intent = new Intent(getApplicationContext(), SettingMaster.class);
                    intent.putExtra("name",(getIntent().getExtras().getString("name")));
                    startActivity(intent);
                    finish();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizmaster);
        String name = getIntent().getExtras().getString("name");
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        examMode = findViewById(R.id.examMode);
        examMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directIntent = new Intent (getApplicationContext(),QuizExamTopicSelection.class);
                startActivity(directIntent);
            }});

    }


}
