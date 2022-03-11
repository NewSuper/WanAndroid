package com.test.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.test.library_base.base.BaseMvvmAc;
import com.test.library_base.utils.AppUtil;
import com.test.library_base.utils.LanguageUtil;
import com.test.mine.databinding.AcSettingBinding;

import java.util.Locale;

public class SettingAc extends BaseMvvmAc<AcSettingBinding, SettingViewModel> {

    public static void launch(Context context) {
        context.startActivity(new Intent(context, SettingAc.class));
    }

    @Override
    public void initViews() {
        super.initViews();
        setAcTitle(getString(R.string.mine_set));
        viewModel.register(this);
        initData();

        viewModel.getCache();
        binding.tvVersion.setText(AppUtil.getVersion(this));
    }

    private void initData() {
        viewModel.cacheData.observe(this, s -> binding.tvCache.setText(s));
        Locale currentLanguage = LanguageUtil.getCurrentLanguage();
        binding.tvLanguage.setText(String.format("%s-%s", currentLanguage.getLanguage(), currentLanguage.getCountry()));
    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.ac_setting;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}

