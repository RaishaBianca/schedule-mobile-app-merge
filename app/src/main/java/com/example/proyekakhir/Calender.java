package com.example.proyekakhir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Calender extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<MyItem> itemList;
    private CalenderAdapter adapter;
    private FloatingActionButton mainFloatingButton;
    private FloatingActionButton floatingButton1;
    private FloatingActionButton floatingButton2;
    private LinearLayout additionalButtonsLayout;
    private boolean isAdditionalButtonsVisible = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemList = new ArrayList<>();

        itemList.add(new MyItem("Tadarus", "15 Maret 2024 05:00"));
        itemList.add(new MyItem("Libur", "15 Maret 2024 08:00"));
        itemList.add(new MyItem("Pertemuan", "15 Maret 2024 09:00"));
        itemList.add(new MyItem("Kuliah", "15 Maret 2024 10:00"));
        itemList.add(new MyItem("Bukber", "15 Maret 2024 11:00"));
        itemList.add(new MyItem("Hang Out", "15 Maret 2024 12:00"));
        itemList.add(new MyItem("Acara1", "15 Maret 2024 13:00"));
        itemList.add(new MyItem("Acara2", "15 Maret 2024 14:00"));
        itemList.add(new MyItem("Acara3", "15 Maret 2024 15:00"));
        itemList.add(new MyItem("Acara4", "15 Maret 2024 16:00"));
        itemList.add(new MyItem("Acara5", "15 Maret 2024 17:00"));

        adapter = new CalenderAdapter(itemList, this);
        recyclerView.setAdapter(adapter);


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