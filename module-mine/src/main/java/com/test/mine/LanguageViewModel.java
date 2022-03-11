package com.test.mine;

import android.app.Application;

import com.test.library_base.base.BaseTopBarViewModel;
import com.test.library_base.utils.LanguageUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class LanguageViewModel extends BaseTopBarViewModel {
    public MutableLiveData<List<LanguageBean>> languageLiveData = new MutableLiveData<>();

    public LanguageViewModel(@NonNull Application application) {
        super(application);
    }


    public void getData() {
        List<LanguageBean> list = new ArrayList<>();
        list.add(new LanguageBean(Locale.SIMPLIFIED_CHINESE, "简体中文"));
        list.add(new LanguageBean(Locale.US, "英文"));
        Locale currentLanguage = LanguageUtil.getCurrentLanguage();
        for (LanguageBean languageBean : list) {
            if (currentLanguage.equals(languageBean.getLocale())) {
                languageBean.setPress(true);
                break;
            }
        }
        languageLiveData.postValue(list);
    }
}
