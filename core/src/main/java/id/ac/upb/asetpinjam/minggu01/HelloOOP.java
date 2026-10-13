package id.ac.upb.asetpinjam.minggu01;

import id.ac.upb.asetpinjam.config.Varian;

/** Minggu 1, gaya OOP: data dan perilaku dibungkus dalam sebuah class. */
public class HelloOOP {

    // TODO minggu 1: tambahkan field private untuk nama dan nim.

    // Atribut nama dan nim
    private String nama;
    private String nim;

    // Konstruktor
    public HelloOOP(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    /** TODO minggu 1: sapaan memuat "Aset-Pinjam", nama, dan NIM. */

    // Method
    public String sapa() {
        return "Hello Aset-Pinjam, Saya " + nama + " (" + nim + ")";
    }

    public static void main(String[] args) {
        Varian v = Varian.aktif();
        System.out.println(new HelloOOP(v.nama, v.nim).sapa());
    }
}
