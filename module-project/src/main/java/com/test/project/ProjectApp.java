package com.test.project;

import com.test.library_base.BaseApplication;
import com.test.library_base.module.ModuleLifecycleConfig;

public class ProjectApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);
    }
}
