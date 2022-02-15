package com.test.library_network;

public abstract class BaseObserverCallBack<T> {

    public abstract void onSuccess(T data);

    public boolean showErrorMsg() {
        return false;
    }

    public void onFail(String msg) {

    }

    public void onFinish() {

    }

}
