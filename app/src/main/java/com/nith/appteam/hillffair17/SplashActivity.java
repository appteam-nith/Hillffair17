package com.nith.appteam.hillffair17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nith.appteam.hillffair17.util.Preferences;

/**
 * Created by octacode on 25/8/17.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Note-@octacode:- Code for Starting Introduction Activity goes here.*/
        if(Preferences.getFirstRun(this))
            startActivity(new Intent(this, IntroActivity.class));
        else
            startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
