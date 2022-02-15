package com.test.library_base.constant;

import com.test.library_base.pojo.RankListRes;
import com.test.library_base.pojo.UserInfo;
import com.test.library_network.ApiCall;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserApi {

    /**
     * 积分排行榜接口
     *
     * @param page
     * @return
     */
    @GET("coin/rank/{page}/json")
    ApiCall<RankListRes> listScoreRank(@Path("page") int page);

    //获取个人积分
    @GET("lg/coin/userinfo/json")
    ApiCall<UserInfo> getIntegral();

    /**
     * 获取个人积分列表
     *
     * @param page
     * @return
     */
    @GET("lg/coin/list/{page}/json")
    ApiCall<RankListRes> listIntegral(@Path("page") int page);


}