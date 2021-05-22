package com.adi.mediapembelajaranmatematika.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.adi.mediapembelajaranmatematika.Models.DaftarNilaiModels;
import com.adi.mediapembelajaranmatematika.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Kuis extends AppCompatActivity {

    private ImageView btn_kembali;
    private CardView btn_kuis1, btn_kuis2, btn_materi, btn_nilai;

    private TextInputEditText edt_nama, edt_nilai, edt_nama_kuis;
    private Spinner sp_kelamin;
    private AlertDialog.Builder builder;
    private String nilai = "0";
    private String nama_kuis = "Kuis Pilihan Ganda";
    private String nama_kuis1 = "Kuis Essay";
    private TextView txt_kelamin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis);
        init();
    }

    private void init() {

        btn_kembali = findViewById(R.id.btn_kembali);
        btn_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kuis.super.onBackPressed();
            }
        });

        btn_kuis1 = findViewById(R.id.btn_kuis1);
        btn_kuis1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNama1();
            }
        });
        btn_kuis2 = findViewById(R.id.btn_kuis2);
        btn_kuis2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNama2();
            }
        });
        btn_materi = findViewById(R.id.btn_materi);
        btn_materi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Kuis.this, Materi.class));
            }
        });
        btn_nilai = findViewById(R.id.btn_nilai);
        btn_nilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Kuis.this, Nilai.class));
            }
        });
    }

    private void inputNama2() {
        builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_input_nama2, null);
        builder.setView(view);
        builder.setTitle("Input nama anda untuk lanjut ke kuis!");
        builder.setCancelable(true);

        edt_nama = view.findViewById(R.id.edt_nama);

        edt_nilai = view.findViewById(R.id.edt_nilai);
        edt_nilai.setText("" + nilai);
        edt_nama_kuis = view.findViewById(R.id.tugas);
        edt_nama_kuis.setText("" + nama_kuis1);

        txt_kelamin = view.findViewById(R.id.text_kelamin);
        sp_kelamin = view.findViewById(R.id.sp_jenis_kelamin);
        sp_kelamin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txt_kelamin.setText("" + sp_kelamin.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference;

                String nama = edt_nama.getText().toString();
                String kelamin = txt_kelamin.getText().toString();
                String nilai_hasil = edt_nilai.getText().toString();
                String jenis_kuis = edt_nama_kuis.getText().toString();

                reference = database.getReference();

                if (nama.isEmpty()) {
                    edt_nama.requestFocus();
                    edt_nama.setError("Nama tidak boleh kosong!");
                    return;
                }

                reference.child("kuis_essay").child(userID).child("daftar_nilai").push()
                        .setValue(new DaftarNilaiModels(nama, kelamin, nilai_hasil, jenis_kuis))
                        .addOnSuccessListener(Kuis.this, new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        edt_nama.setText("");
                                        edt_nama_kuis.setText("");
                                        edt_nilai.setText("");
                                        txt_kelamin.setText("");
                                        Intent i = new Intent(Kuis.this, DaftarNilaiEssay.class);
                                        startActivity(i);
                                        Toast.makeText(Kuis.this, "Data Tersimpan!", Toast.LENGTH_LONG).show();
                                    }
                                }
                        );
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void inputNama1() {
        builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_input_nama1, null);
        builder.setView(view);
        builder.setTitle("Input nama anda untuk lanjut ke kuis!");
        builder.setCancelable(true);

        edt_nama = view.findViewById(R.id.edt_nama);

        edt_nilai = view.findViewById(R.id.edt_nilai);
        edt_nilai.setText("" + nilai);
        edt_nama_kuis = view.findViewById(R.id.kuis);
        edt_nama_kuis.setText("" + nama_kuis);

        txt_kelamin = view.findViewById(R.id.text_kelamin);
        sp_kelamin = view.findViewById(R.id.sp_jenis_kelamin);
        sp_kelamin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txt_kelamin.setText("" + sp_kelamin.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference;

                String nama = edt_nama.getText().toString();
                String kelamin = txt_kelamin.getText().toString();
                String nilai_hasil = edt_nilai.getText().toString();
                String jenis_kuis = edt_nama_kuis.getText().toString();

                reference = database.getReference();

                if (nama.isEmpty()) {
                    edt_nama.requestFocus();
                    edt_nama.setError("Nama tidak boleh kosong!");
                    return;
                }

                reference.child("kuis_pilgan").child(userID).child("daftar_nilai").push()
                        .setValue(new DaftarNilaiModels(nama, kelamin, nilai_hasil, jenis_kuis))
                        .addOnSuccessListener(Kuis.this, new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        edt_nama.setText("");
                                        edt_nama_kuis.setText("");
                                        edt_nilai.setText("");
                                        txt_kelamin.setText("");
                                        Intent i = new Intent(Kuis.this, DaftarNilaiPilGan.class);
                                        startActivity(i);
                                        Toast.makeText(Kuis.this, "Data Tersimpan!", Toast.LENGTH_LONG).show();
                                    }
                                }
                        );
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}