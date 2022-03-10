package com.test.login;


import android.app.Application;

import com.test.library_base.base.BaseViewModel;
import com.test.library_base.pojo.UserInfo;
import com.test.library_network.ApiCallback;
import com.test.library_network.ApiResponse;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class AccountRegisterViewModel extends BaseViewModel<AccountRegisterRepository> {
    public MutableLiveData<UserInfo> registerLiveData = new MutableLiveData<>();

    public AccountRegisterViewModel(@NonNull Application application) {
        super(application);
    }

    public void register(String u, String p) {
        model.register(u, p, new ApiCallback<UserInfo>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(@NonNull ApiResponse<UserInfo> response) {
                registerLiveData.postValue(response.getData());
            }

            @Override
            public void onError(@NonNull Throwable t) {
                registerLiveData.postValue(null);
            }
        });
    }
}
