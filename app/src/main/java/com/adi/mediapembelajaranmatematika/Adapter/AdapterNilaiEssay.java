package com.adi.mediapembelajaranmatematika.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adi.mediapembelajaranmatematika.Models.DaftarNilaiModels;
import com.adi.mediapembelajaranmatematika.R;

import java.util.ArrayList;

public class AdapterNilaiEssay extends RecyclerView.Adapter<AdapterNilaiEssay.DataHolder> {

    private ArrayList<DaftarNilaiModels> listdatanilai;
    private Context context;

    public AdapterNilaiEssay(ArrayList<DaftarNilaiModels> listdatanilai, Context context) {
        this.listdatanilai = listdatanilai;
        this.context = context;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_nilai_kuis, parent, false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {
        final String nama_lengkap = listdatanilai.get(position).getNama();
        final String jenis_kelamin = listdatanilai.get(position).getJenis_kelamin();
        final String jenis_kuis = listdatanilai.get(position).getJenis_kuis();
        final String hasil_nilai = listdatanilai.get(position).getNilai();

        holder.nama.setText(nama_lengkap);
        holder.nilai.setText(hasil_nilai);
        holder.jenis_kuis.setText(jenis_kuis);
        holder.jenis_kelamin.setText(jenis_kelamin);
    }

    @Override
    public int getItemCount() {
        return listdatanilai.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder {

        private TextView nama, jenis_kelamin, nilai, jenis_kuis;

        public DataHolder(@NonNull View itemView) {
            super(itemView);

            nama = itemView.findViewById(R.id.tv_nama_lengkap);
            jenis_kelamin = itemView.findViewById(R.id.tv_jenis_kelamin);
            jenis_kuis = itemView.findViewById(R.id.tv_jenis_kuis);
            nilai = itemView.findViewById(R.id.tv_nilai);

        }
    }
}
