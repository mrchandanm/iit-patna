package com.example.iitpatna;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FacultyRecyclerViewAdapter extends RecyclerView.Adapter<FacultyRecyclerViewAdapter.ViewHolder> {
    Context Context;
    ArrayList<FacultyDirectoryModel> ArrFaculty;
    FacultyRecyclerViewAdapter(Context Context , ArrayList<FacultyDirectoryModel> ArrFaculty){
        this.Context = Context;
        this.ArrFaculty = ArrFaculty;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(Context).inflate(R.layout.directory_faculty_row, parent,false);
        ViewHolder ViewHolder= new ViewHolder(view);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Facultyname.setText(ArrFaculty.get(position).Name);
        holder.Facultydesignation.setText(ArrFaculty.get(position).Designation);
        holder.Facultyphoneextension.setText(ArrFaculty.get(position).PhoneExtension);
        holder.Facultyemail.setText(ArrFaculty.get(position).EmailId);
        holder.EEpost.setText(ArrFaculty.get(position).Post);

    }

    @Override
    public int getItemCount() {
        return ArrFaculty.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Facultyname, Facultydesignation,Facultyphoneextension,Facultyemail, EEpost;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Facultyname = itemView.findViewById(R.id.Facultyname);
            Facultydesignation = itemView.findViewById(R.id.Facultydesignation);
            Facultyphoneextension = itemView.findViewById(R.id.Facultyphoneextension);
            Facultyemail = itemView.findViewById(R.id.Facultyemail);
            EEpost = itemView.findViewById(R.id.EEpost);
        }
    }
}
