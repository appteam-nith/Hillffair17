package com.nith.appteam.hillffair17.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.nith.appteam.hillffair17.R;


public class QuizScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_score);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int score=getIntent().getIntExtra("score",0);

        TextView sc=(TextView)findViewById(R.id.score_obtained);
        sc.setText(score+"");

        findViewById(R.id.quiz_home_link).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),QuizCategoryActivity.class));
                finish();
            }
        });

    }
    @Override
    public  void onBackPressed(){
        startActivity(new Intent(this,HomescreenNew.class));
        finish();
    }
}
