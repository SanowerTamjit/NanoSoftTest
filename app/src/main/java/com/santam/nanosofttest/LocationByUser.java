package com.santam.nanosofttest;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LocationByUser extends AppCompatActivity {

    FragmentManager fn = getFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_by_user);
        fn.beginTransaction().replace(R.id.contentFrame1, new showDataLoc()).commit();
        getSupportActionBar().setTitle("Person List");
    }
}
