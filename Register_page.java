package com.example.mydesign;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class Register_page extends AppCompatActivity {
    ColorDrawable colorDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        ActionBar actionBar = getSupportActionBar();
        colorDrawable= new ColorDrawable(Color.parseColor("#9485e0"));
        actionBar.setBackgroundDrawable(colorDrawable);
    }
}