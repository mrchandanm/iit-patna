package com.example.iitpatna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.iitpatna.cseAdmin.AdminCSEActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class AdminHomeActivity extends AppCompatActivity {
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar;
    BottomNavigationView btmnavview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        drawer = findViewById(R.id.Admindrawer);
        navigationView = findViewById(R.id.NavigationView);
        toolbar = findViewById(R.id.toolbar);
        btmnavview = findViewById(R.id.BtmNavView);

        toolbar.setTitle("Admin App");
        toolbar.setSubtitle("Bihta, Patna");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);


//*************************---Navigation Drawaer---***********************************

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                AdminHomeActivity.this, drawer,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if(id==R.id.AdminAccounts){
                    Toast.makeText(AdminHomeActivity.this, "Accounts", Toast.LENGTH_SHORT).show();

                }
                else if(id==R.id.AdminSettings){
                    Toast.makeText(AdminHomeActivity.this, "Setting", Toast.LENGTH_SHORT).show();

                }
                else if(id==R.id.MainApp){
                  Intent iHome= new Intent(AdminHomeActivity.this, HomeActivity.class);
                  startActivity(iHome);
                  finish();

                }



                return true;
            }
        });

        // ******************Bottom Navigation Bar***************************

        btmnavview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.navHome) {
                    loadfrag(new HomeFragment(),1);
                    toolbar.setSubtitle("Home");
                }
                else if(id==R.id.navNoticeBoard){
                    loadfrag(new AdminNoticeFragments(),1);
                    toolbar.setSubtitle("Notice Board");
                }
                else if(id==R.id.navMediaCoverage){

                    toolbar.setSubtitle("Media Coverage");
                }
                else if(id==R.id.navNIRF){

                    toolbar.setSubtitle("NIRF");
                }
                else{

                    toolbar.setSubtitle("Map");

                }
                return true;
            }
        });
        btmnavview.setSelectedItemId(R.id.navHome);

        // ******************Bottom Navigation Bar***************************





    }

    public void loadfrag(Fragment fragment, int flag){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag==0) {
            ft.add(R.id.ContainerMain,  fragment);
        }
        else{
            ft.replace(R.id.ContainerMain, fragment);
        }
        ft.commit();
    }


    // ***********---Toolbar menu---******
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        new MenuInflater(this).inflate(R.menu.navigation_items,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id==R.id.navHome){
            toolbar.setSubtitle("home");
        }
        else if(id==R.id.ComputerScience){
            Intent icse = new Intent(AdminHomeActivity.this, AdminCSEActivity.class);
            startActivity(icse);
        }
        else if(id==R.id.Electrical){
            Toast.makeText(this, "Electrical", Toast.LENGTH_SHORT).show();

            //toolbar.setSubtitle("Electrical Engineering");

        }

        return true;
    }
}