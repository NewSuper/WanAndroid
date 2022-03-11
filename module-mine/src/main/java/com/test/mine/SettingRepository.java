package com.test.mine;


import com.test.library_base.base.BaseModel;
import com.test.library_base.constant.ApiUtil;
import com.test.library_network.ApiCallback;

public class SettingRepository extends BaseModel {

    public void logout(ApiCallback<Object> callback){
        ApiUtil.getLoginApi().logout2().enqueue(callback);
    }
}
