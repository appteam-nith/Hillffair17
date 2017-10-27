package com.nith.appteam.hillffair17.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;
import com.nith.appteam.hillffair17.Adapters.ClubEventAdapter;
import com.nith.appteam.hillffair17.Adapters.Notification;
import com.nith.appteam.hillffair17.Models.ClubEvent;
import com.nith.appteam.hillffair17.Notification.NotificationActivity;
import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Utils.RecyclerItemClickListener;
import com.nith.appteam.hillffair17.Utils.SharedPref;
import com.nith.appteam.hillffair17.Utils.Utils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventActivity extends AppCompatActivity {
    public static final String CLUB_ID ="" ;
    private RecyclerView recyclerView;
    private ClubEventAdapter adapter;
    private ProgressBar progressBar;
    private ArrayList<ClubEvent> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPref pref= new SharedPref(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Toolbar toolbar= (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        progressBar= (ProgressBar) findViewById(R.id.progress);
        adapter=new ClubEventAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent i=new Intent(EventActivity.this,ClubActivity.class);
                i.putExtra(CLUB_ID,list.get(position).getId());
                startActivity(i);
            }
        }));
        showData();
    }

    public void openBottomSheet(View v) {
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        TextView txtBackup = (TextView) view.findViewById(R.id.txt_backup);
        TextView txtDetail = (TextView) view.findViewById(R.id.txt_detail);
        TextView txtOpen = (TextView) view.findViewById(R.id.txt_open);
        final TextView txtUninstall = (TextView) view.findViewById(R.id.txt_uninstall);
        final Dialog mBottomSheetDialog = new Dialog(EventActivity.this, R.style.MaterialDialogSheet);
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
                Intent i1 = new Intent(EventActivity.this, NotificationActivity.class);
                startActivity(i1);
                finish();
                mBottomSheetDialog.dismiss();
            }
        });
        txtDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventActivity.this,WallIntroActivity.class));
                mBottomSheetDialog.dismiss();
            }
        });
        txtOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventActivity.this,LeaderBoardActivity.class));

                mBottomSheetDialog.dismiss();
            }
        });
        txtUninstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ContributorsActivity.this, "Clicked Uninstall", Toast.LENGTH_SHORT).show();
                Intent i4 = new Intent(EventActivity.this, SponsorActivity.class);
                startActivity(i4);
                finish();
                mBottomSheetDialog.dismiss();
            }
        });
    }

    public  class ClubResponse{
        @SerializedName("clubs_data")
        private ArrayList<ClubEvent> list;

        @SerializedName("success")
        private boolean success;


        @SerializedName("msg")
        private boolean msg;

        public ArrayList<ClubEvent> getList() {
            return list;
        }

        public void setList(ArrayList<ClubEvent> list) {
            this.list = list;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }


    }

    private  void showData(){

        Call<ClubResponse> getClubResponseCall= Utils.getRetrofitService().getAllClub();

        getClubResponseCall.enqueue(new Callback<ClubResponse>() {
            @Override
            public void onResponse(Call<ClubResponse> call, Response<ClubResponse> response) {
                recyclerView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
                try{
                    ClubResponse clubResponse=response.body();
                    if(clubResponse!=null && response.isSuccess() ){
                        if(clubResponse.isSuccess()){
                            list=clubResponse.getList();
                            adapter.refresh(list);
                        }
                        else {
                            Toast.makeText(EventActivity.this, "Error While Fetching Data", Toast.LENGTH_SHORT).show();

                        }
                    }
                }
                catch (Exception e){
                    Toast.makeText(EventActivity.this, "Check you internet connection..", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<ClubResponse> call, Throwable t) {
                recyclerView.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);
               t.printStackTrace();
                Toast.makeText(EventActivity.this,"Error While Fetching Data",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
// notification
//Newsfeed
// leaderboard
//sponsor
