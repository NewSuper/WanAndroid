package com.test.mine;

import android.app.Application;

import com.test.library_base.base.BaseTopBarViewModel;
import com.test.library_base.pojo.RankBean;
import com.test.library_base.pojo.RankListRes;
import com.test.library_network.ApiCallback;
import com.test.library_network.ApiResponse;

import java.util.AbstractMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class ScoreRankViewModel extends BaseTopBarViewModel<ScoreRankRepository> {
    public MutableLiveData<AbstractMap.SimpleEntry<Boolean, List<RankBean>>> scoreRankLiveData = new MutableLiveData<>();

    public ScoreRankViewModel(@NonNull Application application) {
        super(application);
        setTitleText(application.getString(R.string.mine_scoreboard));
    }


    public void listRank(boolean refresh) {
        model.listRank(refresh, new ApiCallback<RankListRes>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(@NonNull ApiResponse<RankListRes> response) {
                scoreRankLiveData.postValue(new AbstractMap.SimpleEntry<>(refresh, response.getData().getDatas()));
            }

            @Override
            public void onError(@NonNull Throwable t) {

            }
        });
    }
}
