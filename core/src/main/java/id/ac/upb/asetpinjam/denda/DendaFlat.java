package id.ac.upb.asetpinjam.denda;

import id.ac.upb.asetpinjam.kontrak.AturanDenda;
import id.ac.upb.asetpinjam.model.Aset;

/** Minggu 5: denda tetap per hari, sama dengan aset.hitungDenda(hari). */
public class DendaFlat implements AturanDenda {

    @Override
    public long hitung(Aset aset, int hariTerlambat) {
        return aset.hitungDenda(hariTerlambat);
    }
}
