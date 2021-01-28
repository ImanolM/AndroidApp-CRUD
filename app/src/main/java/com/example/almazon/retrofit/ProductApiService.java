package com.example.almazon.retrofit;

import com.example.almazon.models.Product;
import com.example.almazon.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductApiService {

    @POST("product")
    Call<Product> createProduct(@Body Product product);

    @Headers({"Accept: application/json"})
    @GET("product/{id}")
    Call<Product> getProduct(@Path("id") String id);

}
