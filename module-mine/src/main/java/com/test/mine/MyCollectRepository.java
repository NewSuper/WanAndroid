package com.test.mine;

import com.test.library_base.base.BaseModel;
import com.test.library_base.constant.ApiUtil;
import com.test.library_base.pojo.ArticleListRes;
import com.test.library_network.ApiCallback;

public class MyCollectRepository extends BaseModel {
    private int page = 0;

    public void listMyCollect(boolean refresh, ApiCallback<ArticleListRes> callback) {
        if (refresh) {
            page = 0;
        } else {
            page++;
        }
        ApiUtil.getArticleApi().listMyCollect(page).enqueue(callback);
    }
    public void unCollect(String id, ApiCallback<Object> callback) {
        ApiUtil.getArticleApi().unCollect(id).enqueue(callback);
    }
}
