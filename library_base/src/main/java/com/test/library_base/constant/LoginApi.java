package com.test.library_base.constant;

import com.test.library_base.pojo.UserInfo;
import com.test.library_network.ApiCall;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginApi {

    /**
     * 登录
     *
     * @param username 账号
     * @param password 密码
     * @return
     */
    @FormUrlEncoded
    @POST("user/login")
    ApiCall<UserInfo> login(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("user/register")
    ApiCall<UserInfo> register(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);

    @GET("user/logout/json")
    ApiCall<Object> logout2();
}
