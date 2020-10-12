package com.astzz.shoprider;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SystemClock.sleep(3000);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent SpleshScreen = new Intent(getApplicationContext(), DataEntryActivity.class);
        startActivity(SpleshScreen);
        finish();

    }

}