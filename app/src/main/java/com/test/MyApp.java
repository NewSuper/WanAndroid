package com.test;

import com.test.library_base.BaseApplication;
import com.test.library_base.module.ModuleLifecycleConfig;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MyApp extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);
        EventBus.getDefault().register(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Integer event) {
        System.out.println("收到消息" + event.toString());
    }
}
