package com.example.almazon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.almazon.MainActivity;
import com.example.almazon.R;
import com.example.almazon.models.Product;
import com.example.almazon.models.User;
import com.example.almazon.retrofit.ProductApiService;
import com.example.almazon.retrofit.ProductREST;
import com.example.almazon.retrofit.UserApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateProductActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_sendProduct = null;
    private EditText txt_productName = null;
    private EditText txt_productUnit = null;
    private EditText txt_productWeight = null;
    Product product = null;
    static Retrofit retrofit = null;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);
        Intent intent = getIntent();
        this.user = (User) intent.getSerializableExtra("user");
        txt_productName = findViewById(R.id.txt_productName);
        txt_productName.requestFocus();
        txt_productUnit = findViewById(R.id.txt_productUnit);
        txt_productWeight = findViewById(R.id.txt_productWeight);
        btn_sendProduct = findViewById(R.id.btn_sendProduct);
        btn_sendProduct.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        product = new Product();
        product.setName(txt_productName.getText().toString());
        float numberUnit = Float.valueOf(txt_productUnit.getText().toString());
        float numberWeight = Float.valueOf(txt_productWeight.getText().toString());
        product.setPrice(numberUnit);
        product.setWeight(numberWeight);
        product.setUser(user);

        new ProductREST(getApplicationContext()).createProduct(product);
    }


}
