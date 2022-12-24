package com.example.iitpatna;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EEUG2021BtechAdapter extends RecyclerView.Adapter<EEUG2021BtechAdapter.ViewHolder> {

    ArrayList<EEBtech2021UGModel> StudentsList;
    Context Context;
    public EEUG2021BtechAdapter(Context Context ,ArrayList<EEBtech2021UGModel> StudentsList) {
        this.StudentsList = StudentsList;
        this.Context = Context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
   View View = LayoutInflater.from(Context).inflate(R.layout.ee_btech_2021_ug_row,parent,false);
        ViewHolder ViewHolder= new ViewHolder(View);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.Name.setText(StudentsList.get(position).Name);
       holder.Topname.setText(StudentsList.get(position).Name);
       holder.Roll.setText(StudentsList.get(position).Roll);
       holder.Email.setText(StudentsList.get(position).Email);
       holder.img.setImageResource(StudentsList.get(position).image);
       holder.TopRoll.setText(StudentsList.get(position).Roll);

       Boolean getExpandable = StudentsList.get(position).isExpandable;
       holder.EEBtechExpandable.setVisibility(getExpandable?View.VISIBLE: View.GONE);
    }

    @Override
    public int getItemCount() {
        return StudentsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Name, Email, Roll, Topname, TopRoll;
        LinearLayout EEBtechUglist;
        LinearLayout EEBtechExpandable;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.EEUG2021StudentName);
            Email = itemView.findViewById(R.id.EEUG2021StudentEmail);
            Roll = itemView.findViewById(R.id.EEUG2021StudentRoll);
            Topname = itemView.findViewById(R.id.TopEEUG2021StudentName);
            TopRoll = itemView.findViewById(R.id.EEUG2021StudentRollTop);
            img = itemView.findViewById(R.id.UGImage);

            EEBtechUglist=itemView.findViewById(R.id.EEBtech2021UGListLayout);
            EEBtechExpandable = itemView.findViewById(R.id.EEUGExpandableList);

            EEBtechUglist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EEBtech2021UGModel Name = StudentsList.get(getAdapterPosition());
                    Name.setExpandable(!Name.getExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
