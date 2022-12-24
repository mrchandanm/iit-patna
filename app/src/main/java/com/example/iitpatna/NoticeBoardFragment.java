package com.example.iitpatna;

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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;


public class NoticeBoardFragment extends Fragment {

    RecyclerView noticerecyclerview;
    ArrayList<NoticeModel> noticelist;
    AddNoticeAdapter adapter;
    FirebaseDatabase database;
    FirebaseStorage storage;
    ProgressDialog  pdfornoticelist;


    public NoticeBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View View =inflater.inflate(R.layout.fragment_notice_board, container, false);
        noticerecyclerview = View.findViewById(R.id.noticerecyclerviewformainapp);
        noticerecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();
        pdfornoticelist = new ProgressDialog(getActivity());
        pdfornoticelist.setMessage("Loading...");
        pdfornoticelist.show();
        database.getReference().child("Notice").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                noticelist = new ArrayList<>();
                for (DataSnapshot datasnapshot : snapshot.getChildren()) {
                    NoticeModel data = datasnapshot.getValue(NoticeModel.class);
                    noticelist.add(data);

                }
                adapter = new AddNoticeAdapter(noticelist, getContext());
                noticerecyclerview.setAdapter(adapter);
                pdfornoticelist.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();

            }
        });

        return View;
    }
}