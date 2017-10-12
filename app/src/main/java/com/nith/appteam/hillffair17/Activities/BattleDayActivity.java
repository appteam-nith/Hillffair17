
package com.nith.appteam.hillffair17.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.nith.appteam.hillffair17.Adapters.BattleDayAdapter;
import com.nith.appteam.hillffair17.Models.BattleDayItem;
import com.nith.appteam.hillffair17.Models.BattleDayModel;
import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Utils.APIINTERFACE;
import com.nith.appteam.hillffair17.Utils.RecyclerItemClickListener;
import com.nith.appteam.hillffair17.Utils.SharedPref;
import com.nith.appteam.hillffair17.Utils.Utils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BattleDayActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar bar;
    private ArrayList<BattleDayItem> list=new ArrayList<>();
    private BattleDayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPref pref= new SharedPref(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Toolbar toolbar= (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager manager=new LinearLayoutManager(BattleDayActivity.this);
        recyclerView.setLayoutManager(manager);
        adapter=new BattleDayAdapter(BattleDayActivity.this);
        recyclerView.setAdapter(adapter);
        bar=(ProgressBar)findViewById(R.id.progress);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent i=new Intent(BattleDayActivity.this,ClubActivity.class);
                i.putExtra("name",list.get(position).getName());
                i.putExtra("id",list.get(position).getId());
                i.putExtra("battleday",true);

                startActivity(i);
            }
        }));

        bar.setVisibility(View.VISIBLE);
        retrofit();

    }

    public void openBottomSheet(View v) {
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        TextView txtBackup = (TextView) view.findViewById(R.id.txt_backup);
        TextView txtDetail = (TextView) view.findViewById(R.id.txt_detail);
        TextView txtOpen = (TextView) view.findViewById(R.id.txt_open);
        final TextView txtUninstall = (TextView) view.findViewById(R.id.txt_uninstall);
        final Dialog mBottomSheetDialog = new Dialog(BattleDayActivity.this, R.style.MaterialDialogSheet);
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
                Intent i1 = new Intent(BattleDayActivity.this, BattleDayActivity.class);
                startActivity(i1);
                mBottomSheetDialog.dismiss();
            }
        });
        txtDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BattleDayActivity.this, "Clicked Detail", Toast.LENGTH_SHORT).show();
                mBottomSheetDialog.dismiss();
            }
        });
        txtOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ContributorsActivity.this, "Clicked Open", Toast.LENGTH_SHORT).show();
                Intent i3 = new Intent(BattleDayActivity.this, ClubActivity.class);
                startActivity(i3);
                mBottomSheetDialog.dismiss();
            }
        });
        txtUninstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ContributorsActivity.this, "Clicked Uninstall", Toast.LENGTH_SHORT).show();
                Intent i4 = new Intent(BattleDayActivity.this, SponsorActivity.class);
                startActivity(i4);
                mBottomSheetDialog.dismiss();
            }
        });
    }
    public void retrofit(){

        APIINTERFACE apiservice= Utils.getRetrofitService();
        Call<BattleDayModel> call=apiservice.getSpecialEvents();

        call.enqueue(new Callback<BattleDayModel>() {
            @Override
            public void onResponse(Call<BattleDayModel> call, Response<BattleDayModel> response) {
                bar.setVisibility(View.GONE);

                BattleDayModel model=response.body();
                int status=response.code();

                if(model!=null && response.isSuccess()){
                   recyclerView.setVisibility(View.VISIBLE);

                    list=model.getEvents();
                    adapter.refresh(list);

                }else{
                    Toast.makeText(BattleDayActivity.this,"Some error occurred!!",Toast.LENGTH_SHORT).show();
                }

              }

            @Override
            public void onFailure(Call<BattleDayModel> call, Throwable t) {
                bar.setVisibility(View.GONE);
                Toast.makeText(BattleDayActivity.this,"Some error occurred!!",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
