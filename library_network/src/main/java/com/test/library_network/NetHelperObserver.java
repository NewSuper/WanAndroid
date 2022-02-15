package com.test.library_network;

import android.util.Log;

import java.util.Objects;

import androidx.lifecycle.LifecycleObserver;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class NetHelperObserver<T extends ApiResponse> implements Observer<T>, LifecycleObserver {

    private final NetCallback<T> mCallback;

    public NetHelperObserver(NetCallback<T> callback) {
        mCallback = callback;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        if (mCallback != null) {
            mCallback.onSubscribe(d);
        }
    }

    @Override
    public void onNext(@NonNull T t) {
        try {
            if (mCallback != null) {
                mCallback.getClass()
                        .getMethod(t.isSuccess() ? "onSuccess" : "onFail", new Class[]{Object.class})
                        .invoke(mCallback, t);
            }
        } catch (Exception e) {
            if (mCallback != null) {
                mCallback.onError(e.getMessage());
            }
        }
    }

    @Override
    public void onError(@NonNull Throwable t) {
        Log.e("请求错误", Objects.requireNonNull(t.getMessage()));
        if (mCallback != null) {
            mCallback.onError(RxExceptionUtil.exceptionHandler(t));
        }
    }

    @Override
    public void onComplete() {

    }
}