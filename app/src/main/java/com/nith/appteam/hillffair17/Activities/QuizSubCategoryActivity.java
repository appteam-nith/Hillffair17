package com.nith.appteam.hillffair17.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.nith.appteam.hillffair17.Adapters.QuizCategoryAdapter;
import com.nith.appteam.hillffair17.Models.CategoryQuizModel;
import com.nith.appteam.hillffair17.Models.CategoryQuizSingleModel;
import com.nith.appteam.hillffair17.Models.SubCategoryQuizModel;
import com.nith.appteam.hillffair17.Models.SubCategoryQuizSingleModel;
import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Utils.APIINTERFACE;
import com.nith.appteam.hillffair17.Utils.RecyclerItemClickListener;
import com.nith.appteam.hillffair17.Utils.Utils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizSubCategoryActivity extends AppCompatActivity {
    private String categoryname;
    private ArrayList<SubCategoryQuizSingleModel> subcategories;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<CategoryQuizSingleModel> categories;
    private ProgressBar progressBar;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_sub_category);
        Intent i1 = this.getIntent();
        if(i1!=null)
        {
            categoryname = i1.getExtras().getString("Category_Name");
        }
        progressBar = (ProgressBar) findViewById(R.id.subcategory_progress);
        toolbar = (Toolbar) findViewById(R.id.subcategory_toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.subcategory_recycler);
        setSupportActionBar(toolbar);
        progressBar.setVisibility(View.VISIBLE);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent i = new Intent(getApplicationContext(),QuizActivity.class);
                i.putExtra("Category_Name",categoryname);
                i.putExtra("Topic_Name",subcategories.get(position).getName());
            }
        }));
        getsubcategory();
    }

    public void getsubcategory()
    {
        APIINTERFACE mapi = Utils.getRetrofitService();
        Call<SubCategoryQuizModel> mService = mapi.getSubCategories(categoryname);
        mService.enqueue(new Callback<SubCategoryQuizModel>() {
            @Override
            public void onResponse(Call<SubCategoryQuizModel> call, Response<SubCategoryQuizModel> response) {
                if(response!=null && response.isSuccess())
                {
                    subcategories = response.body().getCategories();
                    if(subcategories.size()>0)
                    {
                        adapter = new QuizCategoryAdapter(categories,getApplicationContext());

                    }
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<SubCategoryQuizModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
