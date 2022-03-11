package com.test.mine;

import android.os.Bundle;

import com.test.library_base.base.BaseMvvmAc;
import com.test.library_base.base.BaseViewModel;
import com.test.mine.databinding.AcMineBinding;

public class MineAc extends BaseMvvmAc<AcMineBinding, BaseViewModel> {

    @Override
    public void beforeOnCreate() {
        super.beforeOnCreate();

    }

    @Override
    protected int initContentView(Bundle savedInstanceState) {
        return R.layout.ac_mine;
    }

    @Override
    protected int initVariableId() {
        return 0;
    }
}
