package com.nith.appteam.hillffair17.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2Fragment;
import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Utils.SharedPref;

/**
 * Created by octacode on 25/8/17.
 */

public class IntroActivity extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Note-@octacode: Adds the App intro fragments*/
        addSlide(AppIntro2Fragment.newInstance(getString(R.string.intro_title_hillfair), getString(R.string.intro_desc_hillfair), R.drawable.spectrum_intro, ContextCompat.getColor(this, R.color.intro1)));
        addSlide(AppIntro2Fragment.newInstance(getString(R.string.intro_title_quiz), getString(R.string.intro_desc_quiz), R.drawable.quiz_intro, Color.DKGRAY));
        addSlide(AppIntro2Fragment.newInstance(getString(R.string.intro_title_news), getString(R.string.intro_desc_news), R.drawable.news_intro, ContextCompat.getColor(this, R.color.intro_news)));
        addSlide(AppIntro2Fragment.newInstance(getString(R.string.intro_title_treasure_hunt), getString(R.string.intro_desc_treasure_hunt), R.drawable.treasure_intro, Color.parseColor("#d50000")));
        addSlide(AppIntro2Fragment.newInstance(getString(R.string.intro_title_notification), getString(R.string.intro_desc_notification), R.drawable.notification_intro, Color.DKGRAY));
        addSlide(AppIntro2Fragment.newInstance(getString(R.string.intro_title_ready), getString(R.string.intro_desc_ready), R.drawable.ready_intro, Color.parseColor("#303f9f")));
        setFlowAnimation();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        setFirstRun();
        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        setFirstRun();
        startActivity(new Intent(this, HomeActivity.class));
    }

    private void setFirstRun() {
        SharedPref.setFirstRun(this);
    }
}
