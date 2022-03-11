package com.test.mine;


import com.test.library_base.base.BaseModel;
import com.test.library_base.constant.ApiUtil;
import com.test.library_network.ApiCallback;

public class ShareArticleRepository extends BaseModel {

    public void shareArticle(String title, String link, ApiCallback<Object> callback){
        ApiUtil.getArticleApi().shareArticle(title,link).enqueue(callback);
    }
}
