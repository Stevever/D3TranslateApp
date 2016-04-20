package com.example.ryan.d3translationapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * A placeholder fragment containing a simple view.
 */
public class ArticleActivityFragment extends Fragment {

    WebView myWebView;

	public ArticleActivityFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article, container, false);
        setupWebView(view);
        return view;
	}

    private void setupWebView(View view) {
        myWebView = (WebView) view.findViewById(R.id.webView);
        myWebView.loadUrl("http://www.cnn.com");
        myWebView.setWebChromeClient(new WebChromeClient());
        myWebView.setWebViewClient(new WebViewClient());
    }
}
