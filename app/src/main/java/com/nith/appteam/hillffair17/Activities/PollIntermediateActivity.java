package com.nith.appteam.hillffair17.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll_intermediate);
        progressBar = (ProgressBar) findViewById(R.id.category_progress);
        progressBar.setVisibility(View.VISIBLE);

        pref = new SharedPref(this);

        fetchQuestion(this);
    }
    void fetchQuestion(final Context context){
        if(!pref.getLoginStatus()) {
            startActivity(new Intent(context,LoginActivity.class));
            return;
        }
        Log.e("error",""+pref.getUserId());
        String uid=pref.getUserId();
        Call<PollModel> call=  Utils.getRetrofitService().getPoll(uid);
        call.enqueue(new Callback<PollModel>() {
            @Override
            public void onResponse(Call<PollModel> call, Response<PollModel> response) {

                PollModel model=response.body();
                Log.e("error",""+model.getQid());
                if(!model.isDone()){

                    Intent i = new Intent(context,PastPolls.class);

                    startActivity(i);
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

}
