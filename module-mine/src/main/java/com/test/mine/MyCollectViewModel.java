package com.test.mine;


import android.app.Application;

import com.test.library_base.base.BaseTopBarViewModel;
import com.test.library_base.pojo.ArticleBean;
import com.test.library_base.pojo.ArticleListRes;
import com.test.library_network.ApiCallback;
import com.test.library_network.ApiResponse;

import java.util.AbstractMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class MyCollectViewModel extends BaseTopBarViewModel<MyCollectRepository> {
    public MutableLiveData<AbstractMap.SimpleEntry<Boolean, List<ArticleBean>>> collectLiveData = new MutableLiveData<>();

    public MyCollectViewModel(@NonNull Application application) {
        super(application);
        setTitleText(application.getString(R.string.mine_collect));
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


    public void listMyCollect(boolean refresh) {
        model.listMyCollect(refresh, new ApiCallback<ArticleListRes>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(@NonNull ApiResponse<ArticleListRes> response) {
                List<ArticleBean> datas = response.getData().getDatas();
                for (ArticleBean articleBean : datas) {
                    articleBean.setCollect(true);
                }
                collectLiveData.postValue(new AbstractMap.SimpleEntry<>(refresh, datas));
            }

            @Override
            public void onError(@NonNull Throwable t) {
                collectLiveData.postValue(null);
            }
        });
    }
}
