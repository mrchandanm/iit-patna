package com.example.iitpatna;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.ViewHolder> {

    int[] images;

    public SliderAdapter(int[] images) {
        this.images = images;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item_layout, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.imgview.setImageResource(images[position]);

    }

    @Override
    public int getCount() {
        return images.length;
    }
    public class ViewHolder extends SliderViewAdapter.ViewHolder{
        ImageView imgview;


        public ViewHolder(View itemView) {
            super(itemView);
            imgview = itemView.findViewById(R.id.imageview);

        }
    }
}
