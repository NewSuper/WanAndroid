package com.test.library_network;

public class BaseObserver<T> implements IBaseObserver<T> {

    private BaseObserverCallBack<T> baseObserverCallBack;

    public BaseObserver(BaseObserverCallBack<T> baseObserverCallBack) {
        this.baseObserverCallBack = baseObserverCallBack;
    }

    @Override
    public void onChanged(T t) {
        if (t instanceof ApiResponse) {
            ApiResponse apiResponse = (ApiResponse) t;
            if (apiResponse.isSuccess()) {
                baseObserverCallBack.onSuccess(t);
            } else {
                baseObserverCallBack.onFail(apiResponse.getErrorMsg());
                if (baseObserverCallBack.showErrorMsg()) {
                    PopUtil.show(apiResponse.getErrorMsg());
                }
            }
        } else {
            baseObserverCallBack.onFail("系统繁忙!");
        }
        baseObserverCallBack.onFinish();
    }
}
