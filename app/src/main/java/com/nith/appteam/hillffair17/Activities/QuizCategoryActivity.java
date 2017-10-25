package com.nith.appteam.hillffair17.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.nith.appteam.hillffair17.Adapters.QuizCategoryAdapter;
import com.nith.appteam.hillffair17.Adapters.QuizSubCategoryAdapter;
import com.nith.appteam.hillffair17.Models.CategoryQuizModel;
import com.nith.appteam.hillffair17.Models.CategoryQuizSingleModel;
import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Utils.APIINTERFACE;
import com.nith.appteam.hillffair17.Utils.RecyclerItemClickListener;
import com.nith.appteam.hillffair17.Utils.Utils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizCategoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<CategoryQuizSingleModel> categories;
    private ProgressBar progressBar;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_category);
        progressBar = (ProgressBar) findViewById(R.id.category_progress);
        toolbar = (Toolbar) findViewById(R.id.category_toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.category_recycler);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progressBar.setVisibility(View.VISIBLE);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent i=new Intent(QuizCategoryActivity.this,QuizSubCategoryActivity.class);
                i.putExtra("Category_Name",categories.get(position).getName());
                startActivity(i);
            }
        }));
        getCategories();
    }
    public void getCategories()
    {
        APIINTERFACE mapi = Utils.getRetrofitService();
        Call<CategoryQuizModel> mService = mapi.getCategories("Category");
        mService.enqueue(new Callback<CategoryQuizModel>() {
            @Override
            public void onResponse(Call<CategoryQuizModel> call, Response<CategoryQuizModel> response) {
                if(response!=null && response.isSuccess())
                {
                    categories = response.body().getCategories();
                    System.out.println(categories.size());
                    if(categories.size()>0)
                    {
                        System.out.println(categories.get(0).getName());
                        adapter = new QuizCategoryAdapter(categories,getApplicationContext());

                    }
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);
                }
                else
                {
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<CategoryQuizModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
            }
        });

    }




}
