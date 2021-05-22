package com.adi.mediapembelajaranmatematika.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.adi.mediapembelajaranmatematika.R;

public class MenuUtama extends AppCompatActivity {

    private ImageView btn_logout;
    private CardView btn_kompetensi_dasar, btn_materi, btn_kuis, btn_nilai, btn_penggunaan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);
        init();
    }

    private void init() {


        btn_kompetensi_dasar = findViewById(R.id.btn_kompetensi_dasar);
        btn_kompetensi_dasar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuUtama.this, KompetensiDasar.class));
            }
        });
        btn_materi = findViewById(R.id.btn_materi_matematika);
        btn_materi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuUtama.this, Materi.class));
            }
        });
        btn_kuis = findViewById(R.id.btn_kuis_matematika);
        btn_kuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuUtama.this, Kuis.class));

            }
        });
        btn_nilai = findViewById(R.id.btn_daftar_nilai);
        btn_nilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuUtama.this, Nilai.class));

            }
        });
        btn_penggunaan = findViewById(R.id.btn_petunjuk_penggunaan);
        btn_penggunaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuUtama.this, CaraPenggunaan.class));

            }
        });
    }
}