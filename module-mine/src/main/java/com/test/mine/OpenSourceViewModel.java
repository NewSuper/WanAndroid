package com.test.mine;

import android.app.Application;

import com.test.library_base.base.BaseTopBarViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class OpenSourceViewModel extends BaseTopBarViewModel {
    public MutableLiveData<List<OpenSourcePro>> liveData = new MutableLiveData<>();

    public OpenSourceViewModel(@NonNull Application application) {
        super(application);
        setTitleText(application.getString(R.string.mine_open_source_project));
    }

    public void listData(){
        liveData.postValue(DataUtil.getPros());
    }
}
