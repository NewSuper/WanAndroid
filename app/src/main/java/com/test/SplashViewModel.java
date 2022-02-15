package com.test;

import android.app.Application;

import com.test.library_base.base.BaseTopBarViewModel;
import com.test.library_base.pojo.ProjectListRes;
import com.test.library_network.ApiCallback;
import com.test.library_network.ApiResponse;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class SplashViewModel extends BaseTopBarViewModel<SplashRepository> {

    public MutableLiveData<List<ProjectListRes>> projectListLiveData;

    public SplashViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<ProjectListRes>> projectListLiveData() {
        if (projectListLiveData == null) {
            projectListLiveData = new MutableLiveData<>();
        }
        return projectListLiveData;
    }

    public void listProjectsTab() {
        model.listProjectsTab(new ApiCallback<List<ProjectListRes>>() {
            @Override
            public void onStart() {
            }

            @Override
            public void onSuccess(@NonNull ApiResponse<List<ProjectListRes>> response) {
                projectListLiveData().postValue(response.getData());
            }

            @Override
            public void onError(@NonNull Throwable t) {

            }
        });
    }
}
