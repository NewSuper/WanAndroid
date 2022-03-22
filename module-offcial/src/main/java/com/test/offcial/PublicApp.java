package com.test.offcial;

import com.test.library_base.BaseApplication;
import com.test.library_base.module.ModuleLifecycleConfig;

public class PublicApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);
    }
}
