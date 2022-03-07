package com.test.web;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.just.agentweb.IWebLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WebLayout implements IWebLayout {

    private WebView mWebView = null;

    public WebLayout(Activity activity) {
        mWebView = (WebView) LayoutInflater.from(activity).inflate(R.layout.layout_web, null);
    }

    @NonNull
    @Override
    public ViewGroup getLayout() {
        return mWebView;
    }

    @Nullable
    @Override
    public WebView getWebView() {
        return mWebView;
    }
}