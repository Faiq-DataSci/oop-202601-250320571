# Catatan Minggu 05: Abstraction

## Yang saya kerjakan

Di minggu ini saya mengubah `Aset` menjadi kelas abstrak dan membuat method `hitungDenda(int)` juga abstrak. Saya juga mengubah `getJenis()` menjadi abstrak karena semua subclass sudah punya versi override-nya sendiri. Method `bisaDipinjam()` saya isi dengan pengecekan status dan kondisi, jadi aset hanya bisa dipinjam kalau statusnya TERSEDIA dan kondisinya bukan RUSAK_BERAT. Setelah itu saya mengerjakan dua kelas aturan denda, yaitu `DendaFlat` yang langsung memakai hasil `aset.hitungDenda(hari)`, dan `DendaProgresif` yang menambahkan biaya tambahan setelah satu minggu. Saya juga menambahkan catatan rumus progresif di `docs/asumsi.md`, lalu menjalankan tes minggu 5.

## Keputusan desain

Untuk `DendaProgresif` saya pakai rumus yang sederhana: hari 1 sampai 7 dendanya sama dengan denda flat, lalu setiap kelipatan minggu berikutnya ditambah 10% dari denda flat hari itu. Jadi kalau terlambat 30 hari, blok minggunya empat dan dendanya menjadi 40% lebih mahal dari flat. Saya pilih rumus ini karena gampang dihitung, tidak pernah lebih murah dari denda flat, dan tidak mungkin turun walaupun hari terlambat bertambah.

Saya juga membiarkan `Aset` tetap menyimpan method bantu `hitungDenda(int, int)` yang sudah dibuat minggu lalu. Tiap subclass tetap hanya menentukan multiplier-nya, sedangkan `DendaFlat` cukup memanggil hasil akhir dari aset. Dengan begitu tidak ada rumus yang ditulis ulang di kelas denda.

## Kendala

Awalnya saya bingung kenapa `Aset` perlu dibuat abstrak padahal semua methodnya sudah jalan. Setelah saya lihat tes dan `TestSupport`, ternyata tujuannya supaya tidak ada objek `Aset` yang dibuat langsung tanpa jenis yang jelas. Tes lama tetap aman karena `TestSupport.aset(...)` otomatis memakai `Ruang` begitu `Aset` abstrak.

Kendala kedua ada di rumus progresif. Saya sempat kepikiran memakai persentase per hari, tapi hasilnya jadi terlalu rumit dan rawan pembulatan. Akhirnya saya pakai per blok minggu saja supaya hasilnya tetap bulat dan mudah dicek.

## Penggunaan AI

- Alat yang dipakai: DeepSeek
- Bagian yang dibantu AI: isi `bisaDipinjam()`, perubahan `Aset` menjadi abstrak, `DendaFlat.hitung`, dan `DendaProgresif.hitung`
- Prompt utama: bantu lengkapi method `bisaDipinjam()` dan jadikan `Aset` abstrak tanpa merusak tes minggu sebelumnya; lalu bantu buat rumus denda progresif yang tidak pernah lebih murah dari denda flat dan pada hari ke-30 lebih mahal
- Yang saya ubah atau tolak dari saran AI, dan alasannya: AI sempat menyarankan rumus progresif dengan persentase yang naik setiap hari. Saya tidak pakai karena perhitungannya jadi panjang dan sulit dicek. Saya pilih penambahan per blok minggu supaya lebih sederhana dan tetap memenuhi syarat tes.
- Satu hal yang saya pahami lebih baik sekarang: kelas abstrak dipakai saat kelas induk sudah tidak masuk akal untuk dibuat objeknya sendiri, tetapi perilaku dan field yang sama masih bisa dipakai bersama oleh subclass.
