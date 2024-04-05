package com.example.proyekakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {

    private TextView edit_profile;
    private Button keluar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        edit_profile = findViewById(R.id.edit_profile);
        edit_profile.setOnClickListener(v -> {
           startActivity(new Intent(Profile.this, EditProfile.class));
        });
        keluar = findViewById(R.id.keluar);
        keluar.setOnClickListener(v -> {
            startActivity(new Intent(Profile.this, MainActivity.class));
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        BaseActivity.setBottomNavigationView(bottomNavigationView, this);
    }
}