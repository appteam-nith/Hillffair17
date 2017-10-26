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

import com.nith.appteam.hillffair17.Models.NewsFeed;
import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Adapters.ContributorsAdapter;
import com.nith.appteam.hillffair17.Models.contributorsItem;

import java.util.ArrayList;

public class ContributorsActivity extends AppCompatActivity {

    RecyclerView rvContributors;
    ContributorsAdapter ContributorAdapter;
    Toolbar tbContributers;
    ArrayList<contributorsItem> contributorsItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        // SharedPref pref = new SharedPref(this);
        // setTheme(pref.getThemeId());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contributors);
        String BASE_URL = "https://github.com/";
        rvContributors = (RecyclerView) findViewById(R.id.contributors_view);

        contributorsItems = new ArrayList<>();
//        contributorsItems.add(new contributorsItem("Sahil Badyal", BASE_URL + "sahilbadyal.png", BASE_URL + "sahilbadyal"));
//        contributorsItems.add(new contributorsItem("Nishant Choudhary", BASE_URL + "nishant23j.png", BASE_URL + "nishant23j"));
//        contributorsItems.add(new contributorsItem("Kunal Sharma", BASE_URL + "kunal.png", BASE_URL + "kunal12422"));
//        contributorsItems.add(new contributorsItem("Shubham Naik", BASE_URL + "nrshubham.png", BASE_URL + "nrshubham"));
//        contributorsItems.add(new contributorsItem("Ashima Anand", BASE_URL + "ashima1795.png", BASE_URL + "ashima1795"));

        //contributorsItems.add(new contributorsItem("", BASE_URL + ".png", BASE_URL + ""));


        //3rd Year
        contributorsItems.add(new contributorsItem("Aditya Arora", BASE_URL + "adi23arora.png", BASE_URL + "adi23arora"));
        contributorsItems.add(new contributorsItem("Jatin", BASE_URL + "Jatin0312.png", BASE_URL + "Jatin0312"));
//        contributorsItems.add(new contributorsItem("Kumar Shashwat", BASE_URL + "octacode.png", BASE_URL + "octacode"));
        contributorsItems.add(new contributorsItem("Nitin", BASE_URL + "iamNitin16.png", BASE_URL + "iamNitin16"));
        contributorsItems.add(new contributorsItem("Parvesh Monu", BASE_URL + "Parveshdhull.png", BASE_URL + "Parveshdhull"));
        contributorsItems.add(new contributorsItem("Suraj", BASE_URL + "Akatsuki06.png", BASE_URL + "Akatsuki06"));
        contributorsItems.add(new contributorsItem("Vibhor Garg", BASE_URL + "vibhorg.png", BASE_URL + "vibhorg"));



        //Final Year
        contributorsItems.add(new contributorsItem("Ashish Gurjar", BASE_URL + "akgurjar.png", BASE_URL + "akgurjar"));
        contributorsItems.add(new contributorsItem("Goutham Reddy ", BASE_URL + "zeus512.png", BASE_URL + "zeus512"));
        contributorsItems.add(new contributorsItem("Jalaz Choudhary", BASE_URL + "jaykay12.png", BASE_URL + "jaykay12"));
        contributorsItems.add(new contributorsItem("Narendra Dodwaria", BASE_URL + "narendra36.png", BASE_URL + "narendra36"));
        contributorsItems.add(new contributorsItem("Sahil Ramola", BASE_URL + "RamolaWeb.png", BASE_URL + "RamolaWeb"));
        contributorsItems.add(new contributorsItem("Sukhbir Singh", BASE_URL + "sukhbir-singh.png", BASE_URL + "sukhbir-singh"));
        contributorsItems.add(new contributorsItem("Vijaya Laxmi", BASE_URL + "vijaya22.png", BASE_URL + "vijaya22"));




        //2nd Year
        contributorsItems.add(new contributorsItem("Aditya Wazir", BASE_URL + "adityawazir.png", BASE_URL + "adityawazir"));
        contributorsItems.add(new contributorsItem("Anubhaw Bhalotia", BASE_URL + "anubhawbhalotia.png", BASE_URL + "anubhawbhalotia"));
        contributorsItems.add(new contributorsItem("Bharat Shah", BASE_URL + "bharatshah1498.png", BASE_URL + "bharatshah1498"));
        contributorsItems.add(new contributorsItem("Hemant Singh ", BASE_URL + "joshafest.png", BASE_URL + "joshafest"));
        contributorsItems.add(new contributorsItem("Kaushal Kishor", BASE_URL + "kaushal16124.png", BASE_URL + "kaushal16124"));
        contributorsItems.add(new contributorsItem("Muskan Jhunjhunwalla", BASE_URL + "musukeshu.png", BASE_URL + "musukeshu"));





        //1st Year
        contributorsItems.add(new contributorsItem("Abhinav Lamba", BASE_URL + "Abhinavlamba.png", BASE_URL + "Abhinavlamba"));
        contributorsItems.add(new contributorsItem("Abhiraj Singh Rathore", BASE_URL + "AbhirajSinghRathore.png", BASE_URL + "AbhirajSinghRathore"));
        contributorsItems.add(new contributorsItem("Alisha Mehta", BASE_URL + "Alisha1116.png", BASE_URL + "Alisha1116"));
        contributorsItems.add(new contributorsItem("Anshu Akansha", BASE_URL + "AnshuAkansha52227.png", BASE_URL + "AnshuAkansha52227"));
        contributorsItems.add(new contributorsItem("Daniyaal Khan", BASE_URL + "drtweety.png", BASE_URL + "drtweety"));
        contributorsItems.add(new contributorsItem("Kumar Kartikay", BASE_URL + "Kartikay26.png", BASE_URL + "Kartikay26"));
        contributorsItems.add(new contributorsItem("Mayank Singh", BASE_URL + "Dykn0ww.png", BASE_URL + "Dykn0ww"));
        contributorsItems.add(new contributorsItem("Srajika gupta", BASE_URL + "srajika256.png", BASE_URL + "srajika256"));
        contributorsItems.add(new contributorsItem("Tanvi Mahajan", BASE_URL + "tanvi003.png", BASE_URL + "tanvi003"));
        contributorsItems.add(new contributorsItem("Utkarsh Singh", BASE_URL + "utkarshsingh99.png", BASE_URL + "utkarshsingh99"));
        contributorsItems.add(new contributorsItem("Vishal Parmar", BASE_URL + "Vishal17599.png", BASE_URL + "Vishal17599"));
        contributorsItems.add(new contributorsItem("Rohini Raj", BASE_URL + "rohiniraj123.png", BASE_URL + "rohiniraj123"));


//        contributorsItems.add(new contributorsItem("Anishka Gupta", BASE_URL + "Anishka0107.png", BASE_URL + "Anishka0107"));




        ContributorAdapter = new ContributorsAdapter(contributorsItems, ContributorsActivity.this);
        rvContributors.setAdapter(ContributorAdapter);

        tbContributers = (Toolbar) findViewById(R.id.contributors_toolbar);
        tbContributers.setTitle("Contributors");
        setSupportActionBar(tbContributers);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager lvmanager = new LinearLayoutManager(this);
        lvmanager.setOrientation(LinearLayoutManager.VERTICAL);
        rvContributors.setLayoutManager(lvmanager);
    }


    public void openBottomSheet(View v) {
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        TextView txtBackup = (TextView) view.findViewById(R.id.txt_backup);
        TextView txtDetail = (TextView) view.findViewById(R.id.txt_detail);
        TextView txtOpen = (TextView) view.findViewById(R.id.txt_open);
        final TextView txtUninstall = (TextView) view.findViewById(R.id.txt_uninstall);
        final Dialog mBottomSheetDialog = new Dialog(ContributorsActivity.this, R.style.MaterialDialogSheet);
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
                Intent i1 = new Intent(ContributorsActivity.this, BattleDayActivity.class);
                startActivity(i1);
                finish();
                mBottomSheetDialog.dismiss();
            }
        });
        txtDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContributorsActivity.this, NewsFeed.class));
                mBottomSheetDialog.dismiss();
            }
        });
        txtOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ContributorsActivity.this, "Clicked Open", Toast.LENGTH_SHORT).show();
                Intent i3 = new Intent(ContributorsActivity.this, EventActivity.class);
                startActivity(i3);
                finish();
                mBottomSheetDialog.dismiss();
            }
        });
        txtUninstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ContributorsActivity.this, "Clicked Uninstall", Toast.LENGTH_SHORT).show();
                Intent i4 = new Intent(ContributorsActivity.this, SponsorActivity.class);
                startActivity(i4);
                finish();
                mBottomSheetDialog.dismiss();
            }
        });
    }

    }

