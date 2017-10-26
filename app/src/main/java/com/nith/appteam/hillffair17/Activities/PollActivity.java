package com.nith.appteam.hillffair17.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nith.appteam.hillffair17.Models.PollModelUserResponse;
import com.nith.appteam.hillffair17.Models.PollModel;
import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Utils.SharedPref;
import com.nith.appteam.hillffair17.Utils.Utils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PollActivity extends AppCompatActivity implements View.OnClickListener {

    Button opt1,opt2,opt3,opt4;
    TextView ques;
    String userid;
    String qid;
    String question;
    String a,b,c,d;

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        ques=(TextView) findViewById(R.id.poll_ques);
        opt1=(Button)findViewById(R.id.option1);
        opt2=(Button)findViewById(R.id.option2);
        opt3=(Button)findViewById(R.id.option3);
        opt4=(Button)findViewById(R.id.option4);


        question=getIntent().getStringExtra("question");
        qid=getIntent().getStringExtra("qid");
        a=getIntent().getStringExtra("optionA");
        b=getIntent().getStringExtra("optionB");
        c=getIntent().getStringExtra("optionC");
        d=getIntent().getStringExtra("optionD");
        
        SharedPref sharedPref=new SharedPref(this);
        userid=sharedPref.getUserId();
        putDetails();

        opt1.setOnClickListener(this);
        opt2.setOnClickListener(this);
        opt3.setOnClickListener(this);
        opt4.setOnClickListener(this);
    }

    void putDetails(){

            ques.setText(question);
            opt1.setText(a);
            opt2.setText(b);
            opt3.setText(c);
            opt4.setText(d);
          
    }

    void updateResult(char option){
        Log.e("Suraz","making requests");
        Call<PollModelUserResponse> updateScore=Utils.getRetrofitService().updateScore(userid,qid,""+option);
        updateScore.enqueue(new Callback<PollModelUserResponse>() {
                @Override
                public void onResponse(Call<PollModelUserResponse> call, Response<PollModelUserResponse> response) {
                    if(response.isSuccess()) {
                        if (!response.body().isSuccess())
                            Toast.makeText(PollActivity.this, "User has already submitted a response.", Toast.LENGTH_SHORT).show();
                        else {
                            Intent intent = new Intent(PollActivity.this, PlotActivity.class);
                            intent.putExtra("qid", qid);
                            intent.putExtra("question", question);
                            startActivity(intent);
                        }
                    }
                }

                @Override
                public void onFailure(Call<PollModelUserResponse> call, Throwable t) {

                    Toast.makeText(PollActivity.this,"Error While Fetching Data.",Toast.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.option1:updateResult('A');
                Log.e("RESULT POLL",1+"");
                break;
            case R.id.option2:updateResult('B');
                Log.e("RESULT POLL",2+"");
                break;
            case R.id.option3:updateResult('C');
                Log.e("RESULT POLL",3+"");
                break;
            case R.id.option4:updateResult('D');
                Log.e("RESULT POLL",4+"");
                break;
        }
    }
}
