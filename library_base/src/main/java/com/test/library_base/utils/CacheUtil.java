package com.test.library_base.utils;


import com.test.library_base.BaseApplication;

public class CacheUtil {
    /**
     * 获取系统默认缓存文件夹内的缓存大小
     */
    public static String getTotalCacheSize() {
        long cacheSize = FileUtils.getSize(BaseApplication.getInstance().getCacheDir());
        if (FileUtils.isSDCardAlive()) {
            cacheSize += FileUtils.getSize(BaseApplication.getInstance().getExternalCacheDir());
        }
        return FileUtils.formatSize(cacheSize);
    }

    public static void clearAllCache() {
        FileUtils.delete(BaseApplication.getInstance().getCacheDir());
        if (FileUtils.isSDCardAlive()) {
            FileUtils.delete(BaseApplication.getInstance().getExternalCacheDir());
        }
    }
}
