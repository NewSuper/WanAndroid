package com.test.library_base.base;

import android.view.View;

public interface INetView {

    void showLoading();

    void showLoading(View view);

    void showSuccess();

    void showEmpty();

    void onRetryBtnClick();

}

