package com.example.almazon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.almazon.R;
import com.example.almazon.models.Product;
import com.example.almazon.retrofit.OnProductResponse;
import com.example.almazon.retrofit.ProductREST;

public class ProductManagerActivity extends AppCompatActivity {
    private Button searchButton;
    private EditText searchField;

    private EditText product_name;
    private EditText product_price;
    private EditText product_weight;
    private Button updateButton;
    private Button deleteButton;

    public static Product currentProduct = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_manager);
        product_name = findViewById(R.id.product_name);
        product_price = findViewById(R.id.product_price);
        updateButton = findViewById(R.id.btn_update);
        deleteButton = findViewById(R.id.btn_delete);
        product_weight = findViewById(R.id.product_weight);
        searchButton = findViewById(R.id.btn_search);
        searchField = findViewById(R.id.searchField);
        searchField.setText("1");


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductREST pr = new ProductREST(getApplicationContext());
                Product e = pr.getProduct(searchField.getText().toString(), new OnProductResponse() {

                    @Override
                    public void product(Product product) {
                        // CALLBACK
                        product_name.setText(product.getName());
                        product_price.setText(Float.toString(product.getPrice()));
                        product_weight.setText(Float.toString(product.getWeight()));
                        currentProduct = product;
                    }
                });
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = currentProduct;
                product.setName(product_name.getText().toString());
                product.setPrice(Float.parseFloat(product_price.getText().toString()));
                product.setWeight(Float.parseFloat(product_weight.getText().toString()));
                System.out.println(product.getName());
                ProductREST pr = new ProductREST(getApplicationContext());
                pr.updateProduct(product);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = currentProduct;

                ProductREST pr = new ProductREST(getApplicationContext());
                pr.deleteProduct(product.getId().toString() );
            }
        });
    }


}