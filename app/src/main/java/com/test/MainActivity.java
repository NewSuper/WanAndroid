package com.test;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.test.databinding.ActivityMainBinding;
import com.test.library_base.base.BaseMvvmAc;
import com.test.library_base.base.BaseViewModel;
import com.test.library_base.constant.RouterActivityPath;
import com.test.library_widget.bubblenavigation.BubbleNavigationChangeListener;

import androidx.fragment.app.Fragment;

@Route(path = RouterActivityPath.Main.PAGER_MAIN)
public class MainActivity extends BaseMvvmAc<ActivityMainBinding, BaseViewModel> implements BubbleNavigationChangeListener, TabPagerListener {
    @Override
    protected boolean canSwipeBack() {
        return false;
    }

    @Override
    public void initViews() {
        initTab();

        initNav();

        requestPermissions(
                "android.permission.WRITE_EXTERNAL_STORAGE",
                "android.permission.READ_EXTERNAL_STORAGE"
        );
    }


    private void initNav() {
        binding.bottomNavigationViewLinear.setTypeface(Typeface.createFromAsset(getAssets(), "rubik.ttf"));
        binding.bottomNavigationViewLinear.setBadgeValue(0, null);
        binding.bottomNavigationViewLinear.setBadgeValue(1, null); //invisible badge
        binding.bottomNavigationViewLinear.setBadgeValue(2, null);
        binding.bottomNavigationViewLinear.setBadgeValue(3, null);
        binding.bottomNavigationViewLinear.setBadgeValue(4, null); //empty badge
        binding.bottomNavigationViewLinear.setNavigationChangeListener(this);
    }

    private void initTab() {
        VpAdapterMain adapterMain = new VpAdapterMain(getSupportFragmentManager());
        adapterMain.setListener(this);
        binding.viewPager.setOffscreenPageLimit(5);
        binding.viewPager.setScrollable(false);
        binding.viewPager.setAdapter(adapterMain);
    }


    @Override
    public void onNavigationChanged(View view, int position) {
        binding.viewPager.setCurrentItem(position, false);
    }

    /**
     * 用户按返回 按钮不关闭页面
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            home.addCategory(Intent.CATEGORY_HOME);
            startActivity(home);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public Fragment getFragment(int position) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    protected int initContentView(Bundle savedInstanceState) {
        return 0;
    }

    @Override
    protected int initVariableId() {
        return 0;
    }
}
