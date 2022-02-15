package com.test.library_base.constant;


import com.test.library_base.pojo.TreeListRes;
import com.test.library_network.ApiCall;

import java.util.List;

import retrofit2.http.GET;

/**
 * 体系api
 */
public interface TreeApi {

    /**
     * 获取轮播图
     *
     * @return
     */
    @GET("tree/json")
    ApiCall<List<TreeListRes>> listTrees();

    @GET("navi/json")
    ApiCall<List<TreeListRes>> listNavis();


}
