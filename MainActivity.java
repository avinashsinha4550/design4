package com.example.mydesign;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button btn_login,btn_register;
    EditText email_edittext,password_edittext;
    ActionBar actionBar;
    ColorDrawable colorDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Action_bar_color_change(actionBar,colorDrawable);
        email_edittext=(EditText)findViewById(R.id.login_edittext_email);
        password_edittext=(EditText)findViewById(R.id.login_password);
        btn_login=(Button) findViewById(R.id.button);
        btn_register=(Button)findViewById(R.id.login_register_button);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             boolean true_email=   Emailvalidation(email_edittext);
               boolean true_password= Passwordpattern(password_edittext);
                Both_email_password(true_email,true_password,email_edittext,password_edittext,btn_login);

            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent=new Intent(MainActivity.this,Register_page.class);
            startActivity(intent);
            }
        });
    }

    private void Action_bar_color_change(ActionBar actionBar, ColorDrawable colorDrawable) {
        actionBar=getSupportActionBar();
        colorDrawable= new ColorDrawable(Color.parseColor("#dca3cf"));
        actionBar.setBackgroundDrawable(colorDrawable);
    }

    public boolean Emailvalidation(EditText emailvalidation)
    {
        String email;
        email=emailvalidation.getText().toString();
        boolean email_correct=!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches();
       if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
           Toast.makeText(MainActivity.this, "Email correct", Toast.LENGTH_SHORT).show();
       } else
       {
           Toast.makeText(MainActivity.this, "Email_incorrect", Toast.LENGTH_SHORT).show();
       }

        return email_correct;
    }
    public boolean Passwordpattern(EditText password_edittext)
    {
        String password,pattern_part;
        pattern_part="[a-zA-Z0-9\\!\\@\\#\\$]{8,24}";
        password=password_edittext.getText().toString();
        Pattern PATTERN_VALIDATION=Pattern.compile(pattern_part);
        boolean password_correct=PATTERN_VALIDATION.matcher(password).matches();
        if(PATTERN_VALIDATION.matcher(password).matches())
        {
            Toast.makeText(MainActivity.this, "Password correct", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this, "Password_incorrect", Toast.LENGTH_SHORT).show();
        }
        return password_correct;

    }
    public void Both_email_password(boolean true_email,boolean true_pass,EditText email_edittext,EditText password_edittext,Button btn_login)
    {
     if (true_email && true_pass)
     {
         Toast.makeText(MainActivity.this, "great_work_mate", Toast.LENGTH_SHORT).show();
         email_edittext.setText("");
         password_edittext.setText("");
         btn_login.setText("Continue >");
         Intent intent=new Intent(MainActivity.this,LoginActivity.class);
         startActivity(intent);
     }else {
         Toast.makeText(MainActivity.this, "better luck next time", Toast.LENGTH_SHORT).show();
     }
    }
}