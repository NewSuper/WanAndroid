package com.test.library_network;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public abstract class NetCallback<T> {

    protected void onSuccess(T response) {
    }

    protected void onFail(T response) {
    }

    protected void onError(String msg) {
    }

    protected void onSubscribe(@NonNull Disposable d) {
    }
}
