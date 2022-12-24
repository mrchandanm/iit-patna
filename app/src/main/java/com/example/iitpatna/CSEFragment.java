package com.example.iitpatna;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;


public class CSEFragment extends Fragment {



    public CSEFragment() {
        // Required empty public constructor
    }
    AppCompatButton csedropdownbtn;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_c_s_e, container, false);
       csedropdownbtn = view.findViewById(R.id.csedropdownbtn);

      csedropdownbtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              PopupMenu popup = new PopupMenu(getContext(),csedropdownbtn);
              popup.getMenuInflater().inflate(R.menu.csemenu, popup.getMenu());


              popup.show();
          }
      });


        // Inflate the layout for this fragment
        return view;
    }






}