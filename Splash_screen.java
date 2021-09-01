package com.example.mydesign;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;

public class Splash_screen extends AppCompatActivity {
    ActionBar actionBar;
    ColorDrawable colorDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splash_screen.this,MainActivity.class);
                startActivity(intent);

            }
        },5000);
        actionBar=getSupportActionBar();
        colorDrawable= new ColorDrawable(Color.parseColor("#dca3cf"));
        actionBar.setBackgroundDrawable(colorDrawable);
    }
}