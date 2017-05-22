package com.santam.nanosofttest;

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

        }
        else if (v == mDataView){

        }
        else if (v == mPhonebook){

        }
        else if (v == mLocation){

        }
        else if (v == mWebview){

        }
        else if (v == mTabView){

        }

    }
}
