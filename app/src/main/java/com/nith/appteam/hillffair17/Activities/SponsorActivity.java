package com.nith.appteam.hillffair17.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Adapters.SponsorAdapter;
import com.nith.appteam.hillffair17.Models.SponsorItem;

import java.util.ArrayList;

public class SponsorActivity extends AppCompatActivity {
    RecyclerView rvSponsor;
    SponsorAdapter sponsorAdapter;
    Toolbar tbSponsor;
    ArrayList<SponsorItem> sponsorItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor);
//        String BASE_URL="https://s3.ap-south-1.amazonaws.com/hillffair2016/images/";
        String BASE_URL="https://github.com/";
        rvSponsor = (RecyclerView)findViewById(R.id.rvSponsor);

        sponsorItems = new ArrayList<>();

        sponsorItems.add(new SponsorItem("SkyCandle.in",BASE_URL+"appteam-nith.png"));
        sponsorItems.add(new SponsorItem("Board Of School Education, H.P.",BASE_URL+"appteam-nith.png"));
        sponsorItems.add(new SponsorItem("Tata Shaktee",BASE_URL+"appteam-nith.png"));
        sponsorItems.add(new SponsorItem("Cad Desk",BASE_URL+"appteam-nith.png"));
        //  sponsorItems.add(new SponsorItem("",BASE_URL+"appteam-nith4.png"));
        sponsorItems.add(new SponsorItem("HPSEDC",BASE_URL+"appteam-nith.png"));
        sponsorItems.add(new SponsorItem("Ratan Jewellers",BASE_URL+"appteam-nith.png"));
        sponsorItems.add(new SponsorItem("Chankya The Guru",BASE_URL+"appteam-nith.png"));
        sponsorItems.add(new SponsorItem("L'OREAL",BASE_URL+"appteam-nith.png"));

        sponsorAdapter = new SponsorAdapter(sponsorItems,SponsorActivity.this);
        rvSponsor.setAdapter(sponsorAdapter);

        tbSponsor = (Toolbar)findViewById(R.id.tbSponsor);
        tbSponsor.setTitle("Our Sponsors");
        setSupportActionBar(tbSponsor);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager lvmanager = new LinearLayoutManager(this);
        lvmanager.setOrientation(LinearLayoutManager.VERTICAL);
        rvSponsor.setLayoutManager(lvmanager);
    }
}
