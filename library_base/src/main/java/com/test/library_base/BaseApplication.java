package com.test.library_base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.test.library_base.utils.ActivityUtil;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BaseApplication extends Application {

    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        setApplication(this);
    }

    /**
     * 当宿主没有继承自该Application时,可以使用set方法进行初始化baseApplication
     *
     * @param application
     */
    private void setApplication(BaseApplication application) {
        instance = application;
        application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
                ActivityUtil.addActivity(activity);
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {

            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {
                ActivityUtil.removeActivity(activity);
            }
        });
    }

    public static BaseApplication getInstance() {
        if (instance == null) {
            throw new NullPointerException(
                    "please inherit BaseApplication or call setApplication.");
        }
        return instance;
    }
}
