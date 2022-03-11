package com.test.mine;


import android.app.Application;
import android.view.View;

import com.test.library_base.base.BaseTopBarViewModel;
import com.test.library_base.utils.FileUtils;
import com.test.library_network.PopUtil;

import java.lang.ref.WeakReference;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

public class AboutAuthorViewModel extends BaseTopBarViewModel {
    private WeakReference<FragmentActivity> activityWeakReference;

    public AboutAuthorViewModel(@NonNull Application application) {
        super(application);
        setTitleText(application.getString(R.string.mine_about_author));
    }

    public void register(FragmentActivity activity) {
        if (activityWeakReference == null) {
            activityWeakReference = new WeakReference<>(activity);
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (activityWeakReference != null) {
            activityWeakReference.clear();
        }
    }

    public void onWxClick(View view) {
        FileUtils.saveImage(activityWeakReference.get(), view);
        PopUtil.show(activityWeakReference.get().getString(R.string.save_success));
    }

    public void onZfbClick(View view) {
        FileUtils.saveImage(activityWeakReference.get(), view);
        PopUtil.show(activityWeakReference.get().getString(R.string.save_success));
    }
}
