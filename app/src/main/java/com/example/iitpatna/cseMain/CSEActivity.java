package com.example.iitpatna.cseMain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.iitpatna.R;
import com.example.iitpatna.cseCSEFragment;

import java.util.Objects;

public class CSEActivity extends AppCompatActivity {
    AppCompatButton csedropdownbtn;
    Toolbar cseToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cseactivity);
        csedropdownbtn = findViewById(R.id.csedropdownbtn);
        cseToolbar = findViewById(R.id.cseToolbar);
        cseToolbar.setTitle("Computer science");
        cseToolbar.setSubtitle("CSE");
        cseToolbar.setTitleTextColor(Color.WHITE);
        cseToolbar.setSubtitleTextColor(Color.WHITE);
        setSupportActionBar(cseToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        loadfrag(new cseCSEFragment(), 0);

        csedropdownbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu csepopup = new PopupMenu(CSEActivity.this, csedropdownbtn);
                csepopup.getMenuInflater().inflate(R.menu.csemenu, csepopup.getMenu());
                csepopup.show();
            }
        });
    }
    public void loadfrag(Fragment fragment, int flag){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag==0) {
            ft.add(R.id.csecontainer,  fragment);

        }
        else{
            ft.replace(R.id.csecontainer, fragment);
        }
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        new MenuInflater(CSEActivity.this).inflate(R.menu.csemenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.CSE){
            loadfrag(new cseCSEFragment(), 1);
            csedropdownbtn.setText("CSE");
            Toast.makeText(this, "CSE", Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.CSEBtech2021){
            loadfrag(new CSEBtech2021UGStudentsListFragment(), 1);
            csedropdownbtn.setText("Btech 2021");
        }
        else if(id==R.id.CSEBtech2020){
            loadfrag(new CSEBtech2020UGStudentsListFragments(), 1);
            csedropdownbtn.setText("Btech 2020");
        }
        else if(id==android.R.id.home){
            super.onBackPressed();

        }
        return super.onOptionsItemSelected(item);
    }

}