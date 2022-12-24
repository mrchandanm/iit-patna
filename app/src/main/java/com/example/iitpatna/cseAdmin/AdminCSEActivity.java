package com.example.iitpatna.cseAdmin;

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

public class AdminCSEActivity extends AppCompatActivity {
    AppCompatButton admincsedropdownbtn;
    Toolbar admincseToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_cseactivity);
        admincsedropdownbtn = findViewById(R.id.admincsedropdownbtn);
        admincseToolbar = findViewById(R.id.admincseToolbar);
        admincseToolbar.setTitle("Computer science");
        admincseToolbar.setSubtitle("CSE");
        admincseToolbar.setTitleTextColor(Color.WHITE);
        admincseToolbar.setSubtitleTextColor(Color.WHITE);
        setSupportActionBar(admincseToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        loadfrag(new cseCSEFragment(), 0);

        admincsedropdownbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu admincsepopup = new PopupMenu(AdminCSEActivity.this, admincsedropdownbtn);
                admincsepopup.getMenuInflater().inflate(R.menu.csemenu, admincsepopup.getMenu());
                admincsepopup.show();
            }
        });
    }
    public void loadfrag(Fragment fragment, int flag){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag==0) {
            ft.add(R.id.admincsecontainer,  fragment);

        }
        else{
            ft.replace(R.id.admincsecontainer, fragment);
        }
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        new MenuInflater(AdminCSEActivity.this).inflate(R.menu.csemenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.CSE){
            loadfrag(new cseCSEFragment(), 1);
            admincsedropdownbtn.setText("CSE");
            Toast.makeText(this, "CSE", Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.CSEBtech2021){
            loadfrag(new CSEBtech2021UGStudentsFragment(), 1);
            admincsedropdownbtn.setText("Btech 2021");
        }
        else if(id==R.id.CSEBtech2020){
            loadfrag(new CSEBtech2020UGStudentsFragment(), 1);
            admincsedropdownbtn.setText("Btech 2020");
        }

        else if(id==android.R.id.home){
            super.onBackPressed();

        }
        return super.onOptionsItemSelected(item);
    }
}