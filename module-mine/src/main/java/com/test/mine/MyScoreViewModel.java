package com.test.mine;

import android.app.Application;

import com.test.library_base.base.BaseTopBarViewModel;
import com.test.library_base.pojo.RankListRes;
import com.test.library_network.ApiCallback;
import com.test.library_network.ApiResponse;

import java.util.AbstractMap;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class MyScoreViewModel extends BaseTopBarViewModel<MyScoreRepository> {
    public MutableLiveData<AbstractMap.SimpleEntry<Boolean, RankListRes>> scoreLiveData = new MutableLiveData<>();

    public MyScoreViewModel(@NonNull Application application) {
        super(application);
        setTitleText(application.getString(R.string.mine_integral));
    }

    public void listScore(boolean refresh) {
        model.listScore(refresh, new ApiCallback<RankListRes>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(@NonNull ApiResponse<RankListRes> response) {
                scoreLiveData.postValue(new AbstractMap.SimpleEntry<>(refresh, response.getData()));
            }

            @Override
            public void onError(@NonNull Throwable t) {

            }
        });
    }
}