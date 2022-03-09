package com.test.square;

import com.test.library_base.base.BaseModel;
import com.test.library_base.constant.ApiUtil;
import com.test.library_base.pojo.TreeListRes;
import com.test.library_network.ApiCallback;

import java.util.List;

public class SquareRepository extends BaseModel {

    public void listTrees(ApiCallback<List<TreeListRes>> callback) {
        ApiUtil.getTreeApi().listTrees().enqueue(callback);
    }

    public void listNavis(ApiCallback<List<TreeListRes>> callback) {
        ApiUtil.getTreeApi().listNavis().enqueue(callback);
    }
}
