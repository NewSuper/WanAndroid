package com.test.login;

import com.test.library_base.BaseApplication;
import com.test.library_base.module.ModuleLifecycleConfig;

public class LoginApp extends BaseApplication {


    @Override
    public void onCreate() {
        super.onCreate();
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);
    }
}
