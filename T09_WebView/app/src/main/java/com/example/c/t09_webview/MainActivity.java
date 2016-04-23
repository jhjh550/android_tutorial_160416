package com.example.c.t09_webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WebView webView = (WebView) findViewById(R.id.webView);

        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.naver.com");

        Button btn = (Button) findViewById(R.id.btnLoad);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editUrl = (EditText) findViewById(R.id.editURL);
                String str = editUrl.getText().toString();
                webView.loadUrl(str);
            }
        });
    }
}
