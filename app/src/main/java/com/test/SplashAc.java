package com.test;

import android.os.Bundle;

import com.test.databinding.AcSplashBinding;
import com.test.library_base.base.BaseMvvmAc;
import com.test.library_base.utils.MMkvHelper;
import com.test.library_base.utils.RouterUtil;

public class SplashAc extends BaseMvvmAc<AcSplashBinding,SplashViewModel>{
    @Override
    protected int initContentView(Bundle savedInstanceState) {
        return R.layout.ac_splash;
    }

    @Override
    protected int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initViews() {
        super.initViews();
        viewModel.projectListLiveData().observe(this,projectListRes -> {
            if (projectListRes.size() >0){
                MMkvHelper.getInstance().saveProjectTabs(projectListRes);
            }
        });
        viewModel.listProjectsTab();
        binding.particleview.setOnParticleAnimListener(()->{
            RouterUtil.launchMain();
            finish();
        });
        binding.particleview.startAnim();
    }
}
