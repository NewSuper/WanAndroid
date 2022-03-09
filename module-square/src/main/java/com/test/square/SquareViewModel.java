package com.test.square;


import android.app.Application;

import com.test.library_base.base.BaseViewModel;
import com.test.library_base.pojo.TreeListRes;
import com.test.library_network.ApiCallback;
import com.test.library_network.ApiResponse;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class SquareViewModel extends BaseViewModel<SquareRepository> {
    public MutableLiveData<List<TreeListRes>> treesLiveData = new MutableLiveData<>();
    public MutableLiveData<List<TreeListRes>> navisLiveData = new MutableLiveData<>();


    public SquareViewModel(@NonNull Application application) {
        super(application);
    }


    public void listTrees() {
        model.listTrees(new ApiCallback<List<TreeListRes>>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(@NonNull ApiResponse<List<TreeListRes>> response) {
                treesLiveData.postValue(response.getData());
            }

            @Override
            public void onError(@NonNull Throwable t) {
                treesLiveData.postValue(null);
            }
        });
    }

    public void listNavis() {
        model.listNavis(new ApiCallback<List<TreeListRes>>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(@NonNull ApiResponse<List<TreeListRes>> response) {
                navisLiveData.postValue(response.getData());
            }

            @Override
            public void onError(@NonNull Throwable t) {
                navisLiveData.postValue(null);
            }
        });
    }
}
