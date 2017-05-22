package com.santam.nanosofttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TabHost;

public class TabLayout2 extends AppCompatActivity {

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout2);


        WebView mGoogle = (WebView) findViewById(R.id.google) ;
        String url="http://www.google.com";
        mGoogle.setWebViewClient(new MyBrowser());
        mGoogle.getSettings().setJavaScriptEnabled(true);
        mGoogle.getSettings().setLoadsImagesAutomatically(true);
        mGoogle.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mGoogle.loadUrl(url);

        WebView mApple = (WebView) findViewById(R.id.apple) ;
        String url1="http://www.apple.com";
        mApple.setWebViewClient(new MyBrowser());
        mApple.getSettings().setJavaScriptEnabled(true);
        mApple.getSettings().setLoadsImagesAutomatically(true);
        mApple.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mApple.loadUrl(url1);

        WebView mCnn = (WebView) findViewById(R.id.cnn) ;
        String url2="http://www.cnn.com";
        mCnn.setWebViewClient(new MyBrowser());
        mCnn.getSettings().setJavaScriptEnabled(true);
        mCnn.getSettings().setLoadsImagesAutomatically(true);
        mCnn.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mCnn.loadUrl(url2);



        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.Google);
        spec.setIndicator("Google");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.Apple);
        spec.setIndicator("Apple");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.CNN);
        spec.setIndicator("CNN");
        host.addTab(spec);
    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
