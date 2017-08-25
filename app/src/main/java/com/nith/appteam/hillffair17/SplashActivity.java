package com.nith.appteam.hillffair17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by shasha on 25/8/17.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Note-@octacode:- Code for Starting Introduction Activity goes here.*/
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
