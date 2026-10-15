package id.ac.upb.asetpinjam.model;

import id.ac.upb.asetpinjam.kontrak.DapatDipinjam;

/**
 * Aset yang dapat dipinjam.
 *
 * <p>
 * Minggu 2: lengkapi field, konstruktor, getter/setter, dan validasi
 * (encapsulation).
 * Minggu 3: tambahkan getJenis() di tiap subclass.
 * Minggu 4: hitungDenda() dioverride di tiap subclass.
 * Minggu 5: isi bisaDipinjam() dan ubah menjadi class abstrak
 * (TestSupport.aset(...) di folder test menyesuaikan sendiri, lihat
 * docs/minggu-05.md).
 */
public class Aset implements DapatDipinjam {

    // TODO minggu 2: field private: kode, nama, status (default TERSEDIA), kondisi
    // (default BAIK).

    /**
     * TODO minggu 2: kode dan nama tidak boleh null atau kosong
     * (IllegalArgumentException).
     */
    private final String kode;
    private String nama;
    private StatusAset status;
    private Kondisi kondisi;

    public Aset(String kode, String nama) {
        this.kode = wajibAdaIsi(kode, "kode");
        this.nama = wajibAdaIsi(nama, "nama");
        this.status = StatusAset.TERSEDIA;
        this.kondisi = Kondisi.BAIK;
    }

    private static String wajibAdaIsi(String nilai, String namaField) {
        if (nilai == null || nilai.isBlank()) {
            throw new IllegalArgumentException(namaField + " tidak boleh kosong");
        }
        return nilai.trim();
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public StatusAset getStatus() {
        return status;
    }

    public Kondisi getKondisi() {
        return kondisi;
    }

    /** TODO minggu 2: nama baru tidak boleh kosong. */
    public void setNama(String nama) {
        this.nama = wajibAdaIsi(nama, "nama");
    }

    /** TODO minggu 2: status tidak boleh null. */
    public void setStatus(StatusAset status) {
        if (status == null) {
            throw new IllegalArgumentException("Status tidak boleh null");
        }
        this.status = status;
    }

    /** TODO minggu 2: kondisi tidak boleh null. */
    public void setKondisi(Kondisi kondisi) {
        if (kondisi == null) {
            throw new IllegalArgumentException("Kondisi tidak boleh null");
        }
        this.kondisi = kondisi;
    }

    /**
     * TODO minggu 5: true hanya jika status TERSEDIA dan kondisi bukan RUSAK_BERAT.
     */
    @Override
    public boolean bisaDipinjam() {
        throw new UnsupportedOperationException("TODO minggu 5");
    }

    /**
     * TODO minggu 3: dioverride tiap subclass agar mengembalikan jenis yang benar.
     */
    public JenisAset getJenis() {
        throw new UnsupportedOperationException("TODO minggu 3");
    }

    /**
     * TODO minggu 4: denda keterlambatan. Dioverride tiap subclass (aturan di
     * docs/aturan-bisnis.md).
     */
    public long hitungDenda(int hariTerlambat) {
        throw new UnsupportedOperationException("TODO minggu 4");
    }
}
