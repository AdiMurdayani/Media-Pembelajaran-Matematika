package com.adi.mediapembelajaranmatematika.Models;

import android.widget.ImageView;

public class KuisPilGan {

    public KuisPilGan() {
    }

    public String pertanyaan[] = {
            "1.\tDiketahui matriks" +
                    "$$K = " +
                    "    \\begin{bmatrix}\n" +
                    "    4 & 3 \\\\\n" +
                    "    2 & 2 \\\\\n" +
                    "    1 & 9 \\" +
                    "    \\end{bmatrix}\n" +
                    "$$ " +
                    "maka matriks K disebut….",
            "2.\tMatriks A = [22 19 14 12] disebut matriks….",
            "3.\tMatriks berikut yang merupakan matriks identitas adalah….",
            "4.\tJumlah elemen-elemen diagonal utama matriks" +
                    "$$P =" +
                    "    \\begin{pmatrix}\n" +
                    "    5 & 1 & 0 \\\\\n" +
                    "    4 & -10 & 3 \\\\\n" +
                    "    3 & -2 & 1 \\" +
                    "    \\end{pmatrix}\n" +
                    "$$ " +
                    "adalah….",
            "5.\tDiketahui matriks " +
                    "$$" +
                    "    \\begin{pmatrix}\n" +
                    "    2 & b-1 & 0 \\\\\n" +
                    "    0 & 1 & 0 \\\\\n" +
                    "    a+b & 2a+b & 3 \\" +
                    "    \\end{pmatrix}\n" +
                    "$$ " +
                    "adalah matriks diagonal. Nilai a,b,dan c berturut turut adalah….",
            "6.\tDiketahui matriks" +
                    "$$A = " +
                    "    \\begin{pmatrix}\n" +
                    "    -1 & 0 \\\\\n" +
                    "    3 & 8 \\" +
                    "    \\end{pmatrix}\n" +
                    "$$" +
                    "\ndan" +
                    "$$B = " +
                    "    \\begin{pmatrix}\n" +
                    "    0 & 9 \\\\\n" +
                    "    6 & -7 \\" +
                    "    \\end{pmatrix}\n" +
                    "$$ " +
                    "Jika  A-B = C, maka matriks $$C^{t}$$….",
            "7.\tDiketahui matriks segitiga atas " +
                    "$$C = " +
                    "    \\begin{pmatrix}\n" +
                    "    1 & 2 & 3 \\\\\n" +
                    "    y-1 & 5 & 7 \\\\\n" +
                    "    0 & x-4y & 6 \\" +
                    "    \\end{pmatrix}\n" +
                    "$$ " +
                    "Nilai x yang memenuhi adalah….",
            "8.\tDiketahui persamaan matriks" +
                    "$$" +
                    "    \\begin{pmatrix}\n" +
                    "    a & 4 \\\\\n" +
                    "    -1 & c \\" +
                    "    \\end{pmatrix}\n" +
                    "$$" +
                    " + " +
                    "$$" +
                    "    \\begin{pmatrix}\n" +
                    "    c & b \\\\\n" +
                    "    d & -3 \\" +
                    "    \\end{pmatrix}\n" +
                    "$$ = " +
                    "$$" +
                    "    \\begin{pmatrix}\n" +
                    "    1 & -3 \\\\\n" +
                    "    3 & 4 \\" +
                    "    \\end{pmatrix}\n" +
                    "$$ " +
                    "$$" +
                    "    \\begin{pmatrix}\n" +
                    "    0 & 1 \\\\\n" +
                    "    1 & 0 \\" +
                    "    \\end{pmatrix}\n" +
                    "$$ " +
                    "Nilai a + b + c + d =....",
            "9.\tTentukan matriks " +
                    "$$A =" +
                    "    \\begin{pmatrix}\n" +
                    "    3 & -1 & 2 \\\\\n" +
                    "    0 & 6 & 4 \\\\\n" +
                    "    1 & 5 & 1 \\" +
                    "    \\end{pmatrix}\n" +
                    "$$ dan Matriks " +
                    "$$B= " +
                    "    \\begin{pmatrix}\n" +
                    "    -3 & -1 & 2 \\\\\n" +
                    "    0 & 6 & 4 \\\\\n" +
                    "    1 & -5 & -1 \\" +
                    "    \\end{pmatrix}\n" +
                    "$$" +
                    " Tentukanlah A + B dari soal tersebut!",
            "10.\tTentukan matriks P = (10 7 3) dan matriks Q = (5 4 1) Tentkanlah hasil dari P-Q!"

    };
    public String pilihanjawaban[][] = {
            {
                    "A.\tDiagonal",
                    "B.\tNol",
                    "C.\tKolom",
                    "D.\tSegitiga"
            },
            {
                    "A.\tDiagonal",
                    "B.\tNol",
                    "C.\tKolom",
                    "D.\tBaris"
            },
            {
                    "[1\t\t\t1]" +
                            "\n[0\t\t\t0]",
                    "[1\t\t\t0]" +
                            "\n[1\t\t\t0]",
                    "[0\t\t\t1]" +
                            "\n[1\t\t\t0]",
                    "[1\t\t\t0]" +
                            "\n[0\t\t\t1]"
            },
            {
                    "A.\t18",
                    "B.\t15",
                    "C.\t4",
                    "D.\t-4"
            },
            {
                    "A.\t2, 1 dan -2",
                    "B.\t-1, 1 dan 2",
                    "C.\t-1, 1 dan 2",
                    "D.\t-2, 1 dan 2"
            },
            {
                    "[1\t\t\t\t3]" +
                            "\n[9\t\t\t15]",
                    "[-1\t\t\t-3]" +
                            "\n[-9\t\t\t\t1]",
                    "[-1\t\t\t-3]" +
                            "\n[\t9\t\t\t\t-1]",
                    "[-1\t\t\t.3]" +
                            "\n[-9\t\t-15]"
            },
            {
                    "A.\t4",
                    "B.\t2",
                    "C.\t1",
                    "D.\t0"
            },
            {
                    "A.\t-7",
                    "B.\t-5",
                    "C.\t1",
                    "D.\t3"
            },
            {
                    "[3\t\t-1\t\t\t2]" +
                            "\n[0\t\t\t6\t\t\t4]" +
                            "\n[1\t\t\t5\t\t\t1]",
                    "[-3\t\t-1\t\t\t\t2]" +
                            "\n[\t0\t\t\t.6\t\t\t\t4]" +
                            "\n[\t1\t\t\t-5\t\t\t-1]",
                    "[0\t\t\t-2\t\t\t4]" +
                            "\n[0\t\t\t12\t\t\t8]" +
                            "\n[2\t\t\t.0\t\t\t0]",
                    "[\t0\t\t\t\t4\t\t\t-2]" +
                            "\n[12\t\t\t8\t\t\t\t0]" +
                            "\n[\t0\t\t\t\t2\t\t\t\t0]"
            },
            {
                    "A.\t(5 3 1)",
                    "B.\t(-5 3 2)",
                    "C.\t(2 1 1)",
                    "D.\t(6 3 9)"
            }

    };

    public String jawabanbenar[] = {
            "C.\tKolom",
            "D.\tBaris",
            "[1\t\t\t0]" +
                    "\n[0\t\t\t1]",
            "D.\t-4",
            "C.\t-1, 1 dan 2",
            "[-1\t\t\t\t3]" +
                    "\n[-9\t\t\t-15]",
            "A.\t4",
            "D.\t3",
            "[0\t\t\t-2\t\t\t\t4]" +
                    "\n[0\t\t\t12\t\t\t8]" +
                    "\n[2\t\t\t\t0\t\t\t0]",
            "A.\t(5 3 1)"
    };

    public String getSoal(int x) {
        String soal = pertanyaan[x];
        return soal;
    }

    public String getPilihanJawaban1(int x) {
        String jawaban1 = pilihanjawaban[x][0];
        return jawaban1;
    }

    public String getPilihanJawaban2(int x) {
        String jawaban2 = pilihanjawaban[x][1];
        return jawaban2;
    }

    public String getPilihanJawaban3(int x) {
        String jawaban3 = pilihanjawaban[x][2];
        return jawaban3;
    }

    public String getPilihanJawaban4(int x) {
        String jawaban4 = pilihanjawaban[x][3];
        return jawaban4;
    }

    public String getJawabanbenar(int x) {
        String jawaban = jawabanbenar[x];
        return jawaban;
    }
}
