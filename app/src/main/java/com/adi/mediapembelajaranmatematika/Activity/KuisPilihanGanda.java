package com.adi.mediapembelajaranmatematika.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.adi.mediapembelajaranmatematika.Models.DaftarNilaiModels;
import com.adi.mediapembelajaranmatematika.Models.KuisPilGan;
import com.adi.mediapembelajaranmatematika.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import io.github.kexanie.library.MathView;

public class KuisPilihanGanda extends AppCompatActivity {

    private ImageView btn_kembali;
    private Button btn_pilih;
    private MathView tv_soal;
    private TextView tv_skor, tv_nama, tv_kelamin, tv_tugas, tv_nilai;
    private RadioGroup radioGroup;
    private RadioButton pilihanJawaban1, pilihanJawaban2, pilihanJawaban3, pilihanJawaban4;
    public int skor = 0;
    public int array;
    public int x;
    String jawaban;
    private KuisPilGan soal = new KuisPilGan();
    private DatabaseReference reference;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis1);
        init();
    }

    private void init() {

        auth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();

        btn_kembali = findViewById(R.id.btn_kembali);
        btn_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KuisPilihanGanda.super.onBackPressed();
            }
        });

        tv_nama = findViewById(R.id.tv_nama);
        tv_nama.setText("" + getIntent().getStringExtra("nama"));
        tv_kelamin = findViewById(R.id.tv_jenis_kelamin);
        tv_kelamin.setText("" + getIntent().getStringExtra("jenis_kelamin"));
        tv_tugas = findViewById(R.id.tv_jenis_kuis);
        tv_tugas.setText("" + getIntent().getStringExtra("jenis_kuis"));
        tv_nilai = findViewById(R.id.tv_nilai);
        tv_nilai.setText("" + getIntent().getStringExtra("nilai"));

        tv_skor = findViewById(R.id.tv_skor);
        tv_skor.setText("" + skor);


        btn_pilih = findViewById(R.id.btn_next);
        btn_pilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chekjawaban();
            }
        });
    }

    private void setKontentsoal() {
        radioGroup.clearCheck();
        array = soal.pertanyaan.length;
        if (x >= array) {
            String jumlahSkor = String.valueOf(skor);
            Intent i = new Intent(KuisPilihanGanda.this, Hasil.class);
            i.putExtra("skorAkhir", jumlahSkor);
            i.putExtra("activity", "PilihanGanda");
            i.putExtra("nama", tv_nama.getText().toString());
            i.putExtra("nilai", tv_skor.getText().toString());
            i.putExtra("jenis_kelamin", tv_kelamin.getText().toString());
            i.putExtra("nama_tugas", tv_tugas.getText().toString());
            startActivity(i);
            updateHasil();
            finish();
        } else {
            tv_soal.setText(soal.getSoal(x));
            pilihanJawaban1.setText(soal.getPilihanJawaban1(x));
            pilihanJawaban2.setText(soal.getPilihanJawaban2(x));
            pilihanJawaban3.setText(soal.getPilihanJawaban3(x));
            pilihanJawaban4.setText(soal.getPilihanJawaban4(x));
            jawaban = soal.getJawabanbenar(x);
        }
        x++;
    }

    @Override
    protected void onResume() {
        super.onResume();

        tv_soal = findViewById(R.id.tv_soal);
        radioGroup = findViewById(R.id.radiogrup);
        pilihanJawaban1 = findViewById(R.id.pilihan1);
        pilihanJawaban2 = findViewById(R.id.pilihan2);
        pilihanJawaban3 = findViewById(R.id.pilihan3);
        pilihanJawaban4 = findViewById(R.id.pilihan4);
        setKontentsoal();
    }

    private void updateHasil() {

        String nama_pengguna = tv_nama.getText().toString();
        String jenis_kelamin = tv_kelamin.getText().toString();
        String nilai_hasil = tv_skor.getText().toString();
        String tugas = tv_tugas.getText().toString();

        if (isEmpty(nama_pengguna) || isEmpty(jenis_kelamin) || isEmpty(nilai_hasil) || isEmpty(tugas)) {
            Toast.makeText(this, "Data tidak boleh kosong!", Toast.LENGTH_SHORT).show();
        } else {
            DaftarNilaiModels kuisPilgan = new DaftarNilaiModels();
            kuisPilgan.setNama(tv_nama.getText().toString());
            kuisPilgan.setJenis_kelamin(tv_kelamin.getText().toString());
            kuisPilgan.setNilai(tv_skor.getText().toString());
            kuisPilgan.setJenis_kuis(tv_tugas.getText().toString());
            updateData(kuisPilgan);
        }
    }

    private void updateData(DaftarNilaiModels kuisPilgan) {
        String userID = auth.getUid();
        String getKey = getIntent().getStringExtra("key");

        reference.child("kuis_pilgan")
                .child("daftar_nilai")
                .child(getKey)
                .setValue(kuisPilgan)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        tv_nama.setText("");
                        tv_kelamin.setText("");
                        tv_skor.setText("");
                        tv_tugas.setText("");
                        Toast.makeText(KuisPilihanGanda.this, "Data berhasil", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void chekjawaban() {
        if (pilihanJawaban1.isChecked()) {
            if (pilihanJawaban1.getText().toString().equals(jawaban)) {
                skor = skor + 10;
                tv_skor.setText("" + skor);
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_LONG).show();
                setKontentsoal();
            } else {
                tv_skor.setText("" + skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_LONG).show();
                setKontentsoal();
            }
        } else if (pilihanJawaban2.isChecked()) {
            if (pilihanJawaban2.getText().toString().equals(jawaban)) {
                skor = skor + 10;
                tv_skor.setText("" + skor);
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_LONG).show();
                setKontentsoal();
            } else {
                tv_skor.setText("" + skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_LONG).show();
                setKontentsoal();
            }
        } else if (pilihanJawaban3.isChecked()) {
            if (pilihanJawaban3.getText().toString().equals(jawaban)) {
                skor = skor + 10;
                tv_skor.setText("" + skor);
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_LONG).show();
                setKontentsoal();
            } else {
                tv_skor.setText("" + skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_LONG).show();
                setKontentsoal();
            }

        } else if (pilihanJawaban4.isChecked()) {
            if (pilihanJawaban4.getText().toString().equals(jawaban)) {
                skor = skor + 10;
                tv_skor.setText("" + skor);
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_LONG).show();
                setKontentsoal();
            } else {
                tv_skor.setText("" + skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_LONG).show();
                setKontentsoal();
            }
        }
    }

    private boolean isEmpty(String s) {
        return TextUtils.isEmpty(s);
    }
}