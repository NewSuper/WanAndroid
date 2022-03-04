package com.test.home;


import android.app.Application;

import com.test.library_base.base.BaseViewModel;
import com.test.library_base.pojo.ArticleBean;
import com.test.library_base.pojo.ArticleListRes;
import com.test.library_network.ApiCallback;
import com.test.library_network.ApiResponse;

import java.util.AbstractMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class SearchResultViewModel extends BaseViewModel<SearchResultRepository> {
    public MutableLiveData<AbstractMap.SimpleEntry<Boolean, List<ArticleBean>>> articleLiveData = new MutableLiveData<>();

    public SearchResultViewModel(@NonNull Application application) {
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

    public void search(boolean refresh, String searchContent) {
        model.search(refresh, searchContent, new ApiCallback<ArticleListRes>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(@NonNull ApiResponse<ArticleListRes> response) {
                articleLiveData.postValue(new AbstractMap.SimpleEntry<>(refresh, response.getData().getDatas()));
            }

            @Override
            public void onError(@NonNull Throwable t) {

            }
        });
    }

}
