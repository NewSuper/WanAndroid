package com.test.library_network;

import androidx.lifecycle.LiveData;

import retrofit2.http.POST;

public interface ApiLiveDataService {
    @POST
    LiveData<String> post();
}
