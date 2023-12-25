package com.example.membershipapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DashboardActiviy extends AppCompatActivity {

    TextView showMobileNo;
    TextView showPassword;

    TextView storedMobileNo;
    TextView storedPassword;

    Button button;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_activiy);

        showMobileNo = findViewById(R.id.typedMobileNo);
        showPassword = findViewById(R.id.typedPassword);




        Intent intentForData = getIntent();
        showPassword.setText(intentForData.getStringExtra("password"));
        showMobileNo.setText(intentForData.getStringExtra("mobileNo"));
        String phoneNumber = intentForData.getStringExtra("mobileNo");

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchDataFromServer(phoneNumber);
            }
        });



        storedPassword=findViewById(R.id.fetchedPasswordEditText);
        storedMobileNo=findViewById(R.id.fetchedPhoneEditText);

    }

    private void fetchDataFromServer(String whichNumber) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.29.135/membershipApp/getDetails.php"; // Replace with your actual API endpoint URL





        // Create a StringRequest
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            // Convert the response string to a JSON object
                            JSONObject jsonResponse = new JSONObject(response);

                            // Check the 'status' key in the JSON response
                            String serverPassword = jsonResponse.getString("password");
                            String  serverMobileNo= jsonResponse.getString("mobileNo");

                            if (serverPassword.length() > 0) {
                                // Handle the response from the server
                                Toast.makeText(getApplicationContext(), "data fetching successful ", Toast.LENGTH_SHORT).show();
                                storedPassword.setText(serverPassword);
                                storedMobileNo.setText(serverMobileNo);

                            } else {
                                Toast.makeText(getApplicationContext(), "Response: Data not inserted in the database.", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Error parsing JSON response.", Toast.LENGTH_SHORT).show();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        // Handle errors
                        Toast.makeText(getApplicationContext(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }) {
            @Override
            protected Map<String, String> getParams() {



                // Set the parameters to be sent to the server
                Map<String, String> params = new HashMap<>();
                params.put("mobileNo", whichNumber);


                return params;
            }
        };




        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }


}