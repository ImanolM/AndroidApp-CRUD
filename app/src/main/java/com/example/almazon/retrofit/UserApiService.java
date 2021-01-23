package com.example.almazon.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApiService {

    @GET("user/getPublicKey")
    Call<String> getPublicKey();
}
