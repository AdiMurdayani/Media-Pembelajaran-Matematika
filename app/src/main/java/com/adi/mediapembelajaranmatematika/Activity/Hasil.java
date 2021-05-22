package com.adi.mediapembelajaranmatematika.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.adi.mediapembelajaranmatematika.R;

public class Hasil extends AppCompatActivity {

    private TextView tv_nama, tv_kelamin, tv_nilai, tv_tugas;
    private ImageView img_kembali;
    private CardView btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        init();
    }

    private void init() {
        img_kembali = findViewById(R.id.btn_kembali);
        img_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hasil.this, Kuis.class));
                finish();
            }
        });

        btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hasil.this, MenuUtama.class));
                finish();
            }
        });

        tv_nama = findViewById(R.id.tv_nama);
        tv_nama.setText("" + getIntent().getStringExtra("nama"));
        tv_kelamin = findViewById(R.id.tv_kelamin);
        tv_kelamin.setText("" + getIntent().getStringExtra("jenis_kelamin"));
        tv_tugas = findViewById(R.id.tv_tugas);
        tv_tugas.setText("" + getIntent().getStringExtra("nama_tugas"));
        tv_nilai = findViewById(R.id.tv_nilai);
        tv_nilai.setText("" + getIntent().getStringExtra("nilai"));
    }
}