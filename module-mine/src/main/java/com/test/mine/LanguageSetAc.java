package com.test.mine;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.test.library_base.base.BaseMvvmAc;
import com.test.library_base.constant.RouterActivityPath;
import com.test.library_base.utils.ActivityUtil;
import com.test.library_base.utils.LanguageUtil;
import com.test.mine.databinding.AcLanguageSetBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

public class LanguageSetAc extends BaseMvvmAc<AcLanguageSetBinding,LanguageViewModel> {

    private RvAdapterLanguageSet adapter;

    @Override
    public void initViews() {
        super.initViews();
        viewModel.setTitleText(getString(R.string.mine_language_set));
        adapter = new RvAdapterLanguageSet(new ArrayList<>());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
        adapter.setListener(position -> {
            LanguageBean languageBean = adapter.getDatas().get(position);
            LanguageUtil.switchLanguage(languageBean.getLocale());
            ActivityUtil.finishAllActivity();
            ARouter.getInstance().build(RouterActivityPath.Main.PAGER_MAIN).navigation();
        });
        viewModel.languageLiveData.observe(this, new Observer<List<LanguageBean>>() {
            @Override
            public void onChanged(List<LanguageBean> languageBeans) {
                adapter.refresh(languageBeans);
            }
        });
        viewModel.getData();
    }




    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.ac_language_set;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}
