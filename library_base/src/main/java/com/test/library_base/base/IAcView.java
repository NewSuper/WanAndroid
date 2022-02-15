package com.test.library_base.base;

import android.os.Bundle;

public interface IAcView {
    void initViews();
    void initEvents();
    void beforeOnCreate();
    void afterOnCreate(Bundle savedInstanceState);
    void initImmersionBar();
}
