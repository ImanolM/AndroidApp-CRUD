package com.example.almazon.retrofit;

import com.example.almazon.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Interfaz para realizar operaciones con la entidad usuario. Los metodos que contiene realizan las
 * siguientes operaciones: obtener clave pública, obtener el usuario verificado en el login (post) y
 * obtener un listado de usuarios.
 */
public interface UserApiService {

    @GET("user/getPublicKey")
    Call<String> getPublicKey();

    @Headers({"Accept: application/json"})
    @POST("user/loginUser")
    Call<User> loginUser(@Body User user);

    @POST("user/getAllUsers")
    Call<User> getAllUsers(@Body User user);

}
