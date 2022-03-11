package com.test.mine;

import com.test.library_base.base.BaseModel;
import com.test.library_base.constant.ApiUtil;
import com.test.library_base.pojo.RankListRes;
import com.test.library_network.ApiCallback;

public class ScoreRankRepository extends BaseModel {
    private int page = 1;

    public void listRank(boolean refresh, ApiCallback<RankListRes> callback) {
        if (refresh) {
            page = 1;
        } else {
            page++;
        }
        ApiUtil.getUserApi().listScoreRank(page).enqueue(callback);
    }

}
