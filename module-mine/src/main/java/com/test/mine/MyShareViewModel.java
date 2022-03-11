package com.test.mine;


import android.app.Application;

import com.test.library_base.base.BaseViewModel;
import com.test.library_base.pojo.MyShareBean;
import com.test.library_network.ApiCallback;
import com.test.library_network.ApiResponse;

import java.util.AbstractMap;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class MyShareViewModel extends BaseViewModel<MyShareRepository> {
    public MutableLiveData<AbstractMap.SimpleEntry<Boolean, MyShareBean>> shareLiveData = new MutableLiveData<>();

    public MyShareViewModel(@NonNull Application application) {
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

    public void listMyShare(boolean refresh){
        model.listMyShare(refresh, new ApiCallback<MyShareBean>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(@NonNull ApiResponse<MyShareBean> response) {
                shareLiveData.postValue(new AbstractMap.SimpleEntry<>(refresh, response.getData()));
            }

            @Override
            public void onError(@NonNull Throwable t) {

            }
        });
    }
    public void deleteArticle(String id){
        model.deleteArticle(id, new ApiCallback<Object>() {
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
    public void onShareClick() {
        ShareArticleAc.launch(getApplication());
    }
}
