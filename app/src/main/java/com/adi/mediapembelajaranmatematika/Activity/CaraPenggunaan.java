package com.adi.mediapembelajaranmatematika.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.adi.mediapembelajaranmatematika.Fragment.FragmentCaraPenggunaan1;
import com.adi.mediapembelajaranmatematika.Fragment.FragmentCaraPenggunaan2;
import com.adi.mediapembelajaranmatematika.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

public class CaraPenggunaan extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ImageView btn_kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cara_penggunaan);
        init();
    }

    private void init() {

        btn_kembali = findViewById(R.id.btn_kembali);
        btn_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CaraPenggunaan.super.onBackPressed();
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_penggunaan, new FragmentCaraPenggunaan1()).commit();
        bottomNavigationView = findViewById(R.id.btn_topnavigation);
        BottomNavigationView.OnNavigationItemSelectedListener navigasi = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.btn_back:
                        fragment = new FragmentCaraPenggunaan1();
                        break;
                    case R.id.btn_next:
                        fragment = new FragmentCaraPenggunaan2();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_penggunaan, fragment).commit();
                return true;
            }
        };

        bottomNavigationView.setOnNavigationItemSelectedListener(navigasi);
    }
}