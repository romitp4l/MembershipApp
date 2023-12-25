package com.example.membershipapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {


    /*

    this is the splash screen of the app .

    */

    TextView textView;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textView = findViewById(R.id.phone_number);

        //String phoneNumber = SimInfoHelper.getPhoneNumber(this);
        // String phoneNumber = PhoneNumberUtils.getPhoneNumber(this);

        // textView.setText(phoneNumber);
        // Toast.makeText(this, "Phone Number: " + phoneNumber, Toast.LENGTH_LONG).show();

        floatingActionButton=findViewById(R.id.flotingButton);
        floatingActionButton.setOnClickListener(this);


    }

    public void onClick(View view) {
        // Handle click events here
        if (view.getId() == R.id.flotingButton) {
            // Code to execute when the FloatingActionButton is clicked

            // Create an Intent to start the SecondActivity
            Intent intent = new Intent(MainActivity.this, ViewMembersActivity.class);

            // Start the SecondActivity
            startActivity(intent);
        }
    }
}
