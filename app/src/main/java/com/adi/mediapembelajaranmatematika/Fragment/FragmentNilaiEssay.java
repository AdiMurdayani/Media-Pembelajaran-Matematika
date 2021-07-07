package com.adi.mediapembelajaranmatematika.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.adi.mediapembelajaranmatematika.Activity.DaftarNilaiPilGan;
import com.adi.mediapembelajaranmatematika.Adapter.AdapterKuisPilgan;
import com.adi.mediapembelajaranmatematika.Adapter.AdapterNilaiEssay;
import com.adi.mediapembelajaranmatematika.Models.DaftarNilaiModels;
import com.adi.mediapembelajaranmatematika.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FragmentNilaiEssay extends Fragment {
    private View view;
    private DatabaseReference reference;
    private FirebaseAuth auth;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<DaftarNilaiModels> listnilai;

    public FragmentNilaiEssay() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_nilai_essay, container, false);
        init();
        return view;
    }

    private void init() {

        auth = FirebaseAuth.getInstance();

        recyclerView = view.findViewById(R.id.rc_nilai_essay);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.line));
        recyclerView.addItemDecoration(itemDecoration);

        refreshLayout = view.findViewById(R.id.sw_layout_essay);
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

//                            daftarNilaiModels.setKey(data.getKey());
                            listnilai.add(daftarNilaiModels);
                            refreshLayout.setRefreshing(false);
                        }
                        adapter = new AdapterNilaiEssay(listnilai, getContext());
                        recyclerView.setAdapter(adapter);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getContext(), "Data Gagal Dimuat", Toast.LENGTH_LONG).show();
                        Log.e("DaftarNilaiPilgan", error.getDetails() + " " + error.getMessage());
                        refreshLayout.setRefreshing(false);
                    }
                });
    }

    @Override
    public void onResume() {
        super.onResume();
        getData();
    }
}
