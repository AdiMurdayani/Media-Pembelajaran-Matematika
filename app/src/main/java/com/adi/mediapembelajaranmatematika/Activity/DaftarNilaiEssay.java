package com.adi.mediapembelajaranmatematika.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.adi.mediapembelajaranmatematika.Adapter.AdapterKuisEssay;
import com.adi.mediapembelajaranmatematika.Adapter.AdapterKuisPilgan;
import com.adi.mediapembelajaranmatematika.Models.DaftarNilaiModels;
import com.adi.mediapembelajaranmatematika.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DaftarNilaiEssay extends AppCompatActivity {

    private ImageView btn_kembali;
    private FirebaseUser firebaseUser;
    private DatabaseReference reference;
    private FirebaseAuth auth;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<DaftarNilaiModels> listnilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_nilai_essay);
        init();
    }

    private void init() {
        btn_kembali = findViewById(R.id.btn_kembali);
        btn_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaftarNilaiEssay.super.onBackPressed();
            }
        });

        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();

        recyclerView = findViewById(R.id.rc_datanilai);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.line));
        recyclerView.addItemDecoration(itemDecoration);

        refreshLayout = findViewById(R.id.sw_layout_essay);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });
    }

    private void getData() {
        refreshLayout.setRefreshing(true);
        reference = FirebaseDatabase.getInstance().getReference();
        reference.child("kuis_essay").child("daftar_nilai")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        listnilai = new ArrayList<>();

                        for (DataSnapshot data : snapshot.getChildren()) {
                            DaftarNilaiModels daftarNilaiModels = data.getValue(DaftarNilaiModels.class);

                            daftarNilaiModels.setKey(data.getKey());
                            listnilai.add(daftarNilaiModels);
                            refreshLayout.setRefreshing(false);
                        }
                        adapter = new AdapterKuisEssay(listnilai, DaftarNilaiEssay.this);
                        recyclerView.setAdapter(adapter);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(DaftarNilaiEssay.this, "Data Gagal Dimuat", Toast.LENGTH_LONG).show();
                        Log.e("DaftarNilaiPilgan", error.getDetails() + " " + error.getMessage());
                        refreshLayout.setRefreshing(false);
                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }
}