package com.nith.appteam.hillffair17.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Adapters.CoreTeamAdapter;
import com.nith.appteam.hillffair17.Models.CoreTeamItem;

import java.util.ArrayList;

public class CoreTeamActivity extends AppCompatActivity {
    RecyclerView recycler_view;
    CoreTeamAdapter core_team_adapter;
    ArrayList<CoreTeamItem> array_list;
    Toolbar core_team_toolbar;
    private static final String BASE_URL="http://hillffair.com/other/images/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_team);
        recycler_view=(RecyclerView)findViewById(R.id.core_team_list);
        array_list=new ArrayList<>();

        array_list.add(new CoreTeamItem("Dr. Saroj Thakur","Faculty Coordinator",BASE_URL+"saroj_thakur.jpg"));
        array_list.add(new CoreTeamItem("Dr. Gargi Khanna","Faculty Co-Coordinator",BASE_URL+"gargi_khanna.jpg"));
        array_list.add(new CoreTeamItem("Dr. Aniket Sharma","Faculty Co-Coordinator",BASE_URL+"aniket_sharma.jpg"));

        array_list.add(new CoreTeamItem("Aditya Khurana","Event Manager",BASE_URL+"aditya_khurana.jpg"));
        array_list.add(new CoreTeamItem("Utkarsh Singh","Cultural Secretary","utkarsh_singh.jpg"));
        array_list.add(new CoreTeamItem("Shivam Kansra","Club Management Secretary","shivam_kansra.jpeg"));
        array_list.add(new CoreTeamItem("Pankaj Thakur","Club Secretary for Performing Arts",BASE_URL+"pankaj_thakur.jpg"));
        array_list.add(new CoreTeamItem("Abhinav Kumar","Finance Secretary",BASE_URL+"abhinav_kumar.jpg"));
        array_list.add(new CoreTeamItem("Shivam Nag","Finance and Treasury",BASE_URL+"shivam_nag.jpg"));
        array_list.add(new CoreTeamItem("Paras","Logistics Secretary",BASE_URL+"paras_dhiman.jpeg"));
        array_list.add(new CoreTeamItem("Setu Sharma","Quality Manger",BASE_URL+"setu_sharma.jpg"));
        array_list.add(new CoreTeamItem("Chandan Shah","Quality Control Secretary",BASE_URL+"chandan_shah.jpeg"));
        array_list.add(new CoreTeamItem("Akhilesh","Organization Secretary",BASE_URL+"akhilesh.jpg"));
        array_list.add(new CoreTeamItem("Sudhanshu Goyal","Jt. Secretary (Organization)",BASE_URL+"sudhanshu_goyal.jpeg"));
        array_list.add(new CoreTeamItem("Aman Shukla","Jt. Secretary (PR)",BASE_URL+"aman_shukla.jpg"));
        array_list.add(new CoreTeamItem("Kashish Dhiman","Jt. Secretary (INS & Control)",BASE_URL+"kashish_dhiman.jpeg"));
        array_list.add(new CoreTeamItem("Aditya Jhakkar","Jt. Secretary(Dramatics)",BASE_URL+"aditya_jhakkar.jpeg"));
        array_list.add(new CoreTeamItem("Kashish Verma","Jt. Secretary(Dance)",BASE_URL+"kashish_verma.jpg"));
        array_list.add(new CoreTeamItem("Nikhil Kumar","Jt. Secretary (Technical Club)",BASE_URL+"nikhil_kumar.jpeg"));
        array_list.add(new CoreTeamItem("Shivam Dhiman","Jt. Secretary (Discipline)",BASE_URL+"shivam_dhiman.jpeg"));
        array_list.add(new CoreTeamItem("Konika Thakur","Jt. Secretary (Fash p)",BASE_URL+"konika_thakur.jpg"));
        array_list.add(new CoreTeamItem("Ankush Sharma","Jt. Secretary(Decoration)",BASE_URL+"ankush_sharma.jpg"));
        array_list.add(new CoreTeamItem("Chanchrik Bhardwaj","Jt. Secretary(Music)",BASE_URL+"chanchrik_bhardwaj.jpeg"));
        array_list.add(new CoreTeamItem("Abhishek Negi","Creative Head",BASE_URL+"abhishek_negi.jpg"));
        array_list.add(new CoreTeamItem("Shivam Tripathi","Graphics Head","shivam_tripathi.jpeg"));
        array_list.add(new CoreTeamItem("Goutham Reddy","Convener (App Team)",BASE_URL+"goutham_reddy.jpg"));
        array_list.add(new CoreTeamItem("Neha Singh","Convener (Organization Club)","neha_singh.jpeg"));
        array_list.add(new CoreTeamItem("Himanshu Tailor","Convener (Hindi Samiti)",BASE_URL+"himanshu_tailor.jpeg"));
        array_list.add(new CoreTeamItem("Agni Thakur","Convener (Dance Club)",BASE_URL+"agni_thakur.jpg"));
        array_list.add(new CoreTeamItem("Aditya Singh Bisht","Convener (Music Club)",BASE_URL+"aditya_singh_bisht.jpeg"));


        array_list.add(new CoreTeamItem("Akhil Verma","Convener (Discipline)",BASE_URL+"akhil_verma.jpg"));
        array_list.add(new CoreTeamItem("Akshay Sharma","Convener (Discipline)",BASE_URL+"akshay_sharma.jpeg"));
        array_list.add(new CoreTeamItem("Saurabh Kumar","Convener (Web Team)",BASE_URL+"saurabh_kumar.jpg"));
        array_list.add(new CoreTeamItem("Anand Atwal","Convener (INS & Control)",BASE_URL+"anand_atwal.jpg"));
        array_list.add(new CoreTeamItem("Didhiti Dhiman","Convener (Fine Arts)",BASE_URL+"didhiti_dhiman.jpeg"));
        array_list.add(new CoreTeamItem("Deepanshu Kohli","Convener (In4mals)","deepanshu_kohli.jpg"));
        array_list.add(new CoreTeamItem("Arpit Chaudhary","Convener (In4mals)",BASE_URL+"arpit_chaudhary.jpg"));
//        array_list.add(new CoreTeamItem("Shivam Mahajan","Convener (Fash P)",BASE_URL+"photos/rishabh_bhandari.jpg"));
        array_list.add(new CoreTeamItem("Navanshu Aggarwal","Convener (English Club)",BASE_URL+"navanshu_agarwal.jpeg"));
        array_list.add(new CoreTeamItem("Vikas","Convener (Decoration)",BASE_URL+"vikas_thapar.jpeg"));
        array_list.add(new CoreTeamItem("Shreshth Talwar","Convener (Public Relations)",BASE_URL+"shreshth_talwar.jpeg"));
        array_list.add(new CoreTeamItem("Vinay Bhatia","Convener (Technical Club)",BASE_URL+"vinay_bhatia.jpg"));




        core_team_adapter=new CoreTeamAdapter(array_list,CoreTeamActivity.this);
        recycler_view.setAdapter(core_team_adapter);
        LinearLayoutManager liner_layout_manager=new LinearLayoutManager(this);
        liner_layout_manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_view.setLayoutManager(liner_layout_manager);

        core_team_toolbar=(Toolbar)findViewById(R.id.core_team_toolbar);
        core_team_toolbar.setTitle("Core Team");
        setSupportActionBar(core_team_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void openBottomSheet(View v) {
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        TextView txtBackup = (TextView) view.findViewById(R.id.txt_backup);
        TextView txtDetail = (TextView) view.findViewById(R.id.txt_detail);
        TextView txtOpen = (TextView) view.findViewById(R.id.txt_open);
        final TextView txtUninstall = (TextView) view.findViewById(R.id.txt_uninstall);
        final Dialog mBottomSheetDialog = new Dialog(CoreTeamActivity.this, R.style.MaterialDialogSheet);
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
                Intent i1 = new Intent(CoreTeamActivity.this, BattleDayActivity.class);
                startActivity(i1);
                finish();
                mBottomSheetDialog.dismiss();
            }
        });
        txtDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CoreTeamActivity.this, "Clicked Detail", Toast.LENGTH_SHORT).show();
                mBottomSheetDialog.dismiss();
            }
        });
        txtOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ContributorsActivity.this, "Clicked Open", Toast.LENGTH_SHORT).show();
                Intent i3 = new Intent(CoreTeamActivity.this, EventActivity.class);
                startActivity(i3);
                finish();
                mBottomSheetDialog.dismiss();
            }
        });
        txtUninstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ContributorsActivity.this, "Clicked Uninstall", Toast.LENGTH_SHORT).show();
                Intent i4 = new Intent(CoreTeamActivity.this, SponsorActivity.class);
                startActivity(i4);
                finish();
                mBottomSheetDialog.dismiss();
            }
        });
    }
}
