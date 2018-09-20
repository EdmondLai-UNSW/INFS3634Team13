package com.example.jikook.vone;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SettingMaster extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private Button photobtn;
    private ImageView profilepic;
    private TextView mTextMessage;
    private Intent intent;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_content:
                    intent = new Intent(getApplicationContext(), MasterContentBranch.class);

                    startActivity(intent);
                    finish();
                    return true;
                case R.id.navigation_quiz:
                    intent = new Intent(getApplicationContext(), Master_Quiz.class);

                    startActivity(intent);
                    finish();
                    return true;
                case R.id.navigation_settings:
                    //Toast display code referenced from following website:
                    //https://www.viralandroid.com/2015/09/android-toast-example.html
                    //Regmi,P 2018 "Android Toast - How to Display Simple Toast Message in Android"
                    Toast.makeText(getApplicationContext(),"Already in setting page", Toast.LENGTH_SHORT).show();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingmaster);
        mTextMessage = (TextView) findViewById(R.id.message);
        profilepic = findViewById(R.id.profilepic);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        photobtn = findViewById(R.id.photobtn);

        photobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
//capture the image and setimageview
                }


        });

    }


}
