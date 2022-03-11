package com.test.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.test.library_base.base.BaseMvvmAc;
import com.test.mine.databinding.AcOpenSourceBinding;

import java.util.List;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

public class OpenSourceAc extends BaseMvvmAc<AcOpenSourceBinding, OpenSourceViewModel> {

    RvAdapterOpenSourcePro adapterOpenSourcePro;

    public static void launch(Context context) {
        context.startActivity(new Intent(context, OpenSourceAc.class));
    }

    @Override
    public void initViews() {
        super.initViews();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapterOpenSourcePro = new RvAdapterOpenSourcePro());
        viewModel.liveData.observe(this, new Observer<List<OpenSourcePro>>() {
            @Override
            public void onChanged(List<OpenSourcePro> openSourcePros) {
                adapterOpenSourcePro.setList(openSourcePros);
            }
        });
        viewModel.listData();
    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.ac_open_source;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}

