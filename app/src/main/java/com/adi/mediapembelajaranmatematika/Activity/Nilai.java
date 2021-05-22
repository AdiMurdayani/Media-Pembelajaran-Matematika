package com.adi.mediapembelajaranmatematika.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.adi.mediapembelajaranmatematika.Fragment.FragmentNilaiEssay;
import com.adi.mediapembelajaranmatematika.Fragment.FragmentNilaiPilGan;
import com.adi.mediapembelajaranmatematika.R;

public class Nilai extends AppCompatActivity {

    private ImageView btn_kembali;
    private CardView btn_nilai_pilgan, btn_nilai_essay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilai);
        init();
    }

    private void init() {

        btn_kembali = findViewById(R.id.btn_kembali);
        btn_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nilai.super.onBackPressed();
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_list, new FragmentNilaiPilGan()).commit();

        btn_nilai_pilgan = findViewById(R.id.nilai_kuis2);
        btn_nilai_pilgan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_list, new FragmentNilaiEssay()).commit();

            }
        });

        btn_nilai_essay = findViewById(R.id.nilai_kuis1);
        btn_nilai_essay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_list, new FragmentNilaiPilGan()).commit();

            }
        });
    }
}