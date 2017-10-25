package com.nith.appteam.hillffair17.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
    ArrayList<Integer>score;
    String userid;
    String qid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        ab.setDisplayHomeAsUpEnabled(true);
        ques=(TextView) findViewById(R.id.poll_ques);
        opt1=(Button)findViewById(R.id.option1);
        opt2=(Button)findViewById(R.id.option2);
        opt3=(Button)findViewById(R.id.option3);
        opt4=(Button)findViewById(R.id.option4);

        opt1.setOnClickListener(this);
        opt2.setOnClickListener(this);
        opt3.setOnClickListener(this);
        opt4.setOnClickListener(this);

        SharedPref sharedPref=new SharedPref(this);
        userid=sharedPref.getUserId();
//        fetchQuestion();

    }


    void fetchQuestion(){
        Call<PollModel>getPoll = Utils.getRetrofitService().getPoll(userid);
        getPoll.enqueue(new Callback<PollModel>() {
            @Override
            public void onResponse(Call<PollModel> call, Response<PollModel> response) {
                PollModel model=response.body();
                String question=model.getQuestion();
                ArrayList<String> options=model.getOptions();
                boolean done=model.isDone();
                if (done)  updateResult(-1);

                ques.setText(question);
                qid=model.getQid();
                opt1.setText(options.get(0));
                opt2.setText(options.get(1));
                opt3.setText(options.get(2));
                opt4.setText(options.get(3));
                score=model.getScore();
            }
            @Override
            public void onFailure(Call<PollModel> call, Throwable t) {
                Toast.makeText(PollActivity.this,"Error While Fetching Data",Toast.LENGTH_SHORT).show();
            }
        });
    }

    void updateResult(int option){
    Intent intent=new Intent(PollActivity.this,PlotActivity.class);
        intent.putExtra("qid",qid);
        if(option==-1){

            Call<PollModelUserResponse> updateScore=Utils.getRetrofitService().updateScore(userid,Integer.toString(option));
            updateScore.enqueue(new Callback<PollModelUserResponse>() {
                @Override
                public void onResponse(Call<PollModelUserResponse> call, Response<PollModelUserResponse> response) {
                    if(response.isSuccess()){
                        PollModelUserResponse respons =response.body();
                    }
                    else {

                        Toast.makeText(PollActivity.this,"Couldn't update user response",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<PollModelUserResponse> call, Throwable t) {

                    Toast.makeText(PollActivity.this,"Error While Fetching Data",Toast.LENGTH_SHORT).show();
                }
            });

        }

        startActivity(intent);
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
