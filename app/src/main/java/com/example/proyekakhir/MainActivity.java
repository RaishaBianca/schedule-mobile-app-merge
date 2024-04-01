package com.example.proyekakhir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<MyItem> itemList;
    private FloatingActionButton mainFloatingButton;
    private LinearLayout additionalButtonsLayout;
    private boolean isAdditionalButtonsVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        additionalButtonsLayout = findViewById(R.id.additionalButtonsLayout);

        mainFloatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleAdditionalButtonsVisibility();
                FormDialogFragment dialog = new FormDialogFragment();
                dialog.show(getSupportFragmentManager(), "FormDialogFragment");
            }
        });

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
