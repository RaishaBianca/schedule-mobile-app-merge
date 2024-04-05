package com.example.proyekakhir;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.google.android.material.navigation.NavigationBarView;

import android.view.MenuItem;

public class BaseActivity extends AppCompatActivity {
    public static void setBottomNavigationView(BottomNavigationView bottomNavigationView, final AppCompatActivity activity) {
        bottomNavigationView.setLabelVisibilityMode(NavigationBarView.LABEL_VISIBILITY_LABELED);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d("Log","Success3");
                int itemId = item.getItemId();
                if (itemId == R.id.Weekly) {
                    Intent intent = new Intent(activity, WeeklySchedule.class);
                    activity.startActivity(intent);
                    return true;
                } else if (itemId == R.id.Calender) {
                    Intent intent = new Intent(activity, Calender.class);
                    activity.startActivity(intent);
                    return true;
                } else if (itemId == R.id.Tasks) {
                    Intent intent = new Intent(activity, Task.class);
                    activity.startActivity(intent);
                    return true;
                } else if (itemId == R.id.Profile) {
                    Intent intent = new Intent(activity, Profile.class);
                    activity.startActivity(intent);
                    return true;
                } else {
                    return false;
                }
            }
        });
    }
}
