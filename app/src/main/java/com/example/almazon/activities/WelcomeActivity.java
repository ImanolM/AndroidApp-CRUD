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

        mediaPlayer.start();

        context = this;
        startTimer();

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        // timer for seekbar
        final int oneMin = 1 * 7 * 1000; // 1 minute in milli seconds

        /** CountDownTimer starts with 1 minutes and every onTick is 1 second */
        new CountDownTimer(oneMin, 1000) {
            public void onTick(long millisUntilFinished) {

                //forward progress
                long finishedSeconds = oneMin - millisUntilFinished;
                int total = (int) (((float)finishedSeconds / (float)oneMin) * 100.0);
                progressBar.setProgress(total);

//                //backward progress
//                int total = (int) (((float) millisUntilFinished / (float) oneMin) * 100.0);
//                progressBar.setProgress(total);

            }

            public void onFinish() {
                // DO something when 1 minute is up
            }
        }.start();

    }

    private void setupMediaPlayer() {
        mediaPlayer = new MediaPlayer();
        Context context = getApplicationContext();
        mediaPlayer = MediaPlayer.create(context, R.raw.welcome_sound);
    }



    /** Starts the timer **/
    public void startTimer() {
        setTimerStartListener();
        timerStopped = false;
    }

    /** Stop the timer **/
    public void stopTimer() {
        countDownTimer.cancel();
        timerStopped = true;
    }

    /** Timer method: CountDownTimer **/
    private void setTimerStartListener() {
        // will be called at every 1500 milliseconds i.e. every 1.5 second.
        countDownTimer = new CountDownTimer(7500, 7500) {
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                // Here do what you like...
                Intent intent = new Intent(context, DashboardActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        }.start();
    }


}