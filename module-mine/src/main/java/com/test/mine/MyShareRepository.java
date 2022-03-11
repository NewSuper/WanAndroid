package com.test.mine;

import com.test.library_base.base.BaseModel;
import com.test.library_base.constant.ApiUtil;
import com.test.library_base.constant.PageImpl;
import com.test.library_base.pojo.MyShareBean;
import com.test.library_network.ApiCallback;

public class MyShareRepository extends BaseModel {
    private final PageImpl pageImpl = new PageImpl();

    public void listMyShare(boolean refresh, ApiCallback<MyShareBean> callback) {
        if (refresh) {
            pageImpl.reset();
        } else {
            pageImpl.nextPage();
        }
        ApiUtil.getArticleApi().listMyShare(pageImpl.page).enqueue(callback);
    }

    public void deleteArticle(String id, ApiCallback<Object> callback) {
        ApiUtil.getArticleApi().deleteArticle(id).enqueue(callback);
    }
    public void unCollect(String id, ApiCallback<Object> callback) {
        ApiUtil.getArticleApi().unCollect(id).enqueue(callback);
    }

    public void collect(String id, ApiCallback<Object> callback) {
        ApiUtil.getArticleApi().collect(id).enqueue(callback);
    }
}
