package com.nith.appteam.hillffair17;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntro2Fragment;
import com.nith.appteam.hillffair17.util.Preferences;

/**
 * Created by octacode on 25/8/17.
 */

public class IntroActivity extends AppIntro2 {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Note-@octacode: Adds the App intro fragments*/
        addSlide(AppIntro2Fragment.newInstance("Hillfair", getString(R.string.dummy_desc), R.mipmap.ic_launcher, Color.DKGRAY));
        addSlide(AppIntro2Fragment.newInstance("Hillfair", getString(R.string.dummy_desc), R.mipmap.ic_launcher, Color.YELLOW));
        addSlide(AppIntro2Fragment.newInstance("Hillfair", getString(R.string.dummy_desc), R.mipmap.ic_launcher, Color.MAGENTA));
        addSlide(AppIntro2Fragment.newInstance("Hillfair", getString(R.string.dummy_desc), R.mipmap.ic_launcher, Color.RED));
        addSlide(AppIntro2Fragment.newInstance("Hillfair", getString(R.string.dummy_desc), R.mipmap.ic_launcher, Color.BLUE));
        addSlide(AppIntro2Fragment.newInstance("Hillfair", getString(R.string.dummy_desc), R.mipmap.ic_launcher, Color.CYAN));
        setFlowAnimation();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        setFirstRun();
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        setFirstRun();
        startActivity(new Intent(this, MainActivity.class));
    }

    private void setFirstRun() {
        Preferences.setFirstRun(this);
    }
}
