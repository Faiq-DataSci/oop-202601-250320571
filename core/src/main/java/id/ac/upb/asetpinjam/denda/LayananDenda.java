package id.ac.upb.asetpinjam.denda;

import id.ac.upb.asetpinjam.kontrak.AturanDenda;
import id.ac.upb.asetpinjam.model.Aset;

/**
 * Minggu 10: konteks pola Strategy. Aturan denda DISUNTIKKAN lewat konstruktor
 * (bukan dibuat di dalam kelas ini), sehingga bisa diganti tanpa mengubah kelas ini.
 */
public class LayananDenda {

    private final AturanDenda aturan;

    /** Aturan tidak boleh null (IllegalArgumentException). */
    public LayananDenda(AturanDenda aturan) {
        if (aturan == null) {
            throw new IllegalArgumentException("aturan tidak boleh null");
        }
        this.aturan = aturan;
    }

    public long hitung(Aset aset, int hariTerlambat) {
        return aturan.hitung(aset, hariTerlambat);
    }
}
