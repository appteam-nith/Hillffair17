package com.nith.appteam.hillffair17.Activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.nith.appteam.hillffair17.Adapters.ProfilePagerAdapter;
import com.nith.appteam.hillffair17.Fragments.ProfileTab1;
import com.nith.appteam.hillffair17.Fragments.ProfileTab2;
import com.nith.appteam.hillffair17.Fragments.ProfileTab3;
import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Utils.SharedPref;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {


    //For testing.
    private static final String IMG_URL = "";


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView coverImage;
    private ImageView profilePic;
    private SharedPref sharedPref;


    private void findViews(){

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
        coverImage = (ImageView) findViewById(R.id.cover);
        profilePic = (ImageView) findViewById(R.id.profilePic);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        findViews();

        sharedPref = new SharedPref(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbarLayout.setTitle(sharedPref.getUserName());
        toolbar.setTitle(sharedPref.getUserName());

            Glide.with(this).load(sharedPref.getUserPicUrl()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.person_icon).error(R.drawable.person_icon).into(new ImageViewTarget<Bitmap>(profilePic) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable drawable= RoundedBitmapDrawableFactory.create(getResources(),resource);
                    drawable.setCircular(true);
                    profilePic.setImageDrawable(drawable);
                }
            });




        ArrayList<Fragment> fragmentArrayList=new ArrayList<>();
//        fragmentArrayList.add(new ProfileTab1());
        fragmentArrayList.add(new ProfileTab2());
        fragmentArrayList.add(new ProfileTab3());


        ArrayList<String> titleArrayList=new ArrayList<>();
//        titleArrayList.add("Events");
        titleArrayList.add("Basic info");
        titleArrayList.add("News Feed");
        

        ProfilePagerAdapter adapter = new ProfilePagerAdapter(getSupportFragmentManager(),fragmentArrayList,titleArrayList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(1).select();
        viewPager.setOffscreenPageLimit(3);


    }
}
