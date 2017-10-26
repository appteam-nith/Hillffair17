package com.nith.appteam.hillffair17.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import com.nith.appteam.hillffair17.Models.PollStatistics;
import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Utils.Utils;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlotActivity extends AppCompatActivity {


    TextView ques;
    String qid;

    PieChart pieChart;

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,HomescreenNew.class));
        finish();
    }

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

        pieChart=findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);
        ques=findViewById(R.id.plot_ques);
        ques.setText(question);
        pieChart.setDrawHoleEnabled(false);
        pieChart.setDescription("");
        pieChart.setNoDataText("");
        pieChart.setNoDataTextDescription("");
        pieChart.invalidate();

        plotData();

    }

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


                   ArrayList<Entry>yvalues=new ArrayList<>();
                   ArrayList<String> xVals = new ArrayList<>();
                   yvalues.add(new Entry(Float.parseFloat(model.getnOptionA()), 0));
                   yvalues.add(new Entry(Float.parseFloat(model.getnOptionB()), 1));
                   yvalues.add(new Entry(Float.parseFloat(model.getnOptionC()), 2));
                   yvalues.add(new Entry(Float.parseFloat(model.getnOptionD()), 3));

                   xVals.add(model.getOptionA());
                   xVals.add(model.getOptionB());
                   xVals.add(model.getOptionC());
                   xVals.add(model.getOptionD());



                   pieChart.getLegend().setEnabled(false);
                   PieDataSet dataSet = new PieDataSet(yvalues, "");
                   dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                   PieData data = new PieData(xVals, dataSet);

                   data.setValueTextSize(13f);
                   data.setValueTextColor(Color.WHITE);
                   data.setValueFormatter(new PercentFormatter());
                   pieChart.setData(data);
                   pieChart.invalidate();
               }
               else{
                   Log.v("fgchjjghjkl","surazzz");

               }

           }

           @Override
           public void onFailure(Call<PollStatistics> call, Throwable t) {
               Toast.makeText(PlotActivity.this,"Error While Fetching Data.",Toast.LENGTH_SHORT).show();
           }
       });
   }
}
