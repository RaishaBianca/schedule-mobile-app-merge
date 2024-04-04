package com.example.proyekakhir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Calender extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<MyItem> itemList;
    private CalenderAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        recyclerView = findViewById(R.id.recyclerView);
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
    }
}