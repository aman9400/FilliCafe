package com.example.fillicafe.UI.Dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fillicafe.R;
import com.example.fillicafe.utils.Constant;
import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    NavigationView navigationView;
    Fragment fragment = null;
    private ListView nav_list;
    ImageView imageViewnav;
    TextView nav_version;
    TextView navUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Window window = this.getWindow();
// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorAccent));
        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        disableNavigationViewScrollbars(navigationView);
//
        navigationView.setVerticalScrollBarEnabled(false);

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.baselinemenu);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#ffffff\">" + " Home " + "</font>"));

        Fragment selectedFrag = new HomeFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_dash, selectedFrag).commit();

        nav_list = (ListView) findViewById(R.id.lv_main_nav);

        View headerView = navigationView.getHeaderView(0);
        navUsername = (TextView) headerView.findViewById(R.id.nav_header_name);
        imageViewnav = headerView.findViewById(R.id.nav_header_imageView);
        nav_version = headerView.findViewById(R.id.nav_version);

//        Picasso.get().load().placeholder().into(imageView);


        mapGridData();

//        updateNavigationView();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        // Set action bar title

        setTitle(item.getTitle());

        // Close the navigation drawer

        drawer.closeDrawers();

        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void mapGridData() {
        NavBarAdapter navBarAdapter = new NavBarAdapter(Dashboard.this, Constant.nav_menu_txt, Constant.nav_menu_icon);
        nav_list.setAdapter(navBarAdapter);
        nav_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0: {
                        Fragment selectedFrag = new HomeFragment();

                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_dash, selectedFrag).commit();
//                        Toast.makeText(getApplicationContext(), R.string.dash_home, Toast.LENGTH_SHORT).show();
                        break;
                    }
                    /*case 1: {
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        //   Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 2: {
                        startActivity(new Intent(getApplicationContext(), ChangePassword.class));
                        //  Toast.makeText(this, "Change Password", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 3 : {
                        startActivity(new Intent(Dashboard.this,Transaction.class));
//                        Toast.makeText(Dashboard.this, "transections", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 4: {
                        startActivity(new Intent(getApplicationContext(), AboutUs.class));
                        //  Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 5:{
                        startActivity(new Intent(Dashboard.this,HelpAndSupport.class));
                        break;
                    } case 6: {
                        startActivity(new Intent(Dashboard.this,Feedback.class));
                        break;
                    }
                    case 7: {
                        startActivity(new Intent(getApplicationContext(), ContactUs.class));
                        break;
                    }

                    *//*case 8 : {
                        startActivity(new Intent(Dashboard.this,ReferAndEarn.class));
                        break;
                    }*//*


                    case 8: {
                        startActivity(new Intent(Dashboard.this,TermsAndConditions.class));
                        Toast.makeText(Dashboard.this, "Terms and conditions", Toast.LENGTH_SHORT).show();
                        break;
                    }*/
                   /* case 9: {

                        final Dialog dialog = new Dialog(Dashboard.this);
                        dialog.setContentView(R.layout.dialoglogout);
                        dialog.setTitle("Logout");
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                        dialog.setCancelable(false);
//
                        Button yes = (Button) dialog.findViewById(R.id.YES);
//

                        Button no = (Button) dialog.findViewById(R.id.NO);
//
                        yes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                apilogout();
                                progressDialog.show();

                                dialog.dismiss();

                            }
                        });
                        no.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });

                        dialog.show();
                        break;
                    }*/

                    default:
                        break;
                }
                drawer.closeDrawers();
            }
        });


    }
}