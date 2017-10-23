package com.nith.appteam.hillffair17.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Utils.SharedPref;


public class QuizActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button enter_quiz,leaderboard,instructions_button;
    private SharedPref pref;
    private CoordinatorLayout coordinatorLayout;
    private Intent i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPref pref= new SharedPref(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_home);

        final SharedPref sp=new SharedPref(this);
        i1 = this.getIntent();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        coordinatorLayout= (CoordinatorLayout) findViewById(R.id.core_view);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        enter_quiz=(Button)findViewById(R.id.enter_quiz);
        instructions_button=(Button)findViewById(R.id.quiz_instructions_link);

        final SharedPref finalPref = new SharedPref(this);

        enter_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if(finalPref.getUserId().isEmpty()){
                        Snackbar.make(coordinatorLayout,"Please Login To Attempt Quiz", Snackbar.LENGTH_INDEFINITE).setAction("Login", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(QuizActivity.this,HomeActivity.class));
                            }
                        }).show();
                    }else{

                       Intent i = new Intent(QuizActivity.this,QuizQuestionActivity.class);
                        i.putExtra("Category_Name",i1.getExtras().getString("Category_Name"));
                        i.putExtra("Topic_Name",i1.getExtras().getString("Topic_Name"));
                        startActivity(i);
                    }

            }
        });

        instructions_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizActivity.this,AboutActivity.class));
            }
        });

    }

}
