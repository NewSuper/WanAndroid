package com.test;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class VpAdapterMain extends FragmentPagerAdapter {

    private TabPagerListener listener;

    public void setListener(TabPagerListener listener) {
        this.listener = listener;
    }

    public VpAdapterMain(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listener.getFragment(position);
    }

    @Override
    public int getCount() {
        return listener.count();
    }
}
