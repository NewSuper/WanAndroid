package com.test.home;

import com.test.library_base.pojo.SearchBeanRes;

import java.util.List;

public class SearchBean {
    private String title;
    private List<SearchBeanRes> data;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SearchBeanRes> getData() {
        return data;
    }

    public void setData(List<SearchBeanRes> data) {
        this.data = data;
    }
}
