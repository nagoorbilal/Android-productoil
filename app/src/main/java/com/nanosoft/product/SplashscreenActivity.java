package com.nanosoft.product;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class SplashscreenActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progressStatus = 0;
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getSupportActionBar().hide();


        setContentView(R.layout.activity_splashscreen);

        progressBar = (ProgressBar) findViewById(R.id.progressBar_cyclic);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashscreenActivity.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    }



