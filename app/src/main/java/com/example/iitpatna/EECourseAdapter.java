package com.example.iitpatna;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EECourseAdapter extends RecyclerView.Adapter<EECourseAdapter.ViewHolder> {
    ArrayList<EECourseModel> Course;
    Context Context;
    public EECourseAdapter(Context Context ,ArrayList<EECourseModel> course) {
        this.Course = course;
        this.Context = Context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View View= LayoutInflater.from(Context).inflate(R.layout.ee_course_row,parent,false);
        ViewHolder ViewHolder = new ViewHolder(View);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Semester.setText(Course.get(position).Semester);
        holder.branch.setText(Course.get(position).branch);
        holder.EECourseName1.setText(Course.get(position).EECourseName1);
        holder.EECourse1.setText(Course.get(position).EECourse1);
        holder.Reference1.setText(Course.get(position).Reference1);

        holder.EECourseName2.setText(Course.get(position).EECourseName2);
        holder.EECourse2.setText(Course.get(position).EECourse2);
        holder.Reference2.setText(Course.get(position).Reference2);

        holder.EECourseName3.setText(Course.get(position).EECourseName3);
        holder.EECourse3.setText(Course.get(position).EECourse3);
        holder.Reference3.setText(Course.get(position).Reference3);

        holder.EECourseName4.setText(Course.get(position).EECourseName4);
        holder.EECourse4.setText(Course.get(position).EECourse4);
        holder.Reference4.setText(Course.get(position).Reference4);

        holder.EECourseName5.setText(Course.get(position).EECourseName5);
        holder.EECourse5.setText(Course.get(position).EECourse5);
        holder.Reference5.setText(Course.get(position).Reference5);
        Boolean getExpandable = Course.get(position).Expandable;
        holder.CourseExpandableList.setVisibility(getExpandable? View.VISIBLE :View.GONE);


    }

    @Override
    public int getItemCount() {
        return Course.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Semester,branch, EECourseName1, EECourseName2, EECourseName3,EECourseName4,EECourseName5,
                EECourse1,EECourse2,EECourse3,EECourse4,EECourse5,
                Reference1,Reference2,Reference3,Reference4,Reference5;

        LinearLayout SemesterLayout;
        LinearLayout CourseExpandableList;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Semester= itemView.findViewById(R.id.EESemester);
            branch = itemView.findViewById(R.id.branch);
            EECourseName1= itemView.findViewById(R.id.EECourseName1);
            EECourse1 = itemView.findViewById(R.id.EECourses1);
            Reference1 =itemView.findViewById(R.id.Reference1);

            EECourseName2= itemView.findViewById(R.id.EECourseName2);
            EECourse2 = itemView.findViewById(R.id.EECourses2);
            Reference2 =itemView.findViewById(R.id.Reference2);
            EECourseName3= itemView.findViewById(R.id.EECourseName3);
            EECourse3 = itemView.findViewById(R.id.EECourses3);
            Reference3=itemView.findViewById(R.id.Reference3);
            EECourseName4= itemView.findViewById(R.id.EECourseName4);
            EECourse4 = itemView.findViewById(R.id.EECourses4);
            Reference4=itemView.findViewById(R.id.Reference4);
            EECourseName5= itemView.findViewById(R.id.EECourseName5);
            EECourse5 = itemView.findViewById(R.id.EECourses5);
            Reference5 =itemView.findViewById(R.id.Reference5);
            SemesterLayout=itemView.findViewById(R.id.SemesterLayout);
            CourseExpandableList=itemView.findViewById(R.id.CourseExpandableList);


            SemesterLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   EECourseModel Semester = Course.get(getAdapterPosition());
                   Semester.setExpandable(!Semester.getExpandable());
                   notifyItemChanged(getAdapterPosition());

                }
            });



        }
    }
}
