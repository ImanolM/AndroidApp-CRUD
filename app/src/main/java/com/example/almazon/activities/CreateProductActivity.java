package com.example.almazon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.almazon.R;
import com.example.almazon.models.Product;
import com.example.almazon.models.User;

public class CreateProductActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_sendProduct = null;
    private EditText txt_productName = null;
    private EditText txt_productUnit = null;
    private EditText txt_productWeight = null;
    Product product = null;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);

        txt_productName =  findViewById(R.id.txt_productName);
        txt_productName.requestFocus();
        txt_productUnit = findViewById(R.id.txt_productUnit);
        txt_productWeight = findViewById(R.id.txt_productWeight);
        btn_sendProduct = findViewById(R.id.btn_sendProduct);
        btn_sendProduct.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        product = new Product();

    }
}