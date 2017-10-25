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
        chart = (BarChart) findViewById(R.id.chart1);
        ques=(TextView)findViewById(R.id.plot_ques);

        ques.setText(question);



        chart.setScaleEnabled(false);
        chart.setDescription("");
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisLeft().setAxisMinValue(0);

        chart.getLegend().setEnabled(false);

//        chart.setViewPortOffsets(0,-1,0,0);
        barEntry = new ArrayList<>();
        barEntryLabels = new ArrayList<>();
//        updateBarEntry();
//        updateBarLabels();
        plotData();

        barDataset = new BarDataSet(barEntry, "response");
        barData = new BarData(barEntryLabels, barDataset);
//        barData.setGroupSpace(0.1f);
        barDataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(barData);
        chart.animateY(3000);

    }
//    public void updateBarEntry(){
//
//        barEntry.add(new BarEntry(8.5f,0));
//        barEntry.add(new BarEntry(8.0f, 1));
//        barEntry.add(new BarEntry(6f, 2));
//        barEntry.add(new BarEntry(7f, 3));
//
//    }
//
//    public void updateBarLabels(String label){
//
//        barEntryLabels.add(label);
//
//    }

   public void plotData(){
    Call<PollStatistics> call=Utils.getRetrofitService().getStats(qid);
       call.enqueue(new Callback<PollStatistics>() {
           @Override
           public void onResponse(Call<PollStatistics> call, Response<PollStatistics> response) {
               if (response.isSuccess()) {
                   Log.v("fgchjjghjkl","addddddditya");
                   PollStatistics model=response.body();
                   Log.v("ERRORRRRRR",response.body().getQuestion()+"");
                   barEntry.add(new BarEntry(Float.parseFloat(model.getnOptionA()),0));
                   barEntry.add(new BarEntry(Float.parseFloat(model.getnOptionB()),1));
                   barEntry.add(new BarEntry(Float.parseFloat(model.getnOptionC()),2));
                   barEntry.add(new BarEntry(Float.parseFloat(model.getnOptionD()),3));
                   ques.setText(model.getQuestion());
                   barEntryLabels.add(model.getOptionA());
                   barEntryLabels.add(model.getOptionB());
                   barEntryLabels.add(model.getOptionC());
                   barEntryLabels.add(model.getOptionD());

               }
               else{
                   Log.v("fgchjjghjkl","surazzz");
                   for(int i=0;i<4;i++){
                       barEntry.add(new BarEntry(1,i));
                       barEntryLabels.add(""+i);
                   }
               }

           }

           @Override
           public void onFailure(Call<PollStatistics> call, Throwable t) {
               for(int i=0;i<4;i++){
                   barEntry.add(new BarEntry(1,i));
                   barEntryLabels.add(""+i);
               }
               Toast.makeText(PlotActivity.this,"Error While Fetching Data.",Toast.LENGTH_SHORT).show();
           }
       });
   }
}
