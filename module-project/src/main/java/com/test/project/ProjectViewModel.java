package com.test.project;


import android.app.Application;

import com.test.library_base.base.BaseViewModel;
import com.test.library_base.pojo.ArticleBean;
import com.test.library_base.pojo.ArticleListRes;
import com.test.library_base.pojo.ProjectListRes;
import com.test.library_base.utils.MMkvHelper;
import com.test.library_network.ApiCallback;
import com.test.library_network.ApiResponse;

import java.util.AbstractMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class ProjectViewModel extends BaseViewModel<ProjectRepository> {
    public MutableLiveData<List<ProjectListRes>> projectTabLiveData = new MutableLiveData<>();
    public MutableLiveData<AbstractMap.SimpleEntry<Boolean, List<ArticleBean>>> projectLiveData = new MutableLiveData<>();

    public ProjectViewModel(@NonNull Application application) {
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

    public List<ProjectListRes> listLocalProjectTabs() {
        return model.listLocalProjectTabs();
    }

    public void listProjects(boolean refresh, String id) {
        model.listProjects(refresh, id, new ApiCallback<ArticleListRes>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(@NonNull ApiResponse<ArticleListRes> response) {
                projectLiveData.postValue(new AbstractMap.SimpleEntry<>(refresh, response.getData().getDatas()));
            }

            @Override
            public void onError(@NonNull Throwable t) {
                projectLiveData.postValue(null);
            }
        });
    }


    public void listProjectsTab() {
        List<ProjectListRes> projectTabs = model.listLocalProjectTabs();
        if (projectTabs.size() > 0) {
            projectTabLiveData.postValue(projectTabs);
        } else {
            model.listProjectsTab(new ApiCallback<List<ProjectListRes>>() {
                @Override
                public void onStart() {

                }

                @Override
                public void onSuccess(@NonNull ApiResponse<List<ProjectListRes>> response) {
                    if (response.getData().size() > 0) {
                        MMkvHelper.getInstance().saveProjectTabs(response.getData());
                    }
                    projectTabLiveData.postValue(response.getData());
                }

                @Override
                public void onError(@NonNull Throwable t) {
                    projectTabLiveData.postValue(null);
                }
            });
        }
    }

}
