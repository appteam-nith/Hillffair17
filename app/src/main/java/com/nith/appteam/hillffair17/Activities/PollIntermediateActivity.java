package com.nith.appteam.hillffair17.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nith.appteam.hillffair17.Models.PollModel;
import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Utils.SharedPref;
import com.nith.appteam.hillffair17.Utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PollIntermediateActivity extends AppCompatActivity {
    private SharedPref pref;
    private ProgressBar progressBar;
    private CoordinatorLayout coordinatorLayout;
    private TextView loadingText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll_intermediate);
        progressBar = (ProgressBar) findViewById(R.id.category_progress);
        progressBar.setVisibility(View.VISIBLE);
        coordinatorLayout= (CoordinatorLayout) findViewById(R.id.core_view);
        loadingText = (TextView) findViewById(R.id.loadingText);

        pref = new SharedPref(this);

        fetchQuestion(this);
    }
    void fetchQuestion(final Context context){
        if(!pref.getLoginStatus()) {
            Snackbar.make(coordinatorLayout,"Please Login to use Polls..", Snackbar.LENGTH_INDEFINITE).setAction("Login", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(PollIntermediateActivity.this,LoginActivity.class));
                    finish();
                }
            }).show();
        }
        Log.e("error",""+pref.getUserId());
        String uid=pref.getUserId();
        if(pref.getLoginStatus()){
            Call<PollModel> call=  Utils.getRetrofitService().getPoll(uid);
            call.enqueue(new Callback<PollModel>() {
                @Override
                public void onResponse(Call<PollModel> call, Response<PollModel> response) {

                    PollModel model=response.body();
                    Log.e("error",""+model.getQid());
                    if(!model.isDone()){

                        Intent i = new Intent(context,PastPolls.class);

                        startActivity(i);
                        finish();
                    }
                    else {
                        Intent i = new Intent(context,PollActivity.class);
                        i.putExtra("question",model.getQuestion());
                        i.putExtra("optionA",model.getOptionA());
                        i.putExtra("optionB",model.getOptionB());
                        i.putExtra("optionC",model.getOptionC());
                        i.putExtra("optionD",model.getOptionD());
                        i.putExtra("qid",model.getQid());
                        startActivity(i);
                    }

                }

                @Override
                public void onFailure(Call<PollModel> call, Throwable t) {
                    Toast.makeText(PollIntermediateActivity.this,"Error While Fetching Data.",Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            progressBar.setVisibility(View.INVISIBLE);
            loadingText.setText("Please Login to use Polls..");
        }


    }

}
