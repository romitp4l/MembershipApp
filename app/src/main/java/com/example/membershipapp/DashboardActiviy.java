package com.example.membershipapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DashboardActiviy extends AppCompatActivity {

    TextView showMobileNo;
    TextView showPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_activiy);

        showMobileNo = findViewById(R.id.typedMobileNo);
        showPassword = findViewById(R.id.typedPassword);

        Intent intentForData = getIntent();
        showPassword.setText(intentForData.getStringExtra("password"));
        showMobileNo.setText(intentForData.getStringExtra("mobileNo"));






    }
}