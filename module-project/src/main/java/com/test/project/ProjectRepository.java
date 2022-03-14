package com.test.project;

import com.test.library_base.base.BaseModel;
import com.test.library_base.constant.ApiUtil;
import com.test.library_base.pojo.ArticleListRes;
import com.test.library_base.pojo.ProjectListRes;
import com.test.library_base.utils.MMkvHelper;
import com.test.library_network.ApiCallback;

import java.util.List;

public class ProjectRepository extends BaseModel {
    public List<ProjectListRes> listLocalProjectTabs() {
        return MMkvHelper.getInstance().getProjectTabs(ProjectListRes.class);
    }
    public void unCollect(String id, ApiCallback<Object> callback) {
        ApiUtil.getArticleApi().unCollect(id).enqueue(callback);
    }

    public void collect(String id, ApiCallback<Object> callback) {
        ApiUtil.getArticleApi().collect(id).enqueue(callback);
    }
    public void listProjectsTab(ApiCallback<List<ProjectListRes>> callback) {
        ApiUtil.getProjectApi().listProjectsTab().enqueue(callback);
    }

    int page = 0;

    public void listProjects(boolean refresh, String id, ApiCallback<ArticleListRes> callback) {
        if (refresh) {
            page = 0;
        } else {
            page++;
        }
        ApiUtil.getProjectApi().listProjects(page, id).enqueue(callback);
    }
}
