package com.santam.nanosofttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button mEntry,mDataView,mPhonebook,mLocation,mWebview,mTabView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEntry = (Button) findViewById(R.id.btnDataEntry);
        mDataView = (Button) findViewById(R.id.btnShow);
        mPhonebook = (Button) findViewById(R.id.btnShowPhoneBook);
        mLocation = (Button) findViewById(R.id.btnLocation);
        mWebview = (Button) findViewById(R.id.btnWebview);
        mTabView = (Button) findViewById(R.id.btnTabView);


        mEntry.setOnClickListener(this);
        mDataView.setOnClickListener(this);
        mPhonebook.setOnClickListener(this);
        mLocation.setOnClickListener(this);
        mWebview.setOnClickListener(this);
        mTabView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v == mEntry){
            startActivity(new Intent(MainActivity.this, PersonEntry.class));
        }
        else if (v == mDataView){
            startActivity(new Intent(MainActivity.this, PersonData.class));
        }
        else if (v == mPhonebook){
            startActivity(new Intent(MainActivity.this, PhoneBook.class));
        }
        else if (v == mLocation){
            startActivity(new Intent(MainActivity.this, LocationByUser.class));

        }
        else if (v == mWebview){

        }
        else if (v == mTabView){
            startActivity(new Intent(MainActivity.this, TabLayout2.class));
        }

    }
}
