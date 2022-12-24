package com.example.iitpatna;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StudentsAdapterForMainApp extends RecyclerView.Adapter<StudentsAdapterForMainApp.Viewholder> {
    ArrayList<StudentsModel> studentslist ;
    Context context;
    public StudentsAdapterForMainApp(ArrayList<StudentsModel> studentslist, Context context) {
        this.studentslist = studentslist;
        this.context = context;
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View View = LayoutInflater.from(context).inflate(R.layout.student_row_list,parent,false);
        Viewholder viewholder = new Viewholder(View);
        return viewholder;

    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.Name.setText(studentslist.get(position).name);

        holder.Roll.setText(studentslist.get(position).roll);
        holder.Email.setText(studentslist.get(position).mail);
        Picasso.get().load(studentslist.get(position).image).into(holder.img);

        holder.img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.image_dialog_show);
                ImageView dialogimage = dialog.findViewById(R.id.imagedialog);
                TextView dialogname = dialog.findViewById(R.id.dialogname);
                dialogname.setText(studentslist.get(holder.getAdapterPosition()).name);
                Picasso.get().load(studentslist.get(holder.getAdapterPosition()).image).into(dialogimage);
                dialog.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return studentslist.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView Name, Email, Roll;
        ImageView img;
        LinearLayout studentsdetails;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.studentsname);
            Email = itemView.findViewById(R.id.studentsmail);
            Roll = itemView.findViewById(R.id.studentsroll);
            img = itemView.findViewById(R.id.studentsprofileimage);
            studentsdetails = itemView.findViewById(R.id.studentsdetails);
        }
    }
}
