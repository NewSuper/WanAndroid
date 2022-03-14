package com.test.project;

import android.os.Bundle;

import com.test.library_base.base.BaseMvvmAc;
import com.test.library_base.base.BaseViewModel;
import com.test.project.databinding.AcProjectBinding;

public class ProjectAc extends BaseMvvmAc<AcProjectBinding, BaseViewModel> {

    @Override
    protected int initContentView(Bundle savedInstanceState) {
        return R.layout.ac_project;
    }

    @Override
    protected int initVariableId() {
        return 0;
    }
}
