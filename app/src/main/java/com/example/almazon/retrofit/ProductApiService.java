package com.example.almazon.retrofit;

import com.example.almazon.models.Product;
import com.example.almazon.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Interfaz para realizar operaciones con la entidad producto. Los metodos que contiene realizan las
 * cuatro operaciones CRUD: creado, consulta, borrado y actualización de producto.
 */
public interface ProductApiService {

    @POST("product")
    Call<Product> createProduct(@Body Product product);

    @Headers({"Accept: application/json"})
    @GET("product/{id}")
    Call<Product> getProduct(@Path("id") String id);

    @PUT("product")
    Call<Product> updateProduct(@Body Product product);


    @DELETE("product/{id}")
    Call<Product> deleteProduct(@Path("id") String id);
}
