package com.nith.appteam.hillffair17.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.facebook.share.Share;
import com.nith.appteam.hillffair17.Adapters.PollAdapter;
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
    private ArrayList<PollModel>listPoll;
    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll);
        listPoll = new ArrayList<>();
        uid=new SharedPref(this).getUserId();

        getPastPoll();
        list = (RecyclerView) findViewById(R.id.listPoll);
        adapter = new PollAdapter(listPoll,this);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);
    }

    void getPastPoll(){
        Call<ArrayList<PollModel>> call = Utils.getRetrofitService().getPastPoll(uid);
        call.enqueue(new Callback<ArrayList<PollModel>>() {
            @Override
            public void onResponse(Call<ArrayList<PollModel>> call, Response<ArrayList<PollModel>> response) {

                if(response.isSuccess()){
                    listPoll=response.body();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<PollModel>> call, Throwable t) {

            }
        });
    }
}
