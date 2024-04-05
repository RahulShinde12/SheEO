package com.capcun.womenentrepreneur;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;



public class Assessment extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);

        webView = findViewById(R.id.webview);

        // Enable JavaScript (optional)
        webView.getSettings().setJavaScriptEnabled(true);

        // Load a URL into WebView
        webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSeHBjPED_6VsZ2QiNl1AU_Va7q2SUgMgHrJtcWdVo6zVRLvEA/viewform?usp=sf_link");

        // Ensure links clicked within the WebView are handled by the WebView itself
        webView.setWebViewClient(new WebViewClient());


    }
}