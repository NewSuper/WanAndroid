package com.test.home;

import android.os.Bundle;

import com.test.home.databinding.AcHomeBinding;
import com.test.library_base.base.BaseMvvmAc;
import com.test.library_base.base.BaseViewModel;

public class HomeAc extends BaseMvvmAc<AcHomeBinding, BaseViewModel> {

    @Override
    protected int initContentView(Bundle savedInstanceState) {
        return R.layout.ac_home;
    }

    @Override
    protected int initVariableId() {
        return 0;
    }
}
