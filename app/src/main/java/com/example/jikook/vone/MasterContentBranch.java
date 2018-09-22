package com.example.jikook.vone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MasterContentBranch extends AppCompatActivity {
//this is the master branch activity to display all learning material topic

    private Intent intent;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contentmaster);

        //display learning material here using listview
        listView = findViewById(R.id.topicSelection);
        ArrayList<String> arrayList = new ArrayList <String>(); //purely storing String in this ListView

        arrayList.add("Revision");
        arrayList.add("ArrayList");
        arrayList.add("Exception");
        arrayList.add("JavaFx");
        arrayList.add("Human center design");
        arrayList.add("Testing");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayList);  //Create arrayAdapter and take in the arrayList

        listView.setAdapter(adapter);

        //set listener for the arrayList, each row has an id, start from 0.
        //depends on which row is clicked, the int id will invoke the correspond case statement
        //and go to a specific activity that display the ACTUAL learning material

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                switch(position){
                    case 0:   //the first topic we provide is revision. this is the first row (id 0)
                        Intent intent = new Intent(view.getContext(), Content_Revision.class); //go to revision class and new activity is created there
                        startActivity(intent);
                        break;

                    case 1:
                        //  Intent intent = new Intent(view.getContext(), TopicTwo.class);
                        // startActivity(intent);
                        break;

                    case 2:
                        //  Intent intent = new Intent(view.getContext(), TopicThree.class);
                        // startActivity(intent);
                        break;

                }};
        });


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //assign the bottom navigation bar to an onclick listen, based on which icon click,
        //jump to a different activity (intent), might pass on some parameters in some case
    }
    //end of onCreate



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_content:
                    //because user already in the content page, no intent within this case block
                    //instead a message is displayed
                    Toast.makeText(getApplicationContext(), "Already in content page", Toast.LENGTH_SHORT).show();
                    //Toast display code referenced from following website:
                    //https://www.viralandroid.com/2015/09/android-toast-example.html
                    //Regmi,P 2018 "Android Toast - How to Display Simple Toast Message in Android", StackOverFlow
                    return true;

                case R.id.navigation_quiz:  //allow user to navigate to other section using explicit intent
                    intent = new Intent(getApplicationContext(), Master_Quiz.class);
                    startActivity(intent);
                    finish();  //destroy this activity to avoid backstack keeps stacking
                    return true;

                case R.id.navigation_settings:  //allow user to navigate to other section using explicit intent
                    intent = new Intent(getApplicationContext(), SettingMaster.class);
                    startActivity(intent);
                    finish(); //destroy this activity to avoid backstack keeps stacking
                    return true;
            }
            return false;
        }
    };
}


