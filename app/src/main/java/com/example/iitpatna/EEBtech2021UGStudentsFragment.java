package com.example.iitpatna;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class EEBtech2021UGStudentsFragment extends Fragment {
RecyclerView EEBtech2021RecyclerView;
ArrayList<EEBtech2021UGModel> StudentsList;



    public EEBtech2021UGStudentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View View=inflater.inflate(R.layout.fragment_e_e_btech2021_u_g_students, container, false);
        EEBtech2021RecyclerView = View.findViewById(R.id.EEBtech2021RecyclerView);
        EEBtech2021RecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        StudentsList = new ArrayList<>();
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee01,"Aakash Sharma","2101EE01","aakash_2101ee01@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee02,"Aastik Kumar Verma","2101EE02","aastik_2101ee02@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee03,"Agniprovo Mandal","2101EE03","agniprovo_2101ee03@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee04,"Ajeetesh Awadh","2101EE04","ajeetesh_2101ee04@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee05,"Ajmeera Jagadishwar","2101EE05","ajmeera_2101ee05@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee06,"Akash Kumar","2101EE06","akash_2101ee06@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee07,"Amisha Kumari","2101EE07","amisha_2101ee07@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee09,"Anjali Kumari","2101EE09","anjali_2101ee09@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee10,"Ankur Kumar","2101EE10","ankur_2101ee10@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee11,"Anushka Prakash","2101EE11","anushka_2101ee11@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee12,"Archita","2101EE12","archita_2101ee12@iitp.ac.in"));

        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee13,"Aritra Bhaduri","2101EE13","aritra_2101ee13_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee14,"Arjun Singh","2101EE14","arjun_2101ee14@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee15,"Aruj Gautam","2101EE15","aruj_2101ee15@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee16,"Arvind Meena","2101EE16","arvind_2101ee16@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee17,"Aryan Chugh","2101EE17","aryan_2101ee17@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee18,"Aryan Kumar","2101EE18","aryan_2101ee18@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee19,"Bata Sai Pavan","2101EE19","pavan_2101ee19@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee20,"Bollikonda Pranay","2101EE20","bollikonda_2101ee20@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee21,"Burri Sai Prathap Reddy","2101EE21","burri_2101ee21@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Chandan Kumar Mahato","2101EE22","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee23,"Chandana Deepak Sai","2101EE23","chandana_2101ee23@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee24,"Chilari Shiva Charan","2101EE24","shiva_2101ee24@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee25,"Chitraksh Dhingra","2101EE25","chitraksh_2101ee25@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee26,"Dhrutisundar Sahoo","2101EE26","dhrutisundar_2101ee26@iitp.ac.in"));

        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee27,"Dowleswarapu Sri Sai Srujan Kamal Veer","2101EE27","dowleswarapu_2101ee27@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee28,"Gadde Jeevan Kumar","2101EE28","jeevan_2101ee28@iitp.ac.in"));
        /*StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE29","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE30","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE31","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE32","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE33","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE34","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE35","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE36","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE37","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE38","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE39","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE40","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE41","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE42","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE43","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE44","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE45","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE46","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE47","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE48","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE49","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE50","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE51","chandan_2101ee22@iitp.ac.in"));
        StudentsList.add(new EEBtech2021UGModel(R.drawable.ee22,"Mohit Chintu","2101EE52","chandan_2101ee22@iitp.ac.in"));

        */




        EEUG2021BtechAdapter adapter = new EEUG2021BtechAdapter(getContext(),StudentsList);
        EEBtech2021RecyclerView.setAdapter(adapter);




        // Inflate the layout for this fragment
        return View;
    }
}