package com.test.login;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.test.library_base.base.BaseMvvmAc;
import com.test.library_base.base.BaseViewModel;
import com.test.library_base.constant.RouterActivityPath;
import com.test.login.databinding.AcLoginBinding;

@Route(path = RouterActivityPath.Login.PAGER_LOGIN)
public class LoginAc extends BaseMvvmAc<AcLoginBinding, BaseViewModel> {

    @Override
    protected int initContentView(Bundle savedInstanceState) {
        return R.layout.ac_login;
    }

    @Override
    protected int initVariableId() {
        return 0;
    }
}
