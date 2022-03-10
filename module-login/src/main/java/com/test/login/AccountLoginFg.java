package com.test.login;


import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.test.library_base.base.BaseMvvmFg;
import com.test.library_base.base.EventHandlers;
import com.test.library_network.PopUtil;
import com.test.login.databinding.FgAccountLoginBinding;

import androidx.annotation.Nullable;
import androidx.navigation.fragment.NavHostFragment;

/**
 * Description: 账号登录
 */
public class AccountLoginFg extends BaseMvvmFg<FgAccountLoginBinding, AccountLoginViewModel> {

    @Override
    protected void initViews() {
        super.initViews();
        binding.setEventHandlers(new AccountLoginEvent());

        viewModel.loginLiveData.observe(this, userInfo -> {
            binding.btnLogin.reset();
        });
    }

    @Override
    protected int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fg_account_login;
    }

    @Override
    protected int initVariableId() {
        return BR.viewModel;
    }


    private void login() {
        String username = binding.etAccount.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            PopUtil.show("请输入账号");
            return;
        }
        String password = binding.etPassword.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            PopUtil.show("请输入密码");
            return;
        }

        binding.btnLogin.startAnim();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                viewModel.login(username, password);
            }
        }, 2000);

    }

    @Override
    public void onStop() {
        super.onStop();
        binding.btnLogin.reset();
    }

    public class AccountLoginEvent extends EventHandlers {
        public void onRegisterClick(){
            NavHostFragment.findNavController(AccountLoginFg.this).navigate(R.id.action_fragment_register);
        }
        public void onLoginClick(){
            login();
        }
    }
}
