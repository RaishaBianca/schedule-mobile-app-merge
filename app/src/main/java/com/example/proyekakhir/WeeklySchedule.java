package com.example.proyekakhir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WeeklySchedule extends AppCompatActivity {

    private FloatingActionButton mainFloatingButton;
    private FloatingActionButton floatingButton1;
    private FloatingActionButton floatingButton2;
    private LinearLayout additionalButtonsLayout;
    private boolean isAdditionalButtonsVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_schedule);

        mainFloatingButton = findViewById(R.id.floatingActionButton);
        floatingButton1 = findViewById(R.id.floatingButton1);
        floatingButton2 = findViewById(R.id.floatingButton2);
        additionalButtonsLayout = findViewById(R.id.additionalButtonsLayout);

        mainFloatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleAdditionalButtonsVisibility();
            }
        });

        floatingButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FormDialogFragment dialog = FormDialogFragment.newInstance(R.layout.form_layout1);
                dialog.show(getSupportFragmentManager(), "FormDialogFragment");
            }
        });

        floatingButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FormDialogFragment dialog = FormDialogFragment.newInstance(R.layout.form_layout2);
                dialog.show(getSupportFragmentManager(), "FormDialogFragment");
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        BaseActivity.setBottomNavigationView(bottomNavigationView, this);
    }

    private void toggleAdditionalButtonsVisibility() {
        if (isAdditionalButtonsVisible) {
            additionalButtonsLayout.setVisibility(View.GONE);
        } else {
            additionalButtonsLayout.setVisibility(View.VISIBLE);
        }
        isAdditionalButtonsVisible = !isAdditionalButtonsVisible;
    }
}