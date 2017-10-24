package com.nith.appteam.hillffair17.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.nith.appteam.hillffair17.R;

import java.util.ArrayList;

public class PlotActivity extends AppCompatActivity {

    BarChart chart ;
    ArrayList<BarEntry> barEntry ;
    ArrayList<String> barEntryLabels ;
    BarDataSet barDataset ;
    BarData barData ;
    TextView ques;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plot);
        chart = (BarChart) findViewById(R.id.chart1);
        ques=(TextView)findViewById(R.id.plot_ques);
        ques.setText("Who will win Ballon d'or 2017?");
        chart.setScaleEnabled(false);
        chart.setDescription("");
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisLeft().setAxisMinValue(0);

        chart.getLegend().setEnabled(false);

//        chart.setViewPortOffsets(0,-1,0,0);
        barEntry = new ArrayList<>();
        barEntryLabels = new ArrayList<>();
        updateBarEntry();
        updateBarLabels();
        barDataset = new BarDataSet(barEntry, "response");
        barData = new BarData(barEntryLabels, barDataset);
//        barData.setGroupSpace(0.1f);
        barDataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(barData);
        chart.animateY(3000);

    }
    public void updateBarEntry(){

        barEntry.add(new BarEntry(8.5f,0));
        barEntry.add(new BarEntry(8.0f, 1));
        barEntry.add(new BarEntry(6f, 2));
        barEntry.add(new BarEntry(7f, 3));

    }

    public void updateBarLabels(){

        barEntryLabels.add("C.Ronaldo");
        barEntryLabels.add("Messi");
        barEntryLabels.add("Neymar");
        barEntryLabels.add("None of these");

    }
}
