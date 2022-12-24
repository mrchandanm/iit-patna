package com.example.iitpatna.cseMain;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.iitpatna.R;
import com.example.iitpatna.StudentsAdapterForMainApp;
import com.example.iitpatna.StudentsModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;


public class CSEBtech2020UGStudentsListFragments extends Fragment {
    FirebaseDatabase database;
    FirebaseStorage storage;
    DatabaseReference dbref;
    RecyclerView btech2020RecyclerView;
    ArrayList<StudentsModel> StudentsList;
    StudentsAdapterForMainApp adapter;
    ProgressDialog progressDialog;



    public CSEBtech2020UGStudentsListFragments() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  View =inflater.inflate(R.layout.fragment_c_s_e_btech2020_u_g_students_list_fragments, container, false);
        btech2020RecyclerView = View.findViewById(R.id.btech2020RecyclerView);
        btech2020RecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        database = FirebaseDatabase.getInstance();
        dbref = FirebaseDatabase.getInstance().getReference().child("department").child("engineering and technology").child("computer science").child("people").child("ug student").child("btech 2020");
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        database.getReference().child("department").child("engineering and technology").child("computer science").child("people").child("ug student").child("btech 2020").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                StudentsList = new ArrayList<>();

                for (DataSnapshot datasnapshot : snapshot.getChildren()) {
                    StudentsModel data = datasnapshot.getValue(StudentsModel.class);
                    StudentsList.add(data);

                }
                adapter = new StudentsAdapterForMainApp(StudentsList, getContext());
                btech2020RecyclerView.setAdapter(adapter);
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();

            }
        });

        return View;
    }
}