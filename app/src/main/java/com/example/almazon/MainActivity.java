package com.example.almazon;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.almazon.activities.DashboardActivity;
import com.example.almazon.activities.WelcomeActivity;
import com.example.almazon.exceptions.PublicKeyNotFoundException;
import com.example.almazon.models.Company;
import com.example.almazon.models.User;
import com.example.almazon.models.UserPrivilege;
import com.example.almazon.models.UserStatus;
import com.example.almazon.retrofit.UserApiService;
import com.example.almazon.utils.security.AsymmetricEncryption;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static final String TAG = MainActivity.class.getSimpleName();
    static final String BASE_URL = "http://192.168.20.76:8080/CRUD-Server/webresources/";
    public static final int DASHBOARD_ACTIVITY = 3;
    static Retrofit retrofit = null;
    private AsymmetricEncryption ae;
    private String pk;

    public static final int WELCOME_ACTIVITY = 1;

    private Button login = null;
    private EditText txtUser;
    private EditText txtPassword;
    private boolean isPublicKeyReady = false;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connect();

        user = new User();

        txtUser = findViewById(R.id.txtUsername);
        txtUser.requestFocus();
        txtPassword = findViewById(R.id.txtPassword);
        login = findViewById(R.id.btnLogin);
        login.setOnClickListener(this);

    }


    private void connect() {

        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

        }
        UserApiService userApiService = retrofit.create(UserApiService.class);
        Call<String> call = userApiService.getPublicKey();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                ae = new AsymmetricEncryption(response.body());
                isPublicKeyReady = true;
                System.out.println("Public key recogida.");
                System.out.println("Public key: " + response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {
                Toast.makeText(getApplicationContext(), "Can't connect the server.", Toast.LENGTH_SHORT).show();
                Log.e(TAG, throwable.toString());
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (!isPublicKeyReady) {
            Toast.makeText(getApplicationContext(), "No puedes iniciar sesión porque ha habido un error al conectarse con el servidor y conseguir la clave pública.", Toast.LENGTH_SHORT).show();
        } else {
            User user = new User();
            user.setUsername(txtUser.getText().toString());
            user.setPassword(ae.encryptString(txtPassword.getText().toString()));
            UserApiService userApiService = retrofit.create(UserApiService.class);
            Call<User> call = userApiService.loginUser(user);
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {

                    System.out.println("Codigo http: " + response.code());
                    if (response.code() == 500) {
                        Toast.makeText(getApplicationContext(), "Login incorrecto.", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                        intent.putExtra("user", response.body());
                        System.out.println(response.body().getEmail());
                        startActivityForResult(intent, DASHBOARD_ACTIVITY);
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable throwable) {
                    Toast.makeText(getApplicationContext(), "Eror al conectar con el servidor.", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}