package com.adi.mediapembelajaranmatematika.Models;

public class DaftarNilaiModels {

    private String nama, jenis_kelamin, nilai, jenis_kuis, key;

    public DaftarNilaiModels() {

    }

    public DaftarNilaiModels(String nama, String jenis_kelamin, String nilai, String jenis_kuis) {
        this.nama = nama;
        this.jenis_kelamin = jenis_kelamin;
        this.nilai = nilai;
        this.jenis_kuis = jenis_kuis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getJenis_kuis() {
        return jenis_kuis;
    }

    public void setJenis_kuis(String jenis_kuis) {
        this.jenis_kuis = jenis_kuis;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
