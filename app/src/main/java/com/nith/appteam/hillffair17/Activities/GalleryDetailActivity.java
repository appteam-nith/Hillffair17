package com.nith.appteam.hillffair17.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;


import com.nith.appteam.hillffair17.Adapters.GalleryDetailAdapter;
import com.nith.appteam.hillffair17.Models.GalleryDetail;
import com.nith.appteam.hillffair17.Models.GalleryDetailResponse;
import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Utils.Connection;
import com.nith.appteam.hillffair17.Utils.RotateDownPageTransformer;
import com.nith.appteam.hillffair17.Utils.Utils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryDetailActivity extends AppCompatActivity {
private ViewPager pager;
private GalleryDetailAdapter adapter;
private ProgressBar progressBar;
    private static final String ID="id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_gallery_detail);
        pager= (ViewPager) findViewById(R.id.galleryViewPager);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        adapter=new GalleryDetailAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setPageTransformer(true,new RotateDownPageTransformer());
        Intent i=getIntent();
        if(i!=null){
            if(new Connection(this).isInternet()){
                getGalleryData(i.getStringExtra(ID));
            }
            else {
                progressBar.setVisibility(View.GONE);
            }
        }



    }

    private void getGalleryData(String id){
        Call<GalleryDetailResponse> call= Utils.getRetrofitService().getGalleryResponse(id);
        call.enqueue(new Callback<GalleryDetailResponse>() {
            @Override
            public void onResponse(Call<GalleryDetailResponse> call, Response<GalleryDetailResponse> response) {
                GalleryDetailResponse b=response.body();
                if(response.isSuccess()&&b!=null){
                    ArrayList<GalleryDetail> list=b.getGalleryDetailArrayList();
                    adapter.refresh(list);
                    progressBar.setVisibility(View.GONE);
                    pager.setVisibility(View.VISIBLE);

                }
                else{
                    progressBar.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<GalleryDetailResponse> call, Throwable t) {
                t.printStackTrace();
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
