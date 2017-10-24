package com.nith.appteam.hillffair17.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.TextView;

import com.nith.appteam.hillffair17.R;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class PollActivity extends AppCompatActivity implements View.OnClickListener {

    Button opt1,opt2,opt3,opt4;
    TextView ques;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll);
        String question=fetchQuestion();
        ArrayList<String>options=fetchOptions();

        ques=(TextView) findViewById(R.id.poll_ques);
        opt1=(Button)findViewById(R.id.option1);
        opt2=(Button)findViewById(R.id.option2);
        opt3=(Button)findViewById(R.id.option3);
        opt4=(Button)findViewById(R.id.option4);

        opt1.setOnClickListener(this);
        opt2.setOnClickListener(this);
        opt3.setOnClickListener(this);
        opt4.setOnClickListener(this);
    }


    String fetchQuestion(){
        String res="";
        //get question
        return res;
    }

    ArrayList<String> fetchOptions(){
        ArrayList<String>res=new ArrayList<>();
        //get options
        return res;
    }

    void updateResult(int option){
        //incrementoption res
        //open activity
        startActivity(new Intent(PollActivity.this,PlotActivity.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.option1:updateResult(1);
                break;
            case R.id.option2:updateResult(2);
                break;
            case R.id.option3:updateResult(3);
                break;
            case R.id.option4:updateResult(4);
                break;
        }
    }
}
