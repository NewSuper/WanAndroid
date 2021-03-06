package com.test.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.simple.SimpleMultiListener;
import com.test.home.databinding.FgHomeBinding;
import com.test.library_base.base.BaseMvvmFg;
import com.test.library_base.base.EventHandlers;
import com.test.library_base.constant.RouterFragmentPath;
import com.test.library_base.pojo.ArticleBean;
import com.test.library_base.pojo.BannerRes;
import com.test.library_network.LogUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

@Route(path = RouterFragmentPath.Home.PAGER_HOME)
public class HomeFg extends BaseMvvmFg<FgHomeBinding, HomeViewModel> {

    private VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getActivity());
    private DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager);
    private final ArrayList<DelegateAdapter.Adapter> adapters = new ArrayList<>();


    private List<BannerRes> bannerResList = new ArrayList<>();
    private HomeBannerAdapter homeBannerAdapter = new HomeBannerAdapter(bannerResList);

    private List<ArticleBean> articleListResList = new ArrayList<>();
    private HomeArticleAdapter homeArticleAdapter = new HomeArticleAdapter(articleListResList);

    @Override
    protected boolean immersionBar() {
        return true;
    }

    @Override
    protected void initViews() {
        binding.setEventHandlers(new HomeEvent());
        adapters.add(homeBannerAdapter);
        adapters.add(homeArticleAdapter);
        delegateAdapter.setAdapters(adapters);
        binding.recyclerView.setLayoutManager(virtualLayoutManager);
        binding.recyclerView.setAdapter(delegateAdapter);

        initEvents();

        showLoading(binding.root);
        viewModel.bannerLiveData.observe(this, bannerRes -> {
            bannerResList.clear();
            bannerResList.addAll(bannerRes);
            homeBannerAdapter.notifyDataSetChanged();
        });
        viewModel.getBanner();
        viewModel.liveData.observe(this, booleanListSimpleEntry -> {
            if (booleanListSimpleEntry != null) {
                if (booleanListSimpleEntry.getKey()) {
                    articleListResList.clear();
                }
                articleListResList.addAll(booleanListSimpleEntry.getValue());
                LogUtil.show("articleListResList=" + articleListResList.size());
                homeArticleAdapter.notifyDataSetChanged();
            }
            showSuccess();
            binding.refreshLayout.finishRefresh();
            binding.refreshLayout.finishLoadMore();
        });
        viewModel.listArticle(true);
    }

    @Override
    protected int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fg_home;
    }

    @Override
    protected int initVariableId() {
        return BR.viewModel;
    }


    private void initEvents() {
        homeArticleAdapter.setOnArticleCollect(articleBean -> {
            if (articleBean.isCollect()) {
                viewModel.unCollect(articleBean.getId());
            } else {
                viewModel.collect(articleBean.getId());
            }
        });
        binding.refreshLayout.setOnMultiListener(new SimpleMultiListener() {
            @Override
            public void onHeaderMoving(RefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
                binding.topbar.setAlpha(1 - Math.min(percent, 1));
                binding.secondFloor.setTranslationY(Math.min(offset - binding.secondFloor.getHeight() + binding.topbar.getHeight(), binding.refreshLayout.getLayout().getHeight() - binding.secondFloor.getHeight()));
            }

            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                viewModel.listArticle(true);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                LogUtil.show("??????????????????");
                viewModel.listArticle(false);

                viewModel.getBanner();
            }

            @Override
            public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
                if (oldState == RefreshState.TwoLevel) {
                    binding.secondFloorContent.animate().alpha(0).setDuration(1000);
                }
            }
        });

        binding.header.setOnTwoLevelListener(refreshLayout -> {
            LogUtil.show("??????????????????");
            binding.secondFloorContent.animate().alpha(1).setDuration(2000);
            return true;//true ???????????????????????? false ????????????

        });

    }


    public class HomeEvent extends EventHandlers {
        public void onTopBarClick() {
            binding.header.openTwoLevel(true);
        }

        public void onSearchClick() {
            ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(requireActivity(), binding.ivSearch, "search");
            ActivityCompat.startActivity(getActivity(), new Intent(getActivity(), SearchAc.class), activityOptionsCompat.toBundle());
        }
    }
}

