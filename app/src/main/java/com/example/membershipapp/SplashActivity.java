package com.example.membershipapp;

import static android.os.Build.VERSION_CODES.R;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textView=findViewById(R.id.phone_number);



       // String phoneNumber = SimInfoHelper.getPhoneNumber(this);

        String phoneNumber = PhoneNumberUtils.getPhoneNumber(this);

        textView.setText(phoneNumber);
        Toast.makeText(this, "Phone Number: " + phoneNumber, Toast.LENGTH_LONG).show();




    }




}