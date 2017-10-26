package com.nith.appteam.hillffair17.Activities;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.facebook.share.Share;
import com.nith.appteam.hillffair17.Adapters.PollAdapter;
import com.nith.appteam.hillffair17.Models.PollListModel;
import com.nith.appteam.hillffair17.Models.PollModel;
import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Utils.SharedPref;
import com.nith.appteam.hillffair17.Utils.Utils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PastPolls extends AppCompatActivity {

    private RecyclerView list;
    private PollAdapter adapter;
    private ArrayList<PollListModel.Question>listPoll;
    Context context;
    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_polls);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        context=this;
        list = (RecyclerView) findViewById(R.id.listPoll);
        listPoll = new ArrayList<>();
        uid=new SharedPref(this).getUserId();
        getPastPoll();
    }

    void getPastPoll() {
        Call<PollListModel> call = Utils.getRetrofitService().getAllPoll();
        call.enqueue(new Callback<PollListModel>() {
            @Override
            public void onResponse(Call<PollListModel> call, Response<PollListModel> response) {
               PollListModel model=response.body();
                ArrayList<PollListModel.Question> questions =model.getQuestions();
                for (PollListModel.Question q:questions){
                    listPoll.add(q);

                    adapter = new PollAdapter(listPoll,context);
                    list.setLayoutManager(new LinearLayoutManager(context));
                    list.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<PollListModel> call, Throwable t) {

            }
        });
    }
}
