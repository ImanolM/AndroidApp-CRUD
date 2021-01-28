package com.example.almazon.retrofit;

import android.content.Context;
import android.widget.Toast;

import com.example.almazon.models.Product;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProductREST {
    private Retrofit retrofit;
    private Context context;
    private Product product;

    public ProductREST(Context context) {
        this.retrofit = RetroFitInstancer.getRetrofitInstance();
        this.context = context;
    }

    public void createProduct(Product product) {
        ProductApiService productApiService = retrofit.create(ProductApiService.class);
        Call<Product> call = productApiService.createProduct(product);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {


            }

            @Override
            public void onFailure(Call<Product> call, Throwable throwable) {
                Toast.makeText(context, "Eror al conectar con el servidor.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public Product getProduct(String idProduct, OnProductResponse callback) {
        ProductApiService productApiService = retrofit.create(ProductApiService.class);
        Call<Product> call = productApiService.getProduct(idProduct);

        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                callback.product(response.body());
            }

            @Override
            public void onFailure(Call<Product> call, Throwable throwable) {
            }
        });


        return null;
    }

    public void updateProduct(Product product) {
        ProductApiService productApiService = retrofit.create(ProductApiService.class);
        Call<Product> call = productApiService.updateProduct(product);

        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
            }

            @Override
            public void onFailure(Call<Product> call, Throwable throwable) {
                Toast.makeText(context, "Eror al conectar con el servidor.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void deleteProduct(String id) {
        ProductApiService productApiService = retrofit.create(ProductApiService.class);
        Call<Product> call = productApiService.deleteProduct(id);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
            }

            @Override
            public void onFailure(Call<Product> call, Throwable throwable) {
                Toast.makeText(context, "Eror al conectar con el servidor.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
