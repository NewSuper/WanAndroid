package com.test.library_base.module;

import android.app.Application;

import com.test.library_base.BaseApplication;

import androidx.annotation.Nullable;

public class ModuleLifecycleConfig {

    private ModuleLifecycleConfig() {

    }

    private static class SingleHolder {
        private static ModuleLifecycleConfig instance =
                new ModuleLifecycleConfig();
    }

    public static ModuleLifecycleConfig getInstance() {
        return SingleHolder.instance;
    }

    /**
     * 优先初始化
     */
    public void initModuleAhead(@Nullable Application application) {
        for (String moduleName : ModuleLifecycleReflects.initModuleNames) {
            try {
                Class<?> clazz = Class.forName(moduleName);
                IModuleInit init = (IModuleInit) clazz.newInstance();
                init.onInitAhead(application);
            } catch (Exception e) {
                //  } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 后初始化
     */
    public void initModuleAfter(@Nullable BaseApplication application) {
        for (String moduleName : ModuleLifecycleReflects.initModuleNames) {
            try {
                Class<?> clazz = Class.forName(moduleName);
                IModuleInit init = (IModuleInit) clazz.newInstance();
                // 调用初始化方法
                init.onInitAfter(application);
          //  } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
