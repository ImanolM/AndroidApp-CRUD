package com.example.almazon.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.almazon.R;
import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Cogemos el NavigationMenu, que es donde estan todos los componentes, y le asignamos
        // el listener para estar a la escucha cuando el usuario clicke en algun elemento del
        // menu. Los siguientes items del menu estan asignanos en /res/menu/my_navigation_items.xml
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Cogemos la id del item seleccionado
        int id = item.getItemId();

        // Comprobamos cual item a sido seleccionado y segun cual ha sido, hacer las acciones
        // necesarias
        if (id == R.id.itemCreateProduct) {
            Intent welcomeActivity = new Intent(this, CreateProductActivity.class);
            startActivity(welcomeActivity);
        } else if (id == R.id.itemProductManager) {
            Intent welcomeActivity = new Intent(this, ProductManagerActivity.class);
            startActivity(welcomeActivity);
        }
        // "opcional" Al hacer click en algun item, volver a esconder el menu desplegable con una
        // animacion. Esta accion se podria quitar, ya que el item que se seleccione se va a cambiar
        // de vista, con lo cual esta animacion seria algo useless
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}