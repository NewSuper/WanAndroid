package com.test.mine;


import android.app.Application;

import com.test.library_aop.CheckLogin;
import com.test.library_base.base.BaseViewModel;
import com.test.library_base.pojo.UserInfo;
import com.test.library_base.utils.MMkvHelper;
import com.test.library_network.ApiCallback;
import com.test.library_network.ApiResponse;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.annotation.NonNull;
public class MineViewModel extends BaseViewModel<MineRepository> {

    public MutableLiveData<UserInfo> userInfoLiveData = new MutableLiveData<>();
    private WeakReference<FragmentActivity> mContext;

    public MineViewModel(@NonNull Application application) {
        super(application);
    }

    public void register(FragmentActivity activity) {
        mContext = new WeakReference<>(activity);
    }

    public void getScore() {
        model.getScore(new ApiCallback<UserInfo>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(@NonNull ApiResponse<UserInfo> response) {
                MMkvHelper.getInstance().saveUserInfo(response.getData());
                userInfoLiveData.postValue(response.getData());
            }

            @Override
            public void onError(@NonNull Throwable t) {

            }
        });
    }

    public void onSetClick() {
        onItemClick(99);
    }

    @CheckLogin
    public void onItemClick(int pos) {
        switch (pos) {
            case 0:
                MyScoreAc.launch(mContext.get());
                break;
            case 1:
                MyCollectAc.launch(mContext.get());
                break;
            case 2:
                MyShareAc.launch(mContext.get());
                break;
            case 3:
                OpenSourceAc.launch(mContext.get());
                break;
            case 4:
                AboutAuthorAc.launch(mContext.get());
                break;
            case 99:
                SettingAc.launch(mContext.get());
                break;
        }
    }
}
