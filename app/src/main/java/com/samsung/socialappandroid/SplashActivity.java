package com.samsung.socialappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.samsung.socialappandroid.auth.CreateUserActivity;
import com.samsung.socialappandroid.services.AuthService;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (AuthService.isSignIn()) {
            startActivity(new Intent(this, MainActivity.class));
        } else  {
            startActivity(new Intent(this, CreateUserActivity.class));
        }
        // TODO
    }
}