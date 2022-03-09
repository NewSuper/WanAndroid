package com.test.square;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;
import com.test.library_base.base.BaseMvvmAc;
import com.test.library_base.constant.RouterActivityPath;
import com.test.library_base.pojo.ArticleBean;
import com.test.library_base.utils.RouterUtil;
import com.test.library_network.LogUtil;
import com.test.library_widget.CustomItemDecoration;
import com.test.square.databinding.AcSquareListBinding;

import java.util.List;

import androidx.annotation.NonNull;

@Route(path = RouterActivityPath.Square.PAGER_SQUARE_LIST)
public class SquareListAc extends BaseMvvmAc<AcSquareListBinding, SquareListViewModel> implements OnRefreshLoadMoreListener {

    private String id;
    private String title;

    private RvAdapterArticleList adapterArticleList;

    @Override
    public void initViews() {
        super.initViews();
        showLoading();
        id = getIntent().getStringExtra("id");
        title = getIntent().getStringExtra("title");
        setAcTitle(title);
        LogUtil.show("id=" + id + "  title=" + title);
        adapterArticleList = new RvAdapterArticleList();
        binding.recyclerView.setAdapter(adapterArticleList);
        binding.recyclerView.addItemDecoration(new CustomItemDecoration(this,
                CustomItemDecoration.ItemDecorationDirection.VERTICAL_LIST, R.drawable.linear_split_line));
        binding.smartRefreshLayout.setEnableLoadMore(true);
        binding.smartRefreshLayout.setEnableRefresh(true);
        binding.smartRefreshLayout.setOnRefreshLoadMoreListener(this);
        adapterArticleList.setOnItemChildClickListener((adapter, view, position) -> {
            if (view.getId() == R.id.ivCollect) {
                List<ArticleBean> data = (List<ArticleBean>) adapter.getData();
                ArticleBean articleBean = data.get(position);
                if (articleBean.isCollect()) {
                    viewModel.unCollect(articleBean.getId());
                } else {
                    viewModel.collect(articleBean.getId());
                }
                articleBean.setCollect(!articleBean.isCollect());
                adapterArticleList.notifyItemChanged(position);

            }
        });
        adapterArticleList.setOnItemClickListener((adapter, view, position) -> {
            List<ArticleBean> data = (List<ArticleBean>) adapter.getData();
            RouterUtil.launchWeb(data.get(position).getLink());
        });

        viewModel.squareLiveData.observe(this, booleanListSimpleEntry -> {
            if (booleanListSimpleEntry != null) {
                List<ArticleBean> value = booleanListSimpleEntry.getValue();
                if (booleanListSimpleEntry.getKey()) {
                    adapterArticleList.setList(value);
                } else {
                    adapterArticleList.addData(value);
                }
            }
            showSuccess();
            binding.smartRefreshLayout.finishRefresh();
            binding.smartRefreshLayout.finishLoadMore();
        });
        viewModel.listArticle(true, id);

    }


    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        viewModel.listArticle(false, id);

    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        viewModel.listArticle(true, id);

    }

    @Override
    protected int initContentView(Bundle savedInstanceState) {
        return R.layout.ac_square_list;
    }

    @Override
    protected int initVariableId() {
        return BR.viewModel;
    }
}
