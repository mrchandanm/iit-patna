package com.example.iitpatna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    EditText SUsername;
    EditText SEmail;
    EditText SPassword;
    AppCompatButton btnSignup;
    TextView Alreadyhaveaccount;
     private FirebaseAuth sauth;
     FirebaseDatabase sdatabase;
    ProgressDialog progressDialog;
    Intent i;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        SUsername = findViewById(R.id.SUsername);
        SEmail = findViewById(R.id.SEmail);
        SPassword = findViewById(R.id.SPassword);
        btnSignup = findViewById(R.id.Signup);
        Alreadyhaveaccount = findViewById(R.id.Alreadyhaveaccount);

        progressDialog = new ProgressDialog(SignupActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We are Creating your Account");


        sauth = FirebaseAuth.getInstance();
        sdatabase = FirebaseDatabase.getInstance();

        Intent iLogin = new Intent(SignupActivity.this, LoginActivity.class);
        Intent iHome = new Intent(SignupActivity.this, HomeActivity.class);



        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                String email = SEmail.getText().toString();
                String password = SPassword.getText().toString();
                String Username = SUsername.getText().toString();

                sauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            startActivity(iHome);
                            Users users = new Users(Username, email, password);
                            String id = task.getResult().getUser().getUid();


                            sdatabase.getReference().child("users").child(id).setValue(users);
                            Toast.makeText(SignupActivity.this, "Succesfully Signup", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(SignupActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });







        Alreadyhaveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iLogin);

            }
        });
    }
}