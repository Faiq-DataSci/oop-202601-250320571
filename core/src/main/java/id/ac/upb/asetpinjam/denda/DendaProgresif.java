package id.ac.upb.asetpinjam.denda;

import id.ac.upb.asetpinjam.kontrak.AturanDenda;
import id.ac.upb.asetpinjam.model.Aset;

/**
 * Minggu 5: denda yang makin berat bila makin lama terlambat.
 *
 * <p>Rumus progresifnya KEPUTUSAN ANDA (catat di docs/asumsi.md). Syarat minimal yang diuji:
 * 0 hari = 0; tidak pernah lebih murah dari DendaFlat; tidak pernah turun saat hari bertambah.
 */
public class DendaProgresif implements AturanDenda {

    @Override
    public long hitung(Aset aset, int hariTerlambat) {
        long dendaFlat = aset.hitungDenda(hariTerlambat);
        if (hariTerlambat <= 7) {
            return dendaFlat;
        }
        int blokMinggu = (hariTerlambat - 1) / 7;
        return dendaFlat + (dendaFlat * blokMinggu / 10);
    }
}
