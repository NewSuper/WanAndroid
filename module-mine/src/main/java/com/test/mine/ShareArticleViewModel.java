package com.test.mine;

import android.app.Application;

import com.test.library_base.base.BaseTopBarViewModel;
import com.test.library_network.ApiCallback;
import com.test.library_network.ApiResponse;
import com.test.library_network.PopUtil;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class ShareArticleViewModel extends BaseTopBarViewModel<ShareArticleRepository> {

    public MutableLiveData<Object> shareLiveData = new MutableLiveData<>();
    public ShareArticleViewModel(@NonNull Application application) {
        super(application);
        setTitleText("分享文章");
    }

    public void shareArticle(String title, String link) {
        model.shareArticle(title, link, new ApiCallback<Object>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(@NonNull ApiResponse<Object> response) {
                PopUtil.show("分享成功", () -> onBackPressed());
                shareLiveData.postValue(response.getData());
            }

            @Override
            public void onError(@NonNull Throwable t) {
                shareLiveData.postValue(t.getMessage());
            }
        });
    }
}
