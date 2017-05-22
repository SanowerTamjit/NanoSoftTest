package com.santam.nanosofttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class TabLayout2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout2);

        WebView mGoogle = (WebView) findViewById(R.id.google) ;
        mGoogle.loadUrl("http://www.google.com");
        WebView mApple = (WebView) findViewById(R.id.apple) ;
        mGoogle.loadUrl("http://www.apple.com/");
        WebView mCnn = (WebView) findViewById(R.id.cnn) ;
        mGoogle.loadUrl("http://www.cnn.com/");
    }
}
