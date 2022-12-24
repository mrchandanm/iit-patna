package com.example.iitpatna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

public class EEEActivity extends AppCompatActivity  {
    AppCompatButton EEdropdownbtn;
   Toolbar EEToolbar;


    // *************---Toolbar---***************


    //********----Toolbar---****************

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eeeactivity);
       EEdropdownbtn = findViewById(R.id.EEdropdownbtn);
       EEToolbar = findViewById(R.id.EEToolbar);
       EEToolbar.setTitle("Electrical Engineering");
       EEToolbar.setSubtitle("EE");
       EEToolbar.setTitleTextColor(Color.WHITE);
       EEToolbar.setSubtitleTextColor(Color.WHITE);

        setSupportActionBar(EEToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        loadfrag(new EEFragment(), 0);




       EEdropdownbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu eepopup = new PopupMenu(EEEActivity.this,EEdropdownbtn);
                eepopup.getMenuInflater().inflate(R.menu.eemenu, eepopup.getMenu());
                eepopup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        if(id==R.id.EE){
                            loadfrag(new EEFragment(),1);
                            EEdropdownbtn.setText("EE");
                            EEToolbar.setSubtitle("EE");
                        }
                        else if(id==R.id.EEDirectory){
                            loadfrag(new EEDirectoryFragment(),1);
                                EEdropdownbtn.setText("Directory");
                                EEToolbar.setSubtitle("Directory");

                        }

                        else if(id==R.id.EECourse){
                            loadfrag(new EECoursesFragment(),1);
                            EEdropdownbtn.setText("Courses");
                            EEToolbar.setSubtitle("Courses");

                        }
                        else if(id==R.id.EENewsEvents){
                            EEToolbar.setSubtitle("News & Events");

                        }
                        else if(id==R.id.EEPeople){


                        }
                        else if(id==R.id.EEBtech2021){

                            loadfrag(new EEBtech2021UGStudentsFragment(),1);
                            EEdropdownbtn.setText("B.Tech 2021");
                            EEToolbar.setSubtitle("B,Tech 2021");
                        }
                        else if(id==R.id.EEFacilities){

                        }
                        else if (id==R.id.EENewsandEvents){

                        }
                        else if(id==R.id.EEAdmission) {

                        }
                        else if(id==R.id.EEResearch){

                        }



                        return true;
                    }

                });
                eepopup.show();

            }
        });





    }


    public void loadfrag(Fragment fragment, int flag){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag==0) {
            ft.add(R.id.EEcontainer,  fragment);

        }
        else{
            ft.replace(R.id.EEcontainer, fragment);
        }
        ft.commit();
    }


    // *************-----Toolbar----********
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        new MenuInflater(EEEActivity.this).inflate(R.menu.eemenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.EE){
            loadfrag(new EEFragment(),1);
            EEToolbar.setSubtitle("EE");
            EEdropdownbtn.setText("Electrical Engineering");

        }
        else if(id==R.id.EEDirectory){
            loadfrag(new EEDirectoryFragment(),1);
            EEdropdownbtn.setText("Directory");
            EEToolbar.setSubtitle("Directory");

        }

        else if(id==R.id.EECourse){
            loadfrag(new EECoursesFragment(),1);
            EEdropdownbtn.setText("Courses");
            EEToolbar.setSubtitle("Courses");

        }
        else if(id==R.id.EENewsEvents){
            EEToolbar.setSubtitle("News & Events");
        }
        else if(id==R.id.EEPeople){
            EEToolbar.setSubtitle("People");
        }
        else if(id==R.id.EEBtech2021){

            loadfrag(new EEBtech2021UGStudentsFragment(),1);
            EEdropdownbtn.setText("B.Tech 2021");
            EEToolbar.setSubtitle("B,Tech 2021");
        }

        else if(id==R.id.EEFacilities){

        }
        else if (id==R.id.EENewsandEvents){

        }
        else if(id==R.id.EEAdmission) {

        }
        else if(id==R.id.EEResearch){

        }
        else if(id==android.R.id.home){
            super.onBackPressed();

        }
        return super.onOptionsItemSelected(item);
    }
}




