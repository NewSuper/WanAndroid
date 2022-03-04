package com.test.home;


import android.app.Application;

import com.test.library_base.base.BaseViewModel;
import com.test.library_base.pojo.ArticleBean;
import com.test.library_base.pojo.ArticleListRes;
import com.test.library_base.pojo.BannerRes;
import com.test.library_network.ApiCallback;
import com.test.library_network.ApiResponse;

import java.util.AbstractMap;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class HomeViewModel extends BaseViewModel<HomeRepository> {
    public MutableLiveData<AbstractMap.SimpleEntry<Boolean, List<ArticleBean>>> liveData = new MutableLiveData<>();
    public MutableLiveData<List<BannerRes>> bannerLiveData = new MutableLiveData<>();

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public void unCollect(String id) {
        model.unCollect(id, new ApiCallback<Object>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(@NonNull ApiResponse<Object> response) {

            }

            @Override
            public void onError(@NonNull Throwable t) {

            }
        });
    }

    public void collect(String id) {
        model.collect(id, new ApiCallback<Object>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(@NonNull ApiResponse<Object> response) {

            }

            @Override
            public void onError(@NonNull Throwable t) {

            }
        });
    }

    public void getBanner() {
        model.getBanner(new ApiCallback<List<BannerRes>>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(@NonNull ApiResponse<List<BannerRes>> response) {
                bannerLiveData.postValue(response.getData());
            }

            @Override
            public void onError(@NonNull Throwable t) {
                bannerLiveData.postValue(null);
            }
        });
    }

    public void listArticle(boolean refresh) {
        model.listArticle(refresh, new ApiCallback<ArticleListRes>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(@NonNull ApiResponse<ArticleListRes> response) {
                liveData.postValue(new AbstractMap.SimpleEntry<>(refresh, response.getData().getDatas()));
            }

            @Override
            public void onError(@NonNull Throwable t) {

            }
        });
    }

}
