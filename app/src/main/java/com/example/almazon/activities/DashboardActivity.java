package com.example.almazon.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.almazon.MainActivity;
import com.example.almazon.R;
import com.google.android.material.navigation.NavigationView;
import com.example.almazon.models.User;

/**
 * Actividad que se encarga de dar la bienvenida al usuario con su nombre. Contiene menú desplegable
 * a su izquierda para poder hacer dos operaciones: crear producto y gestionar producto existente
 * en base de datos.
 */
public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private User user;
    private TextView welcome;
    public static final int CREATE_PRODUCT = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Obtiene usuario desde WelcomeActivity, que a su vez lo transporta desde el MainActivity.
        Intent intent = getIntent();
        this.user = (User) intent.getSerializableExtra("user");

        this.welcome = (TextView) findViewById(R.id.txt_greeting);
        welcome.setText("Welcome, " + user.getName());
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
            Intent intent = new Intent(DashboardActivity.this, CreateProductActivity.class);
            intent.putExtra("user", user);
            startActivityForResult(intent, CREATE_PRODUCT);
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