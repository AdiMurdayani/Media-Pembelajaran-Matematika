package com.adi.mediapembelajaranmatematika.Models;

public class KuisEssayModels {
    public KuisEssayModels() {

    }

    public String pertanyaan[] = {
            "1.\tTentukan nilai a, b, c, dan d dalam matriks " +
                    "$$\nA =" +
                    "    \\begin{pmatrix}\n" +
                    "    2 & a & 4 \\\\\n" +
                    "    -1 & 8 & c \\" +
                    "    \\end{pmatrix}" +
                    "$$" +
                    "$$B = " +
                    "    \\begin{pmatrix}\n" +
                    "    d-1 & 2 & 4 \\\\\n" +
                    "    -1 & b+1 & 6 \\" +
                    "    \\end{pmatrix}" +
                    "$$",
            "2.\tTentukan penjumlahan dari matriks" +
                    "$$\nA= " +
                    "    \\begin{pmatrix}\n" +
                    "    3 & 1 \\\\\n" +
                    "    4 & 2 \\" +
                    "    \\end{pmatrix}" +
                    "$$" +
                    "$$B = " +
                    "    \\begin{pmatrix}\n" +
                    "    0 & 2 \\\\\n" +
                    "    1 & 3 \\" +
                    "    \\end{pmatrix}\n" +
                    "$$",
            "3.\tDiketahui  matriks A = [4   3   13] dan B = [2  13   8]. Tentukan pengurangan  matriks A-B!",
            "4.\tDiketahui matriks:" +
                    "$$\nA = " +
                    "    \\begin{pmatrix}\n" +
                    "    1 & 2 & 3 \\\\\n" +
                    "    4 & 5 & 6 \\" +
                    "    \\end{pmatrix}" +
                    "$$" +
                    "dan $$\nB = " +
                    "    \\begin{pmatrix}\n" +
                    "    7 & 10 \\\\\n" +
                    "    8 & 20 \\" +
                    "    \\end{pmatrix}" +
                    "$$" +
                    ". Tentukan hasil perkalian matriks A dan matriks B!",
            "5.\tTentukan hasil perkalian skalar pada matriks berikut ini!\n" +
                    "\nJika H = Misalkan" +
                    "$$A=" +
                    "    \\begin{pmatrix}\n" +
                    "    2 & 3 \\\\\n" +
                    "    4 & 5 \\\\\n" +
                    "    1 & 2 \\" +
                    "    \\end{pmatrix}" +
                    "$$" +
                    "\nadalah matriks diagonal. Nilai a,b dan c berturut turut adalah…."

    };

    public String jawabanbenar[] = {
            "Jadi nilai a = 2, b = 7, c = 6 dan d = 3",
            "3 3" +
                    "\n5 5",
            "[2 -10 5]",
            "23 50" +
                    "\n53 110" +
                    "\n83 170",
            "4 6" +
                    "\n8 10" +
                    "\n2 4",
    };

    public String getSoal(int x) {
        String soal = pertanyaan[x];
        return soal;
    }

    public String getJawabanbenar(int x) {
        String jawaban = jawabanbenar[x];
        return jawaban;
    }
}
