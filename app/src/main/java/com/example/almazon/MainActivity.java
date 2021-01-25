package com.example.almazon;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.almazon.activities.WelcomeActivity;
import com.example.almazon.models.Company;
import com.example.almazon.models.User;
import com.example.almazon.models.UserPrivilege;
import com.example.almazon.models.UserStatus;
import com.example.almazon.retrofit.UserApiService;
import com.example.almazon.utils.security.AsymmetricEncryption;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static final String TAG = MainActivity.class.getSimpleName();
    static final String BASE_URL = "http://192.168.0.19:8080/CRUD-Server/webresources/";
    static Retrofit retrofit = null;
    private AsymmetricEncryption ae;
    private String pk;

    public static final int WELCOME_ACTIVITY = 1;

    private Button login = null;
    private EditText txtUser = null;
    private EditText txtPassword = null;
    private User user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connect();

        user = new User();
        usuarioPrueba();

        txtUser =  findViewById(R.id.txtUsername);
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
                /*Aqui se accede al String de la public Key con el metodo response.body();
                ¿Hay que asignarselo a una variable y, cuando hagamos el login, encriptarlo?
                 */

                ae = new AsymmetricEncryption(response.body());
            }
            @Override
            public void onFailure(Call<String> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });
    }

    @Override
    public void onClick(View v) {
        /*Intent welcomeActivity=new Intent(this, WelcomeActivity.class);
        welcomeActivity.putExtra("user",user);
        startActivity(welcomeActivity);*/
        User user = new User();
        user.setUsername("hensly");
        user.setPassword(ae.encryptString("1234$%Mm"));
        UserApiService userApiService = retrofit.create(UserApiService.class);
        Call<User> call = userApiService.loginUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                System.out.println("AAAAAAAAAAAAAAA");
            }
            @Override
            public void onFailure(Call<User> call, Throwable throwable) {
                System.out.println("BBBBBBBBBBBBBBB");
            }
        });
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void usuarioPrueba(){
        this.user.setName("Lola");
        this.user.setUsername("Dolores");
        this.user.setPassword("abcd*1234");
    }
}