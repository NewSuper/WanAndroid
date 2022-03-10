package com.test.login;

import com.test.library_base.base.BaseModel;
import com.test.library_base.constant.ApiUtil;
import com.test.library_base.pojo.UserInfo;
import com.test.library_network.ApiCallback;

public class AccountLoginRepository extends BaseModel {
    public void login(String u, String p, ApiCallback<UserInfo> callback) {
        ApiUtil.getLoginApi().login(u, p).enqueue(callback);
    }
}

