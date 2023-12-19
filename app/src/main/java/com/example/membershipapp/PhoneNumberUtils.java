package com.example.membershipapp;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PhoneNumberUtils {

    public static String getPhoneNumber(Context context) {
        // Check for the READ_PHONE_STATE permission
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.READ_PHONE_STATE)
                == PackageManager.PERMISSION_GRANTED) {

            // Get the TelephonyManager
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

            // Get the phone number
            String phoneNumber = telephonyManager.getLine1Number();

            return phoneNumber;
        } else {

            // You need to request the permission from the user
            // Handle this according to your app's logic
            // You can use ActivityCompat.requestPermissions() to request the permission
            ActivityCompat.requestPermissions((MainActivity) context, new String[]{"android.permission.READ_PHONE_STATE"}, 010);

            // Note: Don't try to get the phone number here, wait for the user to grant permission
            return null;
        }
    }
}
