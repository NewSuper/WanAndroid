package com.test.home;

import com.test.library_base.base.BaseModel;
import com.test.library_base.constant.ApiUtil;
import com.test.library_base.pojo.SearchBeanRes;
import com.test.library_db.DbUtil;
import com.test.library_db.SearchHistoryDao;
import com.test.library_db.SearchHistoryEntity;
import com.test.library_network.ApiCallback;

import java.util.List;

public class SearchRepository extends BaseModel {
    private SearchHistoryDao searchHistoryDao;

    public SearchRepository() {
        searchHistoryDao = DbUtil.getInstance().getAppDataBase().searchHistoryDao();
    }

    public void deleteLocalHis() {
        searchHistoryDao.deleteAll();
    }

    public void deleteLocalHisById(long id) {
        searchHistoryDao.deleteById(id);
    }

    public List<SearchHistoryEntity> selectLocalHis() {
        return searchHistoryDao.selectHis();
    }

    public long insertPerson(SearchHistoryEntity entity) {
        return searchHistoryDao.insertPerson(entity);
    }

    public void hotSearch(ApiCallback<List<SearchBeanRes>> callback) {
        ApiUtil.getArticleApi().hotSearch().enqueue(callback);
    }
}
