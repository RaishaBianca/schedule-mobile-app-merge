package com.example.proyekakhir;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Task extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<MyItem> itemList;
    private FloatingActionButton mainFloatingButton;
    private FloatingActionButton floatingButton1;
    private FloatingActionButton floatingButton2;
    private LinearLayout additionalButtonsLayout;
    private boolean isAdditionalButtonsVisible = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();
        itemList.add(new MyItem("UTS", "Senin, 20 Maret 2024 13:00"));
        itemList.add(new MyItem("UAS", "Senin, 20 Maret 2024 13:00"));
        itemList.add(new MyItem("Tubes", "Senin, 20 Maret 2024 13:00"));
        itemList.add(new MyItem("Praktikum", "Senin, 20 Maret 2024 13:00"));
        itemList.add(new MyItem("Kuis", "Senin, 20 Maret 2024 13:00"));
        itemList.add(new MyItem("Tugas", "Senin, 20 Maret 2024 13:00"));
        itemList.add(new MyItem("Ujian", "Senin, 20 Maret 2024 13:00"));
        itemList.add(new MyItem("Kerja Praktek", "Senin, 20 Maret 2024 13:00"));
        itemList.add(new MyItem("Seminar", "Senin, 20 Maret 2024 13:00"));

        adapter = new MyAdapter(itemList, this);
        recyclerView.setAdapter(adapter);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


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
