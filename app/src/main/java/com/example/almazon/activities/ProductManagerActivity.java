package com.example.almazon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.almazon.R;
import com.example.almazon.exceptions.StringIsEmptyException;
import com.example.almazon.models.Product;
import com.example.almazon.retrofit.OnProductResponse;
import com.example.almazon.retrofit.ProductREST;
import com.example.almazon.validations.GenericValidations;

/**
 * Actividad encargada de gestionar datos sobre productos. Realia operaciones de consulta, borrado y
 * actualización de producto.
 */
public class ProductManagerActivity extends AppCompatActivity {
    private Button searchButton;
    private EditText searchField;
    private GenericValidations genericValidations = new GenericValidations();
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
        deleteButton.setEnabled(false);
        updateButton.setEnabled(false);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductREST productRest = new ProductREST(getApplicationContext());
                try {
                    genericValidations.checkIfStringIsEmpty(searchField.getText().toString());
                    // Un callback de product que había que hacer porque la llamada es asíncrona
                    productRest.getProduct(searchField.getText().toString(), new OnProductResponse() {
                        @Override
                        public void product(Product product) {
                            // CALLBACK
                            try {
                                product_name.setText(product.getName());
                                product_price.setText(Float.toString(product.getPrice()));
                                product_weight.setText(Float.toString(product.getWeight()));
                                currentProduct = product;
                                deleteButton.setEnabled(true);
                                updateButton.setEnabled(true);
                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), "No se ha encontrado ningún producto con esa id.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } catch (StringIsEmptyException e) {
                    Toast.makeText(getApplicationContext(), "El id está vacío.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = currentProduct;
                try {
                    // Comprueba que los campos sean correctos y en caso de serlos hace una update
                    genericValidations.checkIfStringIsEmpty(product_name.getText().toString());
                    genericValidations.checkIfValueIsFloat(product_price.getText().toString());
                    genericValidations.checkIfValueIsFloat(product_weight.getText().toString());
                    product.setName(product_name.getText().toString());
                    product.setPrice(Float.parseFloat(product_price.getText().toString()));
                    product.setWeight(Float.parseFloat(product_weight.getText().toString()));
                    ProductREST pr = new ProductREST(getApplicationContext());
                    pr.updateProduct(product);
                    Toast.makeText(getApplicationContext(), "Producto actualizado correctamente.", Toast.LENGTH_SHORT).show();

                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Algunos valores que deberían ser numéricos no lo son.", Toast.LENGTH_SHORT).show();
                } catch (StringIsEmptyException e) {
                    Toast.makeText(getApplicationContext(), "El nombre del producto está vacío.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Elimina el producto y vacía los campos
                Product product = currentProduct;
                ProductREST pr = new ProductREST(getApplicationContext());
                pr.deleteProduct(product.getId().toString());
                product_name.setText("");
                product_weight.setText("");
                product_price.setText("");
                searchField.setText("");
                Toast.makeText(getApplicationContext(), "Producto eliminado correctamente.", Toast.LENGTH_SHORT).show();

            }
        });
    }


}