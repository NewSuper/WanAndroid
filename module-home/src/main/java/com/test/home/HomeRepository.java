package com.test.home;

import com.test.library_base.base.BaseModel;
import com.test.library_base.constant.ApiUtil;
import com.test.library_base.pojo.ArticleListRes;
import com.test.library_base.pojo.BannerRes;
import com.test.library_network.ApiCallback;

import java.util.List;

public class HomeRepository extends BaseModel {

    public void unCollect(String id, ApiCallback<Object> callback) {
        ApiUtil.getArticleApi().unCollect(id).enqueue(callback);
    }

    public void collect(String id, ApiCallback<Object> callback) {
        ApiUtil.getArticleApi().collect(id).enqueue(callback);
    }

    public void getBanner(ApiCallback<List<BannerRes>> callback) {
        ApiUtil.getArticleApi().getBanner().enqueue(callback);
    }

    int page = 0;

    public void listArticle(boolean refresh, ApiCallback<ArticleListRes> callback) {
        if (!refresh) {
            page++;
        } else {
            page = 0;
        }
        ApiUtil.getArticleApi().listArticle(page).enqueue(callback);
    }
}
