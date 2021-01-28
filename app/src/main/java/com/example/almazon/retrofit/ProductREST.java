package com.example.almazon.retrofit;

import android.content.Context;
import android.widget.Toast;

import com.example.almazon.models.Product;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Clase que se encarga de realizar las operaciones en la entidad producto. Esta clase contiene las
 * operaciones para realizar un CRUD completo: creado de producto, obtención de producto,
 * actualización y borrado de producto.
 */
public class ProductREST {
    private Retrofit retrofit;
    private Context context;
    private Product product;

    /**
     * Constructor de la clase. Contiene la instancia de Retrofit y el contexto.
     * @param context obtiene los recursos de esta clase.
     */
    public ProductREST(Context context) {
        this.retrofit = RetroFitInstancer.getRetrofitInstance();
        this.context = context;
    }

    /**
     * Crea un producto en la base de datos.
     * @param product es el objeto que se va a persistir.
     */
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

    /**
     * Obtiene un producto de la base de datos.
     *
     * @param idProduct string que contiene el id del producto para obtenerlo de la base de datos.
     * @param callback informa a otra clase si la operación en esta clase se ha realizado.
     * @return responde null en caso de un error fatal.
     */
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

    /**
     * Actualiza un producto en la base de datos.
     * @param product es el objeto que va a ser actualizado en la base de datos.
     */
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

    /**
     * Elimina un producto en la base de datos.
     * @param id es el identificador del objeto que se quiere borrar.
     */
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
