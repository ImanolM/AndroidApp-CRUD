package com.example.almazon.retrofit;

import com.example.almazon.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserApiService {

    @GET("user/getPublicKey")
    Call<String> getPublicKey();

    @Headers({"Accept: application/json"})
    @POST("user/loginUser")
    Call<User> loginUser(@Body User user);

    @POST("user/getAllUsers")
    Call<User> getAllUsers(@Body User user);

}
