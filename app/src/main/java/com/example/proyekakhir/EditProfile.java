package com.example.proyekakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class EditProfile extends AppCompatActivity {

    private Button simpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        simpan = findViewById(R.id.simpan);
        simpan.setOnClickListener(v -> {
            startActivity(new Intent(EditProfile.this, Profile.class));
        });
    }
}