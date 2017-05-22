package com.santam.nanosofttest;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PersonData extends AppCompatActivity{


    FragmentManager fn = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_data);
        fn.beginTransaction().replace(R.id.contentFrame, new showData()).commit();
        getSupportActionBar().setTitle("Person List");

    }

}
