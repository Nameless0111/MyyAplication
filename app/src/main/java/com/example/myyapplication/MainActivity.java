package com.example.myyapplication;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView animationIV;
    private Button startBtn;

    private Button pauseBtn;
    private Button swiBtn;
    private AnimationDrawable frameAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
        animationIV = findViewById(R.id.animImageView);
        startBtn = findViewById(R.id.startButton);
        pauseBtn = findViewById(R.id.pauseButton);
        swiBtn = findViewById(R.id.switchButton);
        frameAnimation = (AnimationDrawable) animationIV.getDrawable();
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        animationIV.startAnimation(fadeIn);


        startBtn.startAnimation(fadeIn);
        pauseBtn.startAnimation(fadeIn);
        swiBtn.startAnimation(fadeIn);
        startBtn.setOnClickListener(v -> {

        if (!frameAnimation.isRunning()) {

        frameAnimation.start();}
        });
        pauseBtn.setOnClickListener(v -> {
            if (frameAnimation.isRunning()) { frameAnimation.stop();
            }
        });
        swiBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent, ActivityOptions.makeCustomAnimation(this, R.anim.actchng, 0).toBundle());
        });

    }
}