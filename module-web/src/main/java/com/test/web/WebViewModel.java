package com.test.web;

import android.app.Application;

import com.test.library_base.base.BaseViewModel;

import androidx.annotation.NonNull;

public class WebViewModel extends BaseViewModel<WebRepository> {
    public WebViewModel(@NonNull Application application) {
        super(application);
    }
}

