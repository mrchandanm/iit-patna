package com.example.iitpatna;

import static androidx.activity.result.ActivityResultCallerKt.registerForActivityResult;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.Viewholder> {
    ArrayList<StudentsModel> studentslist ;
    Context context;
//    FirebaseDatabase database;
  DatabaseReference ref;



    public StudentsAdapter(ArrayList<StudentsModel> studentslist, Context context, DatabaseReference ref) {
        this.studentslist = studentslist;
        this.context = context;
        this.ref = ref;

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

        // **********************image dialog*****************************
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
        // **********************image dialog*****************************
        holder.studentsdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.student_add_dialog);
                CardView addimage = dialog.findViewById(R.id.addimage);
                ImageView updateimage = dialog.findViewById(R.id.imageprofile);
                EditText updatename = dialog.findViewById(R.id.addname);
                EditText updateroll = dialog.findViewById(R.id.addroll);
                EditText updatemail = dialog.findViewById(R.id.addmail);
                TextView addupdateview = dialog.findViewById(R.id.addupdateview);
                AppCompatButton addupdatebtn = dialog.findViewById(R.id.btnaddupdate);
                addupdateview.setText("Update details");
                addupdatebtn.setText("Update");
                Picasso.get().load(studentslist.get(holder.getAdapterPosition()).image).into(updateimage);
                updatename.setText(studentslist.get(holder.getAdapterPosition()).name);
                updateroll.setText(studentslist.get(holder.getAdapterPosition()).roll);
                updatemail.setText(studentslist.get(holder.getAdapterPosition()).mail);
                dialog.show();


            }
        });

 holder.studentsdetails.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Delete");
        alert.setMessage("Are you sure");
        alert.setIcon(R.drawable.ic_baseline_delete_24);
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//                DatabaseReference dbref = FirebaseDatabase.getInstance().getReference();
//                dbref.child("department").child("engineering and technology").child("computer science").child("people").child("ug student").child("btech 2021")
              ref.child(studentslist.get(holder.getAdapterPosition()).roll).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "canceled", Toast.LENGTH_SHORT).show();
            }
        });
        alert.show();
        return true;
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
