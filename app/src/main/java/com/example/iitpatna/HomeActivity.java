package com.example.iitpatna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.iitpatna.cseMain.CSEActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar;
    BottomNavigationView btmnavview;
    Intent iEEE;
    Intent iAdminlogin;
    FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        drawer = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.NavigationView);
        toolbar = findViewById(R.id.toolbar);
        btmnavview = findViewById(R.id.BtmNavView);
        loadfrag(new HomeFragment(),0);


        toolbar.setTitle("IIT Patna");
        toolbar.setSubtitle("Bihta, Patna");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        auth = FirebaseAuth.getInstance();

        iEEE = new Intent(this,EEEActivity.class);

        // *********---TOOLBAR---**********




        //*************--navigation drawer--**************

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if(id==R.id.Accounts){
                    Toast.makeText(HomeActivity.this, "Accounts", Toast.LENGTH_SHORT).show();
                    Intent iAccount = new Intent(HomeActivity.this, ProfileActivity.class);
                    startActivity(iAccount);
                }
                else if(id==R.id.Settings){
                    Toast.makeText(HomeActivity.this, "Setting", Toast.LENGTH_SHORT).show();

                }
                else if(id==R.id.AdminLogin){
                    Toast.makeText(HomeActivity.this, "AdminLogin", Toast.LENGTH_SHORT).show();

                    iAdminlogin = new Intent(HomeActivity.this, AdminLoginActivity.class);
                    startActivity(iAdminlogin);
                    finish();
                }
                else if(id==R.id.Logout){
                    android.app.AlertDialog.Builder alert = new AlertDialog.Builder(HomeActivity.this);
                    alert.setTitle("Delete");
                    alert.setMessage("Are you sure");
                    alert.setIcon(R.drawable.ic_baseline_delete_24);
                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            auth.signOut();
                            Intent ilogin = new Intent(HomeActivity.this, LoginActivity.class);
                            startActivity(ilogin);
                            finish();
                        }
                    });
                    alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(HomeActivity.this, "canceled", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alert.show();

                }



                return true;
            }
        });



        //************--Bottom navigation--**********


        btmnavview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.navHome) {
                loadfrag(new HomeFragment(),1);
                    toolbar.setSubtitle("Home");
                }
                else if(id==R.id.navNoticeBoard){
                    loadfrag(new NoticeBoardFragment(),1);
                    toolbar.setSubtitle("Notice Board");
                }
                else if(id==R.id.navMediaCoverage){
                  loadfrag(new MediaCoverageFragment(),1);
                    toolbar.setSubtitle("Media Coverage");
                }
               else if(id==R.id.navNIRF){
                    loadfrag(new NIRFFragment(),1);
                    toolbar.setSubtitle("NIRF");
                }
               else{
                   loadfrag(new MapFragment(),1);
                    toolbar.setSubtitle("Map");

                }


                return true;
            }




        });

         btmnavview.setSelectedItemId(R.id.navHome);



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
            loadfrag(new HomeFragment(),1);
            toolbar.setSubtitle("home");
        }
        else if(id==R.id.ComputerScience){
           Intent icse = new Intent(HomeActivity.this, CSEActivity.class);
           startActivity(icse);

        }
        else if(id==R.id.Electrical){

            startActivity(iEEE);

            //toolbar.setSubtitle("Electrical Engineering");

        }

        return true;
    }
}