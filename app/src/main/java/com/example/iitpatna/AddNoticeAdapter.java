package com.example.iitpatna;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AddNoticeAdapter extends RecyclerView.Adapter<AddNoticeAdapter.Viewholder> {
    ArrayList<NoticeModel> noticelist ;
    Context context;

    public AddNoticeAdapter(ArrayList<NoticeModel> noticelist, Context context) {
        this.noticelist = noticelist;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View View = LayoutInflater.from(context).inflate(R.layout.notice_layout,parent,false);
       Viewholder viewholder =new Viewholder(View);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.title.setText(noticelist.get(position).title);
        holder.noticetime.setText(noticelist.get(position).time);
        holder.noticedate.setText(noticelist.get(position).date);
        holder.description.setText(noticelist.get(position).description);
        holder.pdfname.setText(noticelist.get(position).pdf);
        Picasso.get().load(noticelist.get(position).image).into(holder.noticeimage);

    }

    @Override
    public int getItemCount() {
        return noticelist.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView title, description, noticetime, noticedate, pdfname;
        ImageView noticeimage, pdfdownload;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.noticetitle);
            description = itemView.findViewById(R.id.noticedescription);
            noticetime = itemView.findViewById(R.id.noticetime);
            noticedate = itemView.findViewById(R.id.noticedate);
            pdfname = itemView.findViewById(R.id.pdfname);
            noticeimage = itemView.findViewById(R.id.noticeimage);
            pdfdownload = itemView.findViewById(R.id.pdfdownload);
        }
    }
}
