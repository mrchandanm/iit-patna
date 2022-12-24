package com.example.iitpatna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class ProfileActivity extends AppCompatActivity {
    EditText edtname;
    EditText edtbranch;
    EditText edtdepartment;
    EditText edtroll;
    EditText edtmail;
    ImageView imgprofile;
    AppCompatButton btnSave;
    FirebaseDatabase database;
    FirebaseAuth auth;
    DatabaseReference myref;
    String uid;
    FirebaseUser user;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        edtname = findViewById(R.id.edtprofilename);
        edtbranch = findViewById(R.id.edtprofilebranch);
        edtdepartment = findViewById(R.id.edtprofiledepartment);
        edtroll = findViewById(R.id.edtprofileroll);
        edtmail = findViewById(R.id.edtprofileiitpemail);
        imgprofile = findViewById(R.id.profilepic);
        btnSave = findViewById(R.id.btnsaveprofile);
        database = FirebaseDatabase.getInstance();
        myref = database.getReference();
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        uid = user.getUid();
        progressDialog = new ProgressDialog(ProfileActivity.this);
        progressDialog.setMessage("profile");
        progressDialog.show();

        myref.child("users").child(uid).child("account details").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               if(snapshot.exists()) {
                   Map profile2 = (Map) snapshot.getValue();
                   edtname.setText(profile2.get("name").toString());
                   edtbranch.setText(profile2.get("branch").toString());
                   edtdepartment.setText(profile2.get("department").toString());
                   edtroll.setText(profile2.get("roll").toString());
                   edtmail.setText(profile2.get("iitpmail").toString());
                   progressDialog.dismiss();
               }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ProfileActivity.this, "error", Toast.LENGTH_SHORT).show();

            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= edtname.getText().toString();
                String branch = edtbranch.getText().toString();
                String department = edtdepartment.getText().toString();
                String roll = edtroll.getText().toString();
                String mail = edtmail.getText().toString();
                Profile profile = new Profile(name, branch,department, roll,mail);
                myref.child("users").child(uid).child("account details").setValue(profile).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ProfileActivity.this, "user profile updated", Toast.LENGTH_SHORT).show();

                    }
                });



            }
        });




    }
}