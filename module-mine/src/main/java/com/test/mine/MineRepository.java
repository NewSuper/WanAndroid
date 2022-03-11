package com.test.mine;

import com.test.library_base.base.BaseModel;
import com.test.library_base.constant.ApiUtil;
import com.test.library_base.pojo.UserInfo;
import com.test.library_network.ApiCallback;

public class MineRepository extends BaseModel {
    public void getScore(ApiCallback<UserInfo> callback) {
        ApiUtil.getUserApi().getIntegral().enqueue(callback);
    }
}

