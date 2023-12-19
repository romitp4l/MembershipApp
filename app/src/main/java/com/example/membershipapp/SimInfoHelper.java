package com.example.membershipapp;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class SimInfoHelper {

    public static String getPhoneNumber(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        try {
            // Check if the READ_PHONE_STATE permission is granted in your AndroidManifest.xml
            if (telephonyManager != null) {
                String phoneNumber = telephonyManager.getLine1Number();

                if (phoneNumber != null && !phoneNumber.isEmpty()) {
                    // The phone number may not be available on all devices
                    return phoneNumber;
                } else {
                    return "Phone number not available";
                }
            } else {
                return "TelephonyManager is null";
            }
        } catch (SecurityException e) {
            e.printStackTrace();
            return "Permission denied: " + e.getMessage();
        }
    }


}
