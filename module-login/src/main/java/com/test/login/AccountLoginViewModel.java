package com.test.login;

import android.app.Application;

import com.test.library_base.base.BaseViewModel;
import com.test.library_base.pojo.UserInfo;
import com.test.library_base.utils.MMkvHelper;
import com.test.library_network.ApiCallback;
import com.test.library_network.ApiResponse;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class AccountLoginViewModel extends BaseViewModel<AccountLoginRepository> {
    public MutableLiveData<UserInfo> loginLiveData = new MutableLiveData<>();

    public AccountLoginViewModel(@NonNull Application application) {
        super(application);
    }

    public void login(String u, String p) {
        model.login(u, p, new ApiCallback<UserInfo>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(@NonNull ApiResponse<UserInfo> response) {
                loginLiveData.postValue(response.getData());
                MMkvHelper.getInstance().saveUserInfo(response.getData());
                onBackPressed();
            }

            @Override
            public void onError(@NonNull Throwable t) {
                loginLiveData.postValue(null);
            }
        });
    }
}
