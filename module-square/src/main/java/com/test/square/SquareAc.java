package com.test.square;

import android.os.Bundle;

import com.test.library_base.base.BaseMvvmAc;
import com.test.library_base.base.BaseViewModel;
import com.test.square.databinding.AcSquareBinding;

public class SquareAc extends BaseMvvmAc<AcSquareBinding, BaseViewModel> {

    @Override
    protected int initContentView(Bundle savedInstanceState) {
        return R.layout.ac_square;
    }

    @Override
    protected int initVariableId() {
        return 0;
    }
}
