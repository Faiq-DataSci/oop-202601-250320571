package id.ac.upb.asetpinjam.minggu01;

import id.ac.upb.asetpinjam.config.Varian;

/**
 * Minggu 1, gaya PROSEDURAL: hanya fungsi statis dan data primitif, tanpa objek
 * buatan sendiri.
 */
public final class HelloProsedural {

    // Fungsi
    private HelloProsedural() {
    }

    /**
     * TODO minggu 1: kembalikan sapaan yang memuat kata "Aset-Pinjam", nama, dan
     * NIM.
     * Contoh bentuk: "Hello Aset-Pinjam, Saya Budi (2310112345)".
     */

    // Fungsi di dalam fungsi
    public static String sapa(String nama, String nim) {
        return "Hello Aset-Pinjam, Saya " + nama + " (" + nim + ")";
    }

    public static void main(String[] args) {
        Varian v = Varian.aktif();
        System.out.println(sapa(v.nama, v.nim));
    }
}
