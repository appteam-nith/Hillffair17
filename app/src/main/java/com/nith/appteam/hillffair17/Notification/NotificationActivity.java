package com.nith.appteam.hillffair17.Notification;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.nith.appteam.hillffair17.Adapters.LeaderBoardAdapter;
import com.nith.appteam.hillffair17.Adapters.Notification;
import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Utils.APIINTERFACE;
import com.nith.appteam.hillffair17.Utils.SharedPref;
import com.nith.appteam.hillffair17.Utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NotificationActivity extends AppCompatActivity {

    Notification notification;
    List<notification_model> arrayList;
    Notification adapter;
    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        SharedPref pref= new SharedPref(this);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Toolbar toolbar= (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Notifications");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progressBar = (ProgressBar) findViewById(R.id.category_progress);
        //   arrayList=dbHandler.gethomedata();
        arrayList=new ArrayList<>();

        Log.v("aa",""+arrayList);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView = (RecyclerView)findViewById(R.id.activity_notification_listview);
        notification = new Notification(arrayList,NotificationActivity.this);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(notification);
        getdata();

//        recyclerView.addOnItemTouchListener(new OnItemTouchListener(NotificationActivity.this, new OnItemTouchListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int db_position) {
//                //  int  position = db_position+1;
//                int n = arrayList.size();
//                int pos=n-db_position;
//                NotificationArrayModel home_post2 = arrayList.get(db_position);
//                String id = home_post2.getNotification_id();
//                Intent expand = new Intent(getApplicationContext(), Notification2.class);
//                Log.d("afasdf","intent_putextrats"+id+"g12112ddddd"+db_position);
//                expand.putExtra("id",id);
//                 startActivity(expand);
//
//            }
//        }));

    }
// 23.92.25.213
    private void getdata() {
        APIINTERFACE mAPI = Utils.getRetrofitService();
        Call<NotificationArrayModel> mService = mAPI.loadnotification();
        mService.enqueue(new Callback<NotificationArrayModel>() {
            @Override
            public void onResponse(Call<NotificationArrayModel> call, Response<NotificationArrayModel> response) {
                Log.d("LOG", "RESPONSE" + response);
                // //Toast.makeText(getApplicationContext(), "Response" + response.toString(), //Toast.LENGTH_SHORT).show();
                arrayList.clear();

                try {
                    JSONArray json1 = null;
                    JSONObject json = null;
                    Log.d("Response body " ,"Hello!"+response.body());
                    if ( response.body().getList().size() > 0)
                    {
                        Log.d("OnReponsefn","entering if condition");
                        arrayList = response.body().getList();
                        Log.d("Log" + "Response" ," inside the try catch..."+ arrayList.toString());
                        adapter = new Notification(arrayList, getApplicationContext());
                        recyclerView.setAdapter(adapter);


                    }
                    progressBar.setVisibility(View.GONE);
//
                }
                catch (Exception e)
                {
                    Toast.makeText(NotificationActivity.this, "Data not recieved", Toast.LENGTH_SHORT).show();
                    Log.e("Error",e.toString());
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<NotificationArrayModel> call, Throwable t) {

            }
        });


        //  load//Toast.success();

    }

}


