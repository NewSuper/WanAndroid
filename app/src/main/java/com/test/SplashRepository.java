package com.test;

import com.test.library_base.base.BaseModel;
import com.test.library_base.constant.ApiUtil;
import com.test.library_base.pojo.ProjectListRes;
import com.test.library_network.ApiCallback;

import java.util.List;

public class SplashRepository extends BaseModel {

    public void listProjectsTab(ApiCallback<List<ProjectListRes>> callback) {
        ApiUtil.getProjectApi().listProjectsTab().enqueue(callback);
    }
}
