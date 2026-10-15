package id.ac.upb.asetpinjam.minggu01;

import id.ac.upb.asetpinjam.config.Varian;
import java.util.function.Function;

/**
 * Minggu 1, gaya FUNGSIONAL: fungsi sebagai nilai (lambda), tanpa state yang
 * berubah.
 */

public final class HelloFungsional {

    // Fungsi
    private HelloFungsional() {
    }

    /**
     * TODO minggu 1: kembalikan fungsi yang menerima NAMA dan menghasilkan sapaan
     * yang memuat "Aset-Pinjam", nama tersebut, dan NIM yang diberikan. Gunakan
     * lambda.
     */

    // Fungsi di dalam fungsi
    public static Function<String, String> pembuatSapaan(String nim) {
        return nama -> "Hello Aset-Pinjam, Saya " + nama + " (" + nim + ")";
    }

    public static void main(String[] args) {
        Varian v = Varian.aktif();
        System.out.println(pembuatSapaan(v.nim).apply(v.nama));
    }
}
