
package com.nith.appteam.hillffair17.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nith.appteam.hillffair17.R;


public class AboutActivity extends AppCompatActivity {

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initCollapsingToolbar();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void openBottomSheet(View v) {
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        TextView txtBackup = (TextView) view.findViewById(R.id.txt_backup);
        TextView txtDetail = (TextView) view.findViewById(R.id.txt_detail);
        TextView txtOpen = (TextView) view.findViewById(R.id.txt_open);
        final TextView txtUninstall = (TextView) view.findViewById(R.id.txt_uninstall);
        final Dialog mBottomSheetDialog = new Dialog(AboutActivity.this, R.style.MaterialDialogSheet);
        mBottomSheetDialog.setContentView(view);
        mBottomSheetDialog.setCancelable(true);
        mBottomSheetDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        mBottomSheetDialog.getWindow().setGravity(Gravity.BOTTOM);
        mBottomSheetDialog.show();
        txtBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ContributorsActivity.this, "Clicked Backup", Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(AboutActivity.this, BattleDayActivity.class);
                startActivity(i1);
                finish();
                mBottomSheetDialog.dismiss();
            }
        });
        txtDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this, "Clicked Detail", Toast.LENGTH_SHORT).show();
                mBottomSheetDialog.dismiss();
            }
        });
        txtOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ContributorsActivity.this, "Clicked Open", Toast.LENGTH_SHORT).show();
                Intent i3 = new Intent(AboutActivity.this, EventActivity.class);
                startActivity(i3);
                finish();
                mBottomSheetDialog.dismiss();
            }
        });
        txtUninstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ContributorsActivity.this, "Clicked Uninstall", Toast.LENGTH_SHORT).show();
                Intent i4 = new Intent(AboutActivity.this, SponsorActivity.class);
                startActivity(i4);
                finish();
                mBottomSheetDialog.dismiss();
            }
        });
    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("About Hill'ffair");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }



}

