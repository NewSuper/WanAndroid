package com.test.library_base.constant;

import com.test.library_base.base.ArticleApi;
import com.test.library_network.RetrofitCreateHelper;
import com.test.library_network.U;

/**
 * 不同模块BASE_URL可能不同
 */
public class ApiUtil {

    public static ProjectApi getProjectApi() {
        return RetrofitCreateHelper.getInstance().create(U.BASE_URL, ProjectApi.class);
    }

    public static ArticleApi getArticleApi() {
        return RetrofitCreateHelper.getInstance().create(U.BASE_URL, ArticleApi.class);
    }

    public static TreeApi getTreeApi() {
        return RetrofitCreateHelper.getInstance().create(U.BASE_URL, TreeApi.class);
    }

    public static LoginApi getLoginApi() {
        return RetrofitCreateHelper.getInstance().create(U.BASE_URL, LoginApi.class);
    }

    public static UserApi getUserApi() {
        return RetrofitCreateHelper.getInstance().create(U.BASE_URL, UserApi.class);
    }
}
