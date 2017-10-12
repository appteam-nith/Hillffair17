package com.nith.appteam.hillffair17.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.annotations.SerializedName;
import com.nith.appteam.hillffair17.Activities.EventActivity;
import com.nith.appteam.hillffair17.Models.BattleEventResponse;
import com.nith.appteam.hillffair17.Models.ClubModel;
import com.nith.appteam.hillffair17.Models.ClubModel2;
import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Utils.MyApplication;
import com.nith.appteam.hillffair17.Utils.SharedPref;
import com.nith.appteam.hillffair17.Utils.Utils;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sahil ramola on 5/10/16.
 */

public class ClubActivity extends AppCompatActivity {
    private String club_name;
    private CollapsingToolbarLayout ctl;
    private Toolbar toolbar;
    private ImageView grup_img;
    private TextView clubName;
    private TextView description;
    private FrameLayout frameLayout;
    private ProgressBar progressBar;
    private String id,name;     // battleday

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        SharedPref pref= new SharedPref(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        progressBar= (ProgressBar) findViewById(R.id.progress);
        frameLayout= (FrameLayout) findViewById(R.id.layout_data);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        grup_img= (ImageView) findViewById(R.id.backdrop);
        clubName= (TextView) findViewById(R.id.grup_name);
        description= (TextView) findViewById(R.id.desc_club);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        if (i != null) {
            if (i.hasExtra(EventActivity.CLUB_NAME)){
                club_name = i.getStringExtra(EventActivity.CLUB_NAME);
                showData(club_name);

            }else if(i.hasExtra("battleday")){
                id=i.getStringExtra("id");
                name=i.getStringExtra("name");

                if(name!=null)
                    club_name=name;

                if(id!=null)
                    showSpecialData(id);

            }
            initCollapsingToolbar();

        }
    }

    public void openBottomSheet(View v) {
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        TextView txtBackup = (TextView) view.findViewById(R.id.txt_backup);
        TextView txtDetail = (TextView) view.findViewById(R.id.txt_detail);
        TextView txtOpen = (TextView) view.findViewById(R.id.txt_open);
        final TextView txtUninstall = (TextView) view.findViewById(R.id.txt_uninstall);
        final Dialog mBottomSheetDialog = new Dialog(ClubActivity.this, R.style.MaterialDialogSheet);
        mBottomSheetDialog.setContentView(view);
        mBottomSheetDialog.setCancelable(true);
        mBottomSheetDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        mBottomSheetDialog.getWindow().setGravity(Gravity.BOTTOM);
        mBottomSheetDialog.show();
        txtBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ContributorsActivity.this, "Clicked Backup", Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(ClubActivity.this, BattleDayActivity.class);
                startActivity(i1);
                mBottomSheetDialog.dismiss();
            }
        });
        txtDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ClubActivity.this, "Clicked Detail", Toast.LENGTH_SHORT).show();
                mBottomSheetDialog.dismiss();
            }
        });
        txtOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ContributorsActivity.this, "Clicked Open", Toast.LENGTH_SHORT).show();
                Intent i3 = new Intent(ClubActivity.this, ClubActivity.class);
                startActivity(i3);
                mBottomSheetDialog.dismiss();
            }
        });
        txtUninstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ContributorsActivity.this, "Clicked Uninstall", Toast.LENGTH_SHORT).show();
                Intent i4 = new Intent(ClubActivity.this, SponsorActivity.class);
                startActivity(i4);
                mBottomSheetDialog.dismiss();
            }
        });
    }

    private void showData(final String club_name){
        Call<ClubModel2> getClubData= Utils.getRetrofitService().getClubInfo(club_name);
        getClubData.enqueue(new Callback<ClubModel2>() {
            @Override
            public void onResponse(Call<ClubModel2> call, Response<ClubModel2> response) {
                progressBar.setVisibility(View.INVISIBLE);
                frameLayout.setVisibility(View.VISIBLE);
                ClubModel2 data=response.body();
                if(data!=null&&response.isSuccess()){
                    if(data.isSuccess()){
                        ClubModel clubdata=data.getProfile();
                        clubName.setText(clubdata.getName());
                        description.setText(clubdata.getDescription());
                        Glide.with(MyApplication.getAppContext()).load(clubdata.getPhoto()).diskCacheStrategy(DiskCacheStrategy.ALL).error(R.drawable.news_intro).into(grup_img);
                    }
                    else {
                        progressBar.setVisibility(View.INVISIBLE);
                        frameLayout.setVisibility(View.INVISIBLE);
                        Toast.makeText(ClubActivity.this,"Please Check Your Internet Connection",Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ClubModel2> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                frameLayout.setVisibility(View.INVISIBLE);
                t.printStackTrace();
                Toast.makeText(ClubActivity.this,"Please Check Your Internet Connection",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void showSpecialData(String id){

        Call<ClubActivity.BattleResponseEvent> battleResponseEventCall=Utils.getRetrofitService().getEventData(id);
        battleResponseEventCall.enqueue(new Callback<BattleResponseEvent>() {
            @Override
            public void onResponse(Call<BattleResponseEvent> call, Response<BattleResponseEvent> response) {
                progressBar.setVisibility(View.INVISIBLE);
                frameLayout.setVisibility(View.VISIBLE);
                BattleResponseEvent data=response.body();
                if(data!=null&&response.isSuccess()){
                    if(data.isSuccess()){
                        BattleEventResponse clubdata=data.getData();
                        clubName.setText(clubdata.getEventname());
                        description.setText(clubdata.getEventdescription()+"\n\n"+"Rules:-\n"+clubdata.getRules()+"\n\n"+"Contact:-\n "+"Deepak Kumar Jain 9882654141 \n"+"Rishab Bhandari 988852966");
                        Glide.with(MyApplication.getAppContext()).load(clubdata.getPhoto()).diskCacheStrategy(DiskCacheStrategy.ALL).error(R.drawable.news_intro).into(grup_img);
                    }
                    else {
                        progressBar.setVisibility(View.INVISIBLE);
                        frameLayout.setVisibility(View.INVISIBLE);
                        Toast.makeText(ClubActivity.this,"Please Check Your Internet Connection",Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<BattleResponseEvent> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                frameLayout.setVisibility(View.INVISIBLE);
                t.printStackTrace();
                Toast.makeText(ClubActivity.this,"Please Check Your Internet Connection",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("Club");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }


    public  class BattleResponseEvent{
        @SerializedName("profile")
        private BattleEventResponse data;

        @SerializedName("success")
        private boolean success;

        @SerializedName("msg")
        private String message;

        public BattleResponseEvent(BattleEventResponse data, boolean success, String message) {
            this.data = data;
            this.success = success;
            this.message = message;
        }

        public BattleEventResponse getData() {
            return data;
        }

        public void setData(BattleEventResponse data) {
            this.data = data;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
