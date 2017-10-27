package com.nith.appteam.hillffair17.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nith.appteam.hillffair17.Adapters.Notification;
import com.nith.appteam.hillffair17.Models.NewsFeed;
import com.nith.appteam.hillffair17.Notification.NotificationActivity;
import com.nith.appteam.hillffair17.R;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap map;
    private boolean map_available=false;

    private CameraPosition hamirpur=new CameraPosition.Builder()
            .tilt(25)
            .bearing((float) 112.5)
            .zoom(17)
            .target(new LatLng(31.7084,76.5274))
            .build();

    private CameraPosition current_location;
    private MarkerOptions current_marker;

    private MarkerOptions audi=new MarkerOptions().position(new LatLng(31.706826, 76.527862)).title("Auditorium");
    private MarkerOptions nescafe=new MarkerOptions().position(new LatLng(31.707344, 76.528386)).title("Nescafe");
    private MarkerOptions park=new MarkerOptions().position(new LatLng(31.707091, 76.528574)).title("Student Park");
    private MarkerOptions juice=new MarkerOptions().position(new LatLng(31.705630, 76.528488)).title("Juice Bar");
    private MarkerOptions ground=new MarkerOptions().position(new LatLng(31.706137, 76.524296)).title("Ground");
    private MarkerOptions oat=new MarkerOptions().position(new LatLng(31.705350, 76.525296)).title("OAT");
    private MarkerOptions sbi=new MarkerOptions().position(new LatLng(31.709634, 76.527522)).title("SBI ATM");
    private MarkerOptions ekta=new MarkerOptions().position(new LatLng(31.712125, 76.524279)).title("Ekta Cafe");
    private MarkerOptions h4=new MarkerOptions().position(new LatLng(31.710850, 76.526885)).title("4H FOOD COURT");
    private MarkerOptions g1=new MarkerOptions().position(new LatLng(31.701761, 76.522805)).title("Gate No.1");
    private MarkerOptions pgh=new MarkerOptions().position(new LatLng(31.703807, 76.526077)).title("Girl's Hostel (Proxy: 172.16.32.2:3128)");
    private MarkerOptions kbh=new MarkerOptions().position(new LatLng(31.710529, 76.526711)).title("KBH (Proxy: 172.16.12.2:3128)");
    private MarkerOptions nbh=new MarkerOptions().position(new LatLng(31.710762, 76.523735)).title("NBH (Proxy: 172.16.20.2:3128)");
    private MarkerOptions mega=new MarkerOptions().position(new LatLng(31.709021, 76.523885)).title("Mega (Proxy: 172.16.20.2:3128)");
    private MarkerOptions dbh=new MarkerOptions().position(new LatLng(31.7121013, 76.5253359)).title("DBH (Proxy: 172.16.20.2:3128)");
    private MarkerOptions mmh=new MarkerOptions().position(new LatLng(31.7126458, 76.5261289)).title("MMH (Proxy: 172.16.20.2:3128)");
    private MarkerOptions lib=new MarkerOptions().position(new LatLng(31.707920, 76.527893)).title("Library (Proxy: 172.16.24.2:3128)");
    private MarkerOptions dept=new MarkerOptions().position(new LatLng(31.708563, 76.527408)).title("Departments (Proxy: 172.16.24.2/3:3128)");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        MapFragment mapFragment= (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    public void openBottomSheet(View v) {
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        TextView txtBackup = (TextView) view.findViewById(R.id.txt_backup);
        TextView txtDetail = (TextView) view.findViewById(R.id.txt_detail);
        TextView txtOpen = (TextView) view.findViewById(R.id.txt_open);
        final TextView txtUninstall = (TextView) view.findViewById(R.id.txt_uninstall);
        final Dialog mBottomSheetDialog = new Dialog(MapActivity.this, R.style.MaterialDialogSheet);
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
                Intent i1 = new Intent(MapActivity.this, NotificationActivity.class);
                startActivity(i1);
                finish();
                mBottomSheetDialog.dismiss();
            }
        });
        txtDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(MapActivity.this, "Clicked Detail", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MapActivity.this, WallIntroActivity.class));
                mBottomSheetDialog.dismiss();
            }
        });
        txtOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ContributorsActivity.this, "Clicked Open", Toast.LENGTH_SHORT).show();
                Intent i3 = new Intent(MapActivity.this, LeaderBoardActivity.class);
                startActivity(i3);
                finish();
                mBottomSheetDialog.dismiss();
            }
        });
        txtUninstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ContributorsActivity.this, "Clicked Uninstall", Toast.LENGTH_SHORT).show();
                Intent i4 = new Intent(MapActivity.this, SponsorActivity.class);
                startActivity(i4);
                finish();
                mBottomSheetDialog.dismiss();
            }
        });
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map_available=true;
        map=googleMap;

        map.moveCamera(CameraUpdateFactory.newCameraPosition(hamirpur));
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        map.addMarker(audi);
        map.addMarker(nescafe);
        map.addMarker(park);
        map.addMarker(juice);
        map.addMarker(ground);
        map.addMarker(oat);
        map.addMarker(sbi);
        map.addMarker(ekta);
        map.addMarker(h4);
        map.addMarker(pgh);
        map.addMarker(kbh);
        map.addMarker(g1);
        map.addMarker(nbh);
        map.addMarker(dbh);
        map.addMarker(mega);
        map.addMarker(mmh);
        map.addMarker(lib);
        map.addMarker(dept);

    }
}
