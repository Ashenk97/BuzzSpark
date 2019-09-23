package com.example.categoryview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileDash extends AppCompatActivity {

    private Button AddDetails, UpdateDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_dash);

        AddDetails = findViewById(R.id.add_profile_details_btn);
        UpdateDetails = findViewById(R.id.profile_details_maintain_btn);

        AddDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileDash.this,AddAccountDetails.class);
                startActivity(intent);
            }
        });

        UpdateDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileDash.this,AccountMaintain.class);
                startActivity(intent);
            }
        });
    }
}
