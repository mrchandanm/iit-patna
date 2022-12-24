package com.example.iitpatna;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;


public class HomeFragment extends Fragment {
    SliderView slider;
    int[] images ={R.drawable.one, R.drawable.three, R.drawable.four, R.drawable.five};



    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View View =inflater.inflate(R.layout.fragment_home, container, false);


        slider = View.findViewById(R.id.imageSlider);
        slider.setSliderAdapter(new SliderAdapter(images));

        slider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        slider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        slider.startAutoCycle();
        return View;

    }
}