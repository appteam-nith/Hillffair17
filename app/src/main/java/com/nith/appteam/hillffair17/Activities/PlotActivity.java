package com.nith.appteam.hillffair17.Activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.nith.appteam.hillffair17.Models.PlotModel;
import com.nith.appteam.hillffair17.Models.PollStatistics;
import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Utils.Utils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlotActivity extends AppCompatActivity {

    BarChart chart ;
    ArrayList<BarEntry> barEntry ;
    ArrayList<String> barEntryLabels ;
    BarDataSet barDataset ;
    BarData barData ;
    TextView ques;
    String qid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plot);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        ab.setDisplayHomeAsUpEnabled(true);
        qid=getIntent().getStringExtra("qid");
        String question=getIntent().getStringExtra("question");
        chart = findViewById(R.id.chart1);
        ques=findViewById(R.id.plot_ques);

        ques.setText(question);



        chart.setScaleEnabled(false);
        chart.setDescription("");
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisLeft().setAxisMinValue(0);
        chart.getLegend().setEnabled(false);

        barEntry = new ArrayList<>();
        barEntryLabels = new ArrayList<>();

//        updateBarEntry();
//        updateBarLabels("whateve");
        plotData();

    }
/***dummy code***/
    public void updateBarEntry(){

        barEntry.add(new BarEntry(0, 0));
        barEntry.add(new BarEntry(0, 1));
        barEntry.add(new BarEntry(0, 2));
        barEntry.add(new BarEntry(0, 3));

    }

    public void updateBarLabels(String label){

        barEntryLabels.add(label);
        barEntryLabels.add(label);
        barEntryLabels.add(label);
        barEntryLabels.add(label);

    }
/*****/
   public void plotData(){
    Call<PollStatistics> call=Utils.getRetrofitService().getStats(qid);
       call.enqueue(new Callback<PollStatistics>() {
           @Override
           public void onResponse(Call<PollStatistics> call, Response<PollStatistics> response) {
               if (response.isSuccess()) {

                   PollStatistics model=response.body();
                   Log.e("res",model.getnOptionA());
                   Log.e("res",model.getnOptionB());
                   Log.e("res",model.getnOptionC());
                   Log.e("res",model.getnOptionD());
                   Log.e("res",model.getOptionA());
                   Log.e("res",model.getOptionB());
                   Log.e("res",model.getOptionC());
                   Log.e("res",model.getOptionD());
                   barEntry.add(new BarEntry(Float.parseFloat(model.getnOptionA()),0));
                   barEntry.add(new BarEntry(Float.parseFloat(model.getnOptionB()),1));
                   barEntry.add(new BarEntry(Float.parseFloat(model.getnOptionC()),2));
                   barEntry.add(new BarEntry(Float.parseFloat(model.getnOptionD()),3));
                   ques.setText(model.getQuestion());
                   barEntryLabels.add(model.getOptionA());
                   barEntryLabels.add(model.getOptionB());
                   barEntryLabels.add(model.getOptionC());
                   barEntryLabels.add(model.getOptionD());
                   barDataset = new BarDataSet(barEntry, "response");
                   barData = new BarData(barEntryLabels, barDataset);
                   barDataset.setColors(ColorTemplate.COLORFUL_COLORS);
                   chart.setData(barData);
                   chart.animateY(3000);
               }
           }

           @Override
           public void onFailure(Call<PollStatistics> call, Throwable t) {

               Toast.makeText(PlotActivity.this,"Error While Fetching Data.",Toast.LENGTH_SHORT).show();
           }
       });
   }
}
