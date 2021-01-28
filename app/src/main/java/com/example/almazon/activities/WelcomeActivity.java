package com.example.almazon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Display;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.airbnb.lottie.LottieAnimationView;
import com.example.almazon.MainActivity;
import com.example.almazon.R;
import com.example.almazon.models.User;

/**
 * Actividad de transición entre el login y el dashboard. Contiene una animación de bienvenida, una
 * transición del logo de la empresa, un sonido y un progressbar.
 */
public class WelcomeActivity extends AppCompatActivity {

    private Integer anchoPantalla;
    private Integer altoPantalla;
    private ImageView imageAlmazon;
    private LottieAnimationView animationView;
    private MediaPlayer mediaPlayer;
    private WelcomeActivity context;
    private CountDownTimer countDownTimer;
    public boolean timerStopped;
    public ProgressBar progressBar;
    public Integer total;
    public CountDownTimer cdt;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        setupMediaPlayer();

        this.user= (User) getIntent().getSerializableExtra("user");
        imageAlmazon= (ImageView)findViewById(R.id.imageAlmazon);
        Animation myFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        imageAlmazon.startAnimation(myFadeInAnimation);

        //Ejecuta el audio.
        mediaPlayer.start();

        context = this;
        startTimer();

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //Establece el tiempo que va a durar el progressbar en llenarse.
        final int oneMin = 1 * 7 * 1000;

        //Cambia graficamente el progreso de la barra segun el tiempo transcurrido.
        new CountDownTimer(oneMin, 1000) {
            public void onTick(long millisUntilFinished) {
                long finishedSeconds = oneMin - millisUntilFinished;
                int total = (int) (((float)finishedSeconds / (float)oneMin) * 100.0);
                progressBar.setProgress(total);
            }
            public void onFinish() {
                //Acción a realizar en caso de superar el minuto. Nunca se llega a ejecutar en
                //este caso.
            }
        }.start();

    }

    /**
     * Obtiene el audio del archivo de recursos.
     */
    private void setupMediaPlayer() {
        mediaPlayer = new MediaPlayer();
        Context context = getApplicationContext();
        mediaPlayer = MediaPlayer.create(context, R.raw.welcome_sound);
    }



    /**
     * Comienza la cuenta.
     */
    public void startTimer() {
        setTimerStartListener();
        timerStopped = false;
    }

    /**
     * Para la cuenta.
     */
    public void stopTimer() {
        countDownTimer.cancel();
        timerStopped = true;
    }

    /**
     * Método que va a establecer cuanto va a durar esta actividad.
     */
    private void setTimerStartListener() {

        countDownTimer = new CountDownTimer(7500, 7500) {
            public void onTick(long millisUntilFinished) {

            }
            public void onFinish() {
                //Al acabar la cuenta, realizar un intent a dashboard.
                Intent intent = new Intent(context, DashboardActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        }.start();
    }


}