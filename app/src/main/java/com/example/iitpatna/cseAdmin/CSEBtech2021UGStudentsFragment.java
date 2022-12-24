package com.example.iitpatna.cseAdmin;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iitpatna.AddStudentModel;
import com.example.iitpatna.R;
import com.example.iitpatna.StudentsAdapter;
import com.example.iitpatna.StudentsModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;


public class CSEBtech2021UGStudentsFragment extends Fragment {
    FloatingActionButton addfloatingbtn;
    EditText addname;
    EditText addroll;
    EditText addmail;
    ImageView imageprofile;
    CardView addimage;
    AppCompatButton addupdatebtn;
    FirebaseDatabase database;
    FirebaseStorage storage;
    ProgressDialog progressDialog;
    TextView txtviewupload;
    Uri imageresulturi;
    ActivityResultLauncher<String> launcher;
    RecyclerView btech2021RecyclerView;
    ArrayList<StudentsModel> StudentsList;
    StudentsAdapter adapter;
    ProgressDialog pd;
    DatabaseReference ref;



    public CSEBtech2021UGStudentsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View View =inflater.inflate(R.layout.fragment_c_s_e_btech2021_u_g_students, container, false);
      btech2021RecyclerView = View.findViewById(R.id.btech2021RecyclerView);
      btech2021RecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        addfloatingbtn = View.findViewById(R.id.addfloatingbtn);
        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Adding student");
        ref = database.getReference().child("department").child("engineering and technology").child("computer science").child("people").child("ug student").child("btech 2021");



//*******************************--floating action button--*****************************************
        addfloatingbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(android.view.View view) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.student_add_dialog);
                addupdatebtn = dialog.findViewById(R.id.btnaddupdate);
                addname = dialog.findViewById(R.id.addname);
                addroll = dialog.findViewById(R.id.addroll);
                addmail = dialog.findViewById(R.id.addmail);
                imageprofile = dialog.findViewById(R.id.imageprofile);
                addimage = dialog.findViewById(R.id.addimage);
                txtviewupload = dialog.findViewById(R.id.txtviewupload);
                dialog.show();

                addimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View view) {
                        opengallery();

                    }
                });


                addupdatebtn.setOnClickListener(new View.OnClickListener() {
                    String name= "";
                    String roll="";
                    String mail="";
                    String img = "";


                    @Override
                    public void onClick(android.view.View view) {
                        if (addname.getText().toString().isEmpty()) {
                            addname.setError("Empty");
                            addname.requestFocus();
                        } else if (addroll.getText().toString().isEmpty()) {
                            addroll.setError("Empty");
                            addroll.requestFocus();
                        } else if (addmail.getText().toString().isEmpty()) {
                            addmail.setError("Empty");
                            addmail.requestFocus();
                        } else if (imageresulturi==null) {
                            txtviewupload.requestFocus();
                            txtviewupload.setError("Upload image");
                            Toast.makeText(getContext(), "Add photo", Toast.LENGTH_SHORT).show();
                        } else {

                            name = addname.getText().toString();
                            roll = addroll.getText().toString();
                            mail = addmail.getText().toString();
                            img = imageresulturi.toString();

                            progressDialog.show();
                            StorageReference storageReference = storage.getReference().child("department").child("engineering and technology").child("computer science").child("people").child("ug student").child("btech 2021").child(roll);
                            storageReference.putFile(imageresulturi).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {
                                            AddStudentModel model = new AddStudentModel(name, roll, mail, uri.toString());

                                            database.getReference().child("department").child("engineering and technology").child("computer science").child("people").child("ug student").child("btech 2021").child(roll).setValue(model).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    Toast.makeText(getContext(), "student Added", Toast.LENGTH_SHORT).show();
                                                    progressDialog.dismiss();
                                                    dialog.dismiss();
                                                }
                                            });
                                        }
                                    });
                                }

                            });


                        }
                    }
                });
            }


            private void opengallery() {
                launcher.launch("image/*");

            }

        });
        //****************************--Floating Action Button--**********************************

        launcher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {

                imageprofile.setImageURI(result);
                imageresulturi = result;


            }
        });

        pd = new ProgressDialog(getActivity());
        pd.setMessage("Loading");
        pd.show();


        database.getReference().child("department").child("engineering and technology").child("computer science").child("people").child("ug student").child("btech 2021").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                StudentsList = new ArrayList<>();

                    for (DataSnapshot datasnapshot : snapshot.getChildren()) {
                      StudentsModel data = datasnapshot.getValue(StudentsModel.class);
                      StudentsList.add(data);

                }
                adapter = new StudentsAdapter(StudentsList, getContext(), ref);
                btech2021RecyclerView.setAdapter(adapter);
                pd.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();

            }
        });

        return View;
    }
}