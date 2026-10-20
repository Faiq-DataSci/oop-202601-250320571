package id.ac.upb.asetpinjam.katalog;

import id.ac.upb.asetpinjam.model.Aset;
import id.ac.upb.asetpinjam.model.JenisAset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/** Katalog aset di memori. tambah() dan semua() DISEDIAKAN; Anda mengerjakan dua overload cari() (minggu 4). */
public class KatalogAset {

    private final List<Aset> daftar = new ArrayList<>();

    public void tambah(Aset aset) {
        daftar.add(aset);
    }

    public List<Aset> semua() {
        return List.copyOf(daftar);
    }

    /** TODO minggu 4: aset yang namanya memuat kata (tanpa membedakan huruf besar/kecil). */
    public List<Aset> cari(String kata) {
        String kunci = kata == null ? "" : kata.toLowerCase(Locale.ROOT);
        List<Aset> hasil = new ArrayList<>();
        for (Aset aset : daftar) {
            if (aset.getNama().toLowerCase(Locale.ROOT).contains(kunci)) {
                hasil.add(aset);
            }
        }
        return hasil;
    }

    /** TODO minggu 4: seperti cari(kata) tetapi hanya untuk jenis yang diminta (overloading). */
    public List<Aset> cari(String kata, JenisAset jenis) {
        String kunci = kata == null ? "" : kata.toLowerCase(Locale.ROOT);
        List<Aset> hasil = new ArrayList<>();
        for (Aset aset : daftar) {
            if (aset.getJenis() == jenis
                    && aset.getNama().toLowerCase(Locale.ROOT).contains(kunci)) {
                hasil.add(aset);
            }
        }
        return hasil;
    }
}
