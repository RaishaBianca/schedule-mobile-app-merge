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

        itemList.add(new MyItem("Tadarus", "05:00"));
        itemList.add(new MyItem("Pertemuan", "05:30"));
        itemList.add(new MyItem("Kerkom", "06:00"));
        itemList.add(new MyItem("Libur Natal", "07:00"));
        itemList.add(new MyItem("Libur Tahun Baru", "08:00"));
        itemList.add(new MyItem("Libur Imlek", "09:00"));
        itemList.add(new MyItem("Libur Paskah", "10:00"));
        itemList.add(new MyItem("Libur Idul Fitri", "11:00"));
        itemList.add(new MyItem("Libur Idul Adha", "12:00"));
        itemList.add(new MyItem("Libur Maulid Nabi", "13:00"));
        itemList.add(new MyItem("Libur Waisak", "14:00"));

        adapter = new CalenderAdapter(itemList, this);
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