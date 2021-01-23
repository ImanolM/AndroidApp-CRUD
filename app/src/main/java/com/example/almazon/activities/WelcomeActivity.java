package com.example.almazon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Display;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.almazon.R;

public class WelcomeActivity extends AppCompatActivity {

    private Integer anchoPantalla;
    private Integer altoPantalla;
    private ImageView imageAlmazon;
    private LottieAnimationView animationView;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        setupMediaPlayer();

        getIntent().getSerializableExtra("user");
        imageAlmazon= (ImageView)findViewById(R.id.imageAlmazon);
        Animation myFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        imageAlmazon.startAnimation(myFadeInAnimation);

        mediaPlayer.start();


    }

    private void setupMediaPlayer() {
        mediaPlayer = new MediaPlayer();
        Context context = getApplicationContext();
        mediaPlayer = MediaPlayer.create(context, R.raw.welcome_sound);
    }


}