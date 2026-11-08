# Asumsi dan Keputusan Desain

Isi bagian ini sendiri. Satu entri per keputusan. Dinilai dari kejelasan alasan dan konsistensi dengan kode dan tes Anda,
bukan dari jawaban "benar".

Format tiap entri:

```
## A-NN: judul singkat
- Pertanyaan: ...
- Keputusan: ...
- Alasan: ...
- Dampak ke kode: ... (kelas/metode)
- Tes yang membuktikan: ... (nama tes di folder mahasiswa/)
```

## Aturan ambigu dari docs/aturan-bisnis.md

Salin setiap pertanyaan ambigu (nomor 1 sampai 7) ke sini dan jawab. Contoh:

## A-01: batas waktu bentrok

- Pertanyaan: 09:00-11:00 dan 11:00-13:00 pada aset yang sama bentrok atau tidak?
- Keputusan: Tidak bentrok.
- Alasan: Jam selesai dianggap sebagai batas akhir pemakaian, jadi tepat pukul 11:00 aset sudah selesai dipakai dan langsung bisa digunakan peminjam berikutnya seperti jadwal kelas di kampus.
- Dampak ke kode: `JadwalPeminjaman.bentrok(Peminjaman)` memakai perbandingan `baru.getMulai().isBefore(p.getSelesai()) && baru.getSelesai().isAfter(p.getMulai())`.
- Tes yang membuktikan: `BatasBentrokTest.selesaiSamaDenganMulai`.

## Asumsi lain

Tambahkan di sini keputusan lain yang Anda ambil: rumus denda progresif, perubahan skema database, format error API, dan seterusnya.

## A-02: rumus denda progresif

- Pertanyaan: bagaimana denda naik setelah batas tertentu?
- Keputusan: hari 1-7 sama dengan denda flat; setiap kelipatan minggu setelahnya menambah 10% dari denda flat pada hari itu (`dendaFlat * blokMinggu / 10`, dengan `blokMinggu = (hari - 1) / 7`).
- Alasan: tetap sederhana, tidak pernah lebih murah dari flat, dan pada hari ke-30 sudah 40% lebih mahal sehingga keterlambatan panjang terasa lebih berat.
- Dampak ke kode: `DendaProgresif.hitung(Aset, int)`.
- Tes yang membuktikan: `Minggu05AbstraksiTest.dendaProgresifMemenuhiSyaratMinimal`.
