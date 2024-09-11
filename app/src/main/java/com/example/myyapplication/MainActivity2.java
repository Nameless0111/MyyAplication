package com.example.myyapplication;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {


    private ImageView img;
    private Button startBtn;
    private Button pauseBtn;
    private Button swiBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        img=findViewById(R.id.img_blink);
        startBtn=findViewById(R.id.startButton);
        pauseBtn=findViewById(R.id.pauseButton);
        swiBtn=findViewById(R.id.swiButton);
        Animation blinkAnimation = AnimationUtils.loadAnimation( this, R.anim.blink_animation);

        Animation rotateIn = AnimationUtils.loadAnimation(this, R.anim.ratation);


        img.setVisibility(View.INVISIBLE);
        startBtn.setVisibility(View.INVISIBLE);
        pauseBtn.setVisibility(View.INVISIBLE);
        swiBtn.setVisibility(View.INVISIBLE);


        img.postDelayed(() -> {
            img.setVisibility(View.VISIBLE);
            img.startAnimation(rotateIn);
        }, 500);

        startBtn.postDelayed(() -> {
            startBtn.setVisibility(View.VISIBLE);
            startBtn.startAnimation(rotateIn);
        }, 700);

        pauseBtn.postDelayed(() -> {
            pauseBtn.setVisibility(View.VISIBLE);
            pauseBtn.startAnimation(rotateIn);
        }, 1500);

        swiBtn.postDelayed(() -> {
            swiBtn.setVisibility(View.VISIBLE);
            swiBtn.startAnimation(rotateIn);
        }, 2000);

        startBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) { img.startAnimation (blinkAnimation); }});
        pauseBtn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) { img.clearAnimation();}
        });
        swiBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent, ActivityOptions.makeCustomAnimation(this, R.anim.actchngg, 0).toBundle());
        });
    }
}