package com.test.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.test.library_base.base.BaseMvvmAc;
import com.test.mine.databinding.AcAboutUsBinding;

public class AboutUsAc extends BaseMvvmAc<AcAboutUsBinding,AboutUsViewModel> {

    public static void launch(Context context) {
        context.startActivity(new Intent(context, AboutUsAc.class));
    }
    @Override
    public void initViews() {
        super.initViews();
    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.ac_about_us;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}
