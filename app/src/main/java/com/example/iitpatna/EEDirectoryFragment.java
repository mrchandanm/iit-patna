package com.example.iitpatna;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class EEDirectoryFragment extends Fragment {
    ArrayList<FacultyDirectoryModel> ArrFaculty;

    RecyclerView EEfacultyrecyclerview ;






    public EEDirectoryFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View View =inflater.inflate(R.layout.fragment_e_e_directory, container, false);
        EEfacultyrecyclerview = View.findViewById(R.id.EEfacultyrecyclerview);

        EEfacultyrecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));



        ArrFaculty = new ArrayList<>();
        ArrFaculty.add(new FacultyDirectoryModel("Ahmad Ali", "Associate Professor","8044", "ali", "Faculty"));
        ArrFaculty.add(new FacultyDirectoryModel("Kailash Chandara Ray", "Associate Professor","8106", "kcr","Faculty"));
        ArrFaculty.add(new FacultyDirectoryModel("Maheshkumar H. Kolekar", "Associate Professor","8043", "mahesh", "Faculty"));
        ArrFaculty.add(new FacultyDirectoryModel("Preetam Kumar", "Professor","8043", "mahesh","Faculty"));
        ArrFaculty.add(new FacultyDirectoryModel("Ranjan Kumar Behera", "Associate Professor","8050", "rkb", "Faculty"));
        ArrFaculty.add(new FacultyDirectoryModel("Rajib Kumar Jha", "Associate Professor","8010", "jharajib","Faculty"));
        ArrFaculty.add(new FacultyDirectoryModel("Sanjoy Kumar Parida", "Associate Professor","8040", "skparida","Faculty"));
        ArrFaculty.add(new FacultyDirectoryModel("Shovan Bhaumik", "Associate Professor","8049", "shovan.bhaumik","Faculty"));
        ArrFaculty.add(new FacultyDirectoryModel("Sumanta Gupta", "Associate Professor","8096", "sumanta","Faculty"));
        ArrFaculty.add(new FacultyDirectoryModel("S. Sivasubramani", "Associate Professor","8137", "siva"));
        ArrFaculty.add(new FacultyDirectoryModel("Sudhan Majhi", "Associate Professor(joint Faculty Maths and EE","8045", "smajhi","Faculty"));
        ArrFaculty.add(new FacultyDirectoryModel("Yatendra Kumar Singh", "Associate Professor","8092", "yatendra","Faculty"));
        ArrFaculty.add(new FacultyDirectoryModel("Saurabh Kumar Pandey", "Associate Professor","8246", "saurabh","Faculty"));
        ArrFaculty.add(new FacultyDirectoryModel("Pramod Kumar Tiwari", "Associate Professor","8351", "pktiwari","Faculty"));
        ArrFaculty.add(new FacultyDirectoryModel("Sudhir Kumar", "Associate Professor","8025", "sudhir","Faculty"));


        ArrFaculty.add(new FacultyDirectoryModel("A.P Anand","Junior Technical Superintendent","8080","ambika","Staff"));
        ArrFaculty.add(new FacultyDirectoryModel("Iftekhar Ahmad","Junior Technical Superintendent","8786","ahmad","Staff"));
        ArrFaculty.add(new FacultyDirectoryModel("Lucky Kumar","Junior Technical Superintendent","8085","lkumar","Staff"));
        ArrFaculty.add(new FacultyDirectoryModel("Dhiren Kumar Nayak","Junior Technical Superintendent","8150","nayak","Staff"));
        ArrFaculty.add(new FacultyDirectoryModel("Kumar Swapnil","Junior Technical Superintendent","8079","swapnil1710","Staff"));
        ArrFaculty.add(new FacultyDirectoryModel("Varun Kumar","Junior Technical Superintendent","8051","varun_kr","Staff"));
        ArrFaculty.add(new FacultyDirectoryModel("Nawab Ghosh","Junior Technical Superintendent","8151","nawabghosh","Staff"));
        ArrFaculty.add(new FacultyDirectoryModel("Shashi Kant Kumar","Junior Technical Superintendent","8085","shashi","Staff"));




        FacultyRecyclerViewAdapter adapter = new FacultyRecyclerViewAdapter(getContext(),ArrFaculty);

        EEfacultyrecyclerview.setAdapter(adapter);

        return View;
    }
}