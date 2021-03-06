package com.test.library_network;


import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;

import com.test.library_common.AppProvider;

import androidx.annotation.NonNull;
import razerdp.basepopup.BasePopupWindow;
import razerdp.util.animation.AnimationHelper;
import razerdp.util.animation.TranslationConfig;

/**
 * 全局通用弹窗
 */
public class CommonPop extends BasePopupWindow {

    private String msg;
    private TextView textView;

    public CommonPop(String msg) {
        super(AppProvider.getInstance().getApp());
        this.msg = msg;
    }


    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.pop_common);
    }

    @Override
    public void onViewCreated(@NonNull View contentView) {
        super.onViewCreated(contentView);
        setBackgroundColor(Color.TRANSPARENT);
        textView = findViewById(R.id.text);
    }

    @Override
    public void showPopupWindow() {
        textView.setText(msg);
        super.showPopupWindow();
    }

    @Override
    protected Animation onCreateShowAnimation() {
        return AnimationHelper.asAnimation()
                .withTranslation(TranslationConfig.FROM_TOP)
                .toShow();
    }

    @Override
    protected Animation onCreateDismissAnimation() {
        return AnimationHelper.asAnimation()
                .withTranslation(TranslationConfig.TO_TOP)
                .toShow();
    }
}
