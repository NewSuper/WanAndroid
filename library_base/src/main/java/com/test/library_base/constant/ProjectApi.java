package com.test.library_base.constant;


import com.test.library_base.pojo.ArticleListRes;
import com.test.library_base.pojo.ProjectListRes;
import com.test.library_network.ApiCall;
import com.test.library_network.RetryCount;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProjectApi {


    /**
     * 项目分类
     *
     * @return
     */
    @RetryCount(value = 3)
    @GET("project/tree/json")
    ApiCall<List<ProjectListRes>> listProjectsTab();

    /**
     * 项目列表
     *
     * @param id   分类id
     * @param page 页码，拼接在连接中，从0开始。
     * @return
     */
    @GET("project/list/{page}/json")
    ApiCall<ArticleListRes> listProjects(@Path("page") int page, @Query("cid") String id);


}
