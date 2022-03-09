package com.test.square;


import com.test.library_base.base.BaseModel;
import com.test.library_base.constant.ApiUtil;
import com.test.library_base.pojo.ArticleListRes;
import com.test.library_network.ApiCallback;

public class SquareListRepository extends BaseModel {

    public void unCollect(String id, ApiCallback<Object> callback) {
        ApiUtil.getArticleApi().unCollect(id).enqueue(callback);
    }

    public void collect(String id, ApiCallback<Object> callback) {
        ApiUtil.getArticleApi().collect(id).enqueue(callback);
    }

    private int page = 0;

    public void listArticle(boolean refresh, String id, ApiCallback<ArticleListRes> callback) {
        if (!refresh) {
            page++;
        } else {
            page = 0;
        }
        ApiUtil.getArticleApi().listArticle(page, id).enqueue(callback);
    }
}
