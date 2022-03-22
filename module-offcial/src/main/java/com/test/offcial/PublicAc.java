package com.test.offcial;

import android.os.Bundle;

import com.test.library_base.base.BaseMvvmAc;
import com.test.library_base.base.BaseViewModel;
import com.test.offcial.databinding.AcPublicBinding;

public class PublicAc extends BaseMvvmAc<AcPublicBinding, BaseViewModel> {

    @Override
    protected int initContentView(Bundle savedInstanceState) {
        return R.layout.ac_public;
    }

    @Override
    protected int initVariableId() {
        return 0;
    }
}
