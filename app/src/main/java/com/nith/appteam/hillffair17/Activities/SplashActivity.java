package com.nith.appteam.hillffair17.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nith.appteam.hillffair17.Utils.SharedPref;

/**
 * Created by octacode on 25/8/17.
 */

public class SplashActivity extends AppCompatActivity {

    private SharedPref pref;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pref = new SharedPref(this);

        if (SharedPref.getFirstRun(this))
            startActivity(new Intent(this, IntroActivity.class));
        else{
            if(pref.getLoginStatus()){
                startActivity(new Intent(this, HomescreenNew.class));
            }
            else{
                startActivity(new Intent(this, LoginActivity.class));
            }
        }


          //  startActivity(new Intent(this, HomescreenNew.class));

        finish();
    }
}
