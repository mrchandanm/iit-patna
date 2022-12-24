package com.example.iitpatna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLoginActivity extends AppCompatActivity {
    EditText alpassword;
    AppCompatButton btnenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        alpassword = findViewById(R.id.ALPassword);

        btnenter = findViewById(R.id.BtnAdmin);
        btnenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = alpassword.getText().toString();
                if(pass.equals("12345678")){
                    Intent iAdminHome = new Intent(AdminLoginActivity.this, AdminHomeActivity.class);
                    startActivity(iAdminHome);
                    finish();
                }
                else{
                    Toast.makeText(AdminLoginActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}