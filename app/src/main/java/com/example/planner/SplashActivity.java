package com.example.planner;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.planner.Login.LoginActivity; // urmeaza a fi implementata
import com.example.planner.Login.PasswordInput;


public class SplashActivity extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        getSupportActionBar().setElevation(0);//remove shadow under toolbar manually
        handler = new Handler();
        handler.postDelayed(() -> {
            SharedPreferences pref;
            pref = getSharedPreferences("preference", MODE_PRIVATE);
            if(pref.getBoolean("firststart", true)){
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
            else{
                Intent launchlogin = new Intent(SplashActivity.this, PasswordInput.class);
                startActivity(launchlogin);
                finish();
            }
        }, 3000);


    }
}
//SharedPreferences pref;
//        pref = getSharedPreferences("login_data", MODE_PRIVATE);
//
//        if(pref.getBoolean("firststart", true)){
//            SharedPreferences.Editor editor = pref.edit();
//            editor.putBoolean("firststart", false);
//            editor.commit(); // apply changes
//            Intent setup = new Intent(getApplicationContext(), NameSetter.class);
//            startActivity(setup);
//
//        }

