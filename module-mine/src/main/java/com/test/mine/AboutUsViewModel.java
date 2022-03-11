package com.test.mine;

import android.app.Application;

import com.test.library_base.base.BaseTopBarViewModel;
import com.test.library_base.constant.C;
import com.test.library_base.utils.RouterUtil;

import androidx.annotation.NonNull;

public class AboutUsViewModel extends BaseTopBarViewModel {
    public AboutUsViewModel(@NonNull Application application) {
        super(application);
    }

    public void onOfficialClick() {
        RouterUtil.launchWeb(C.WAN_ANDROID);

    }

    public void onNetClick() {
        RouterUtil.launchWeb(C.URL_ABOUT);

    }

    public void onLibClick() {
        RouterUtil.launchWeb(C.SOURCE_URL);

    }
}
