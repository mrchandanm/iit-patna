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
import com.google.firebase.database.DatabaseReference;

public class LoginActivity extends AppCompatActivity {
    EditText LEmail;
    EditText LPassword;
    AppCompatButton btnLogin;
    TextView Register;
    ProgressDialog progressDialog;
    private FirebaseAuth auth;
    DatabaseReference myRef;
    Intent iHome;
    Intent ihome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LEmail = findViewById(R.id.LEmail);
        LPassword = findViewById(R.id.LPassword);
        btnLogin = findViewById(R.id.Login);
        Register = findViewById(R.id.Register);

        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("Login your Account");
        auth = FirebaseAuth.getInstance();

        Intent iSignup = new Intent(LoginActivity.this, SignupActivity.class);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                String pemail = LEmail.getText().toString();
                String ppassword = LPassword.getText().toString();
                auth.signInWithEmailAndPassword(pemail,ppassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Succesfully Login", Toast.LENGTH_SHORT).show();
                             iHome = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(iHome);
                            finish();

                        }
                        else{
                            Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });
        if(auth.getCurrentUser()!= null){
            ihome = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(ihome);
            finish();

        }




        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iSignup);
            }
        });
    }
}