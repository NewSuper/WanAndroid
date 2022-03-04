package com.test.home;


import com.test.library_base.base.BaseModel;
import com.test.library_base.constant.ApiUtil;
import com.test.library_base.constant.PageImpl;
import com.test.library_base.pojo.ArticleListRes;
import com.test.library_network.ApiCallback;

public class SearchResultRepository extends BaseModel {
    private PageImpl pageImpl = new PageImpl();

    public void unCollect(String id, ApiCallback<Object> callback) {
        ApiUtil.getArticleApi().unCollect(id).enqueue(callback);
    }

    public void collect(String id, ApiCallback<Object> callback) {
        ApiUtil.getArticleApi().collect(id).enqueue(callback);
    }

    public void search(boolean refresh, String searchContent, ApiCallback<ArticleListRes> callback) {
        if (refresh) {
            pageImpl.resetZero();
        } else {
            pageImpl.nextZeroPage();
        }
        ApiUtil.getArticleApi().search(pageImpl.zeroPage, searchContent).enqueue(callback);
    }

}
