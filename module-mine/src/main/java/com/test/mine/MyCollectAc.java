package com.test.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;
import com.test.library_base.base.BaseMvvmAc;
import com.test.library_base.pojo.ArticleBean;
import com.test.library_base.utils.RouterUtil;
import com.test.library_widget.CustomItemDecoration;
import com.test.mine.databinding.AcMyCollectBinding;

import java.util.List;

public class MyCollectAc extends BaseMvvmAc<AcMyCollectBinding, MyCollectViewModel> implements OnRefreshLoadMoreListener {

    private RvAdapterArticleList adapterArticleList;

    public static void launch(Context context) {
        context.startActivity(new Intent(context, MyCollectAc.class));
    }

    @Override
    public void initViews() {
        super.initViews();

        adapterArticleList = new RvAdapterArticleList();
        binding.recyclerView.setAdapter(adapterArticleList);
        binding.recyclerView.addItemDecoration(new CustomItemDecoration(this,
                CustomItemDecoration.ItemDecorationDirection.VERTICAL_LIST, R.drawable.linear_split_line));
        adapterArticleList.setOnItemClickListener((adapter, view, position) -> {
            List<ArticleBean> data = (List<ArticleBean>) adapter.getData();
            RouterUtil.launchWeb(data.get(position).getLink());
        });
        adapterArticleList.setOnItemChildClickListener((adapter, view, position) -> {
            if (view.getId() == R.id.ivCollect) {
                List<ArticleBean> data = (List<ArticleBean>) adapter.getData();
                ArticleBean articleBean = data.get(position);
                viewModel.unCollect(articleBean.getId());
                adapterArticleList.cancelCollect(position);
            }
        });
        binding.smartRefreshLayout.setOnRefreshLoadMoreListener(this);

        viewModel.collectLiveData.observe(this, articleBeans -> {
            if (articleBeans != null) {
                Boolean key = articleBeans.getKey();
                List<ArticleBean> value = articleBeans.getValue();
                if (key) {
                    adapterArticleList.setList(value);
                } else {
                    adapterArticleList.addData(value);
                }
            }
            binding.smartRefreshLayout.finishLoadMore();
            binding.smartRefreshLayout.finishRefresh();
            if (adapterArticleList.getData().size() <= 0) {
                showEmpty();
            } else {
                showSuccess();
            }
        });

        showLoading(binding.smartRefreshLayout);
        viewModel.listMyCollect(true);
    }


    @Override
    public void onRetryBtnClick() {
        showLoading();
        viewModel.listMyCollect(true);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        viewModel.listMyCollect(false);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        viewModel.listMyCollect(true);
    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.ac_my_collect;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}
