package com.example.jikook.vone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;
//these imports were referenced from a Youtube video upload by user "android-coffee.com"
//     URL: https://www.youtube.com/watch?v=aJ7BoNG-r2c

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

import static android.provider.MediaStore.Video.Thumbnails.VIDEO_ID;


public class Content_Revision extends AppCompatActivity {


    public static final String API_KEY = "???";
    public static final String Video_ID = "ZHLdVRXIuC8&index=19&t=0s&list=PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al";


    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.revisioncontent);

        YouTubePlayerView playView = findViewById(R.id.youtube_content);


        //display each topic learning content using different API,etc.



        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_content:

                    //Toast display code referenced from following website:
                    //https://www.viralandroid.com/2015/09/android-toast-example.html
                    //Regmi,P 2018 "Android Toast - How to Display Simple Toast Message in Android"
                    Toast.makeText(getApplicationContext(), "Already in content page", Toast.LENGTH_SHORT).show();

                    return true;
                case R.id.navigation_quiz:
                    intent = new Intent(getApplicationContext(), Master_Quiz.class);
                    startActivity(intent);
                    finish();
                    return true;
                case R.id.navigation_settings:
                    intent = new Intent(getApplicationContext(), SettingMaster.class);
                    startActivity(intent);
                    finish();
                    return true;
            }
            return false;
        }
    };

}


