package com.adi.mediapembelajaranmatematika.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.adi.mediapembelajaranmatematika.Activity.KuisEssay;
import com.adi.mediapembelajaranmatematika.Models.DaftarNilaiModels;
import com.adi.mediapembelajaranmatematika.R;

import java.util.ArrayList;

public class AdapterKuisEssay extends RecyclerView.Adapter<AdapterKuisEssay.DataHolder> {

    private ArrayList<DaftarNilaiModels> listdatanilai;
    private Context context;

    public AdapterKuisEssay(ArrayList<DaftarNilaiModels> listdatanilai, Context context) {
        this.listdatanilai = listdatanilai;
        this.context = context;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_nilai, parent, false);
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

        holder.btn_mulai_kuis_pilgan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, KuisEssay.class);
                i.putExtra("nama", listdatanilai.get(position).getNama());
                i.putExtra("jenis_kelamin", listdatanilai.get(position).getJenis_kelamin());
                i.putExtra("nilai", listdatanilai.get(position).getNilai());
                i.putExtra("jenis_kuis", listdatanilai.get(position).getJenis_kuis());
                i.putExtra("key", listdatanilai.get(position).getKey());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdatanilai.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder {

        private TextView nama, jenis_kelamin, nilai, jenis_kuis;
        private CardView btn_mulai_kuis_pilgan;

        public DataHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.tv_nama_lengkap);
            jenis_kelamin = itemView.findViewById(R.id.tv_jenis_kelamin);
            jenis_kuis = itemView.findViewById(R.id.tv_jenis_kuis);
            nilai = itemView.findViewById(R.id.tv_nilai);

            btn_mulai_kuis_pilgan = itemView.findViewById(R.id.btn_mulai_kuis_pilgan);
        }
    }
}
