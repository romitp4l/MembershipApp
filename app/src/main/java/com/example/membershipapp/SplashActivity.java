package com.example.membershipapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {
    TextView textView;
    Button floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textView = findViewById(R.id.phone_number);

         String phoneNumber = SimInfoHelper.getPhoneNumber(this);
       // String phoneNumber = PhoneNumberUtils.getPhoneNumber(this);

        textView.setText(phoneNumber);
        Toast.makeText(this, "Phone Number: " + phoneNumber, Toast.LENGTH_LONG).show();

        floatingActionButton=findViewById(R.id.flotingButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    };
    }
}
