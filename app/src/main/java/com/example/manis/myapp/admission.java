package com.example.manis.myapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Created by manis on 23-Jun-17.
 */
public class admission extends Fragment {
    ProgressBar progressBar;
    TextView tv;

    private class WebViewClientDemo extends WebViewClient {
        private WebViewClientDemo() {
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            admission.this.progressBar.setVisibility(View.INVISIBLE);
            admission.this.progressBar.setProgress(100);
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            admission.this.progressBar.setVisibility(View.VISIBLE);
            admission.this.progressBar.setProgress(0);
        }
    }

    public static boolean isNetworkStatusAvialable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo netInfos = connectivityManager.getActiveNetworkInfo();
            if (netInfos != null && netInfos.isConnected()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_admission, container, false);
        this.progressBar = (ProgressBar) v.findViewById(R.id.progressBar);
        this.tv = (TextView) v.findViewById(R.id.online_tv);
        if (isNetworkStatusAvialable(getContext())) {
            WebView myWebView = (WebView) v.findViewById(R.id.webview);
            myWebView.loadUrl("https://www.bitmesra.ac.in/Visit_Admission_Department?cid=1&deptid=11");
            myWebView.getSettings().setJavaScriptEnabled(true);
            myWebView.getSettings().setDomStorageEnabled(true);
            myWebView.setWebViewClient(new WebViewClientDemo());
        } else {
            this.progressBar.setVisibility(View.INVISIBLE);
            this.progressBar.setProgress(100);
            Toast.makeText(getContext(), "Check your Internet Connection!!", Toast.LENGTH_LONG).show();
            //this.tv.setBackgroundResource(R.drawable.onl);
        }
        return v;
    }
}
