package com.nith.appteam.hillffair17.Activities;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



import com.nith.appteam.hillffair17.Models.ProfileDataModel;
import com.nith.appteam.hillffair17.Notification.NotificationActivity;
import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Utils.APIINTERFACE;
import com.nith.appteam.hillffair17.Utils.Connection;
import com.nith.appteam.hillffair17.Utils.SharedPref;
import com.nith.appteam.hillffair17.Utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomescreenNew extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    private static final int PERMISSIONS_REQUEST_PHONE_CALL = 100;
    private static String[] PERMISSIONS_PHONECALL = {Manifest.permission.CALL_PHONE};
    final String number[] = {"9882654141", "9882852966"};
    int a=0;
    private SharedPref pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initCollapsingToolbar();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, 0, 0);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        pref = new SharedPref(this);

        if(new Connection(this).isInternet()){
            profileBasicInfo(pref.getUserId());
        }

    }



    public void openQuiz(View v){
        Intent i = new Intent(this,QuizCategoryActivity.class);
        startActivity(i);
    }
    public void openNewsfeed(View v){
        Intent i = new Intent(this,WallIntroActivity.class);
        startActivity(i);
    }
    public void openMap(View v){
        Intent i = new Intent(this,MapActivity.class);
        startActivity(i);
    }
    public void openClubs(View v){
        Intent i = new Intent(this,EventActivity.class);
        startActivity(i);
    }
    public void openCoreteam(View v){
        Intent i = new Intent(this,CoreTeamActivity.class);
        startActivity(i);
    }
    public void openBattleday(View v){
        Intent i = new Intent(this,BattleDayActivity.class);
        startActivity(i);
    }
    public void openSponsors(View v){
        Intent i = new Intent(this,SponsorActivity.class);
        startActivity(i);
    }
    public void openContributors(View v){
        Intent i = new Intent(this,ContributorsActivity.class);
        startActivity(i);
    }
    public void openNotification(View v){
        Intent i = new Intent(this,NotificationActivity.class);
        startActivity(i);
    }
    public void openPolls(View v){
//        Intent i = new Intent(this,PollsActivity.class);
//        startActivity(i);
    }



    @Override
    public void onBackPressed(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        SharedPref pref= new SharedPref(this);
//        setTheme(pref.getThemeId());
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.context_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.logout) {
            pref.setUserId(null);
            pref.setUserRollno(null);
            pref.setUserName(null);
            startActivity(new Intent(HomescreenNew.this,LoginActivity.class));
            finish();
            return true;

        } else if(id == R.id.contacts){

            CharSequence name[] = {"Deepak Kumar Jain\n(Hillffair Secretary)\n9882654141\n",
                    "Rishabh Bhandari\n(Clubs Secretary)\n9882852966\n"};


            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(android.R.drawable.ic_menu_call);
            builder.setTitle("Emergency Contact");
            builder.setItems(name, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    a=i;
                    call(a);
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch(id) {
            case R.id.profile:
                startActivity(new Intent(HomescreenNew.this, ProfileActivity.class));
                break;
//            case R.id.settings:
//                startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
//                finish();
//                break;
//            case R.id.settings:
//                startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
//                finish();
//                break;
            case R.id.aboutus:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(String.format("%1$s", getString(R.string.app_name)));
                builder.setMessage(getResources().getText(R.string.aboutus_text));
                builder.setPositiveButton("OK", null);
                builder.setIcon(R.drawable.ic_action_about);
                AlertDialog welcomeAlert = builder.create();
                welcomeAlert.show();
                break;

            case R.id.report:  Intent intent = new Intent(Intent.ACTION_SENDTO);
                String uriText = "mailto:" + Uri.encode("appteam.nith@gmail.com") + "?subject=" +
                        Uri.encode("Reporting A Bug/Feedback") + "&body=" + Uri.encode("Hello, Appteam \nI want to report a bug/give feedback corresponding to the app Hillfair 2k16.\n.....\n\n-Your name");

                Uri uri = Uri.parse(uriText);
                intent.setData(uri);
                startActivity(Intent.createChooser(intent, "Send Email"));
                break;
            case R.id.license:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setTitle(String.format("%1$s", getString(R.string.open_source_licenses)));
                CharSequence str=getResources().getText(R.string.licenses_text);
                builder2.setMessage(str );
                builder2.setPositiveButton("OK", null);
                AlertDialog welcomeAlert2 = builder2.create();
                welcomeAlert2.show();
                ((TextView) welcomeAlert2.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());
                break;
            case R.id.notification:
                startActivity(new Intent(HomescreenNew.this, NotificationActivity.class));
                break;
            case R.id.logout:
//                if(pref.getLoginStatus()){
                    pref.setUserId(null);
                    pref.setUserRollno(null);
                    pref.setUserName(null);
                    startActivity(new Intent(HomescreenNew.this,LoginActivity.class));
                    finish();
//                }
//                else{
//                    Toast.makeText(this,"Please Login first",Toast.LENGTH_LONG).show();
//                }
                break;

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });

    }

    private void profileBasicInfo(String id){

        APIINTERFACE mAPI = Utils.getRetrofitService();
        Call<ProfileDataModel> mService = mAPI.profileBasicInfo(id);

        mService.enqueue(new Callback<ProfileDataModel>() {
            @Override
            public void onResponse(Call<ProfileDataModel> call, Response<ProfileDataModel> response) {
                if(response!=null && response.isSuccess()){
                    if(response.body().isSuccess()){
                        ProfileDataModel model = response.body();
                        //For Testing
                        Log.v("RESPONSE SUCCESS"," "+model.getRollno()+" "+model.getName()+" "+model.getEmail()+ " "+model.getPhoto());

                        if(model!=null){

                            pref.setUserName(model.getName());
                            pref.setUserEmail(model.getEmail());
                            pref.setUserRollno(model.getRollno());
                            pref.setUserPicUrl(model.getPhoto());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ProfileDataModel> call, Throwable t) {
                t.printStackTrace();

            }
        });}



    private void call(int i) {
        // Check the SDK version and whether the permission is already granted or not.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_REQUEST_PHONE_CALL);
        } else {
            //Open call function
            String phone = number[i];
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:+91" + phone));
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_PHONE_CALL) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted
                call(a);
            } else {
                Toast.makeText(this, "Sorry!!! Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
