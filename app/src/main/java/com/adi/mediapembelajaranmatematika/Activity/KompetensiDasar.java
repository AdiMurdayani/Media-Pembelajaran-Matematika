package com.adi.mediapembelajaranmatematika.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.adi.mediapembelajaranmatematika.R;

public class KompetensiDasar extends AppCompatActivity {

    private ImageView btn_kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kompetensi_dasar);
        init();
    }

    private void init() {

        btn_kembali = findViewById(R.id.btn_kembali);
        btn_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KompetensiDasar.super.onBackPressed();
            }
        });
    }
}