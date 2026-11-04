# Prinsip SOLID yang Terlihat di Kode

## 1. Open/Closed Principle (OCP)

Kelas `Aset` dibuat abstrak dan hanya menyimpan data dasar serta perilaku umum. Perbedaan jenis aset
ditaruh di subclass `Ruang`, `Laptop`, dan `AlatLab` melalui override `getJenis()` dan
`hitungDenda(int)`. `KatalogAset` hanya bekerja dengan tipe `Aset`, jadi ketika nanti ada jenis aset
baru, saya cukup menambah subclass baru tanpa mengubah `Aset` atau `KatalogAset`.

Prinsip yang sama terlihat pada `AturanDenda`. `DendaFlat` dan `DendaProgresif` adalah dua
implementasi yang bisa dipakai bergantian tanpa mengubah kode pemanggil. `LayananDenda` menerima
`AturanDenda` lewat konstruktor, sehingga penambahan aturan denda baru tidak perlu menyentuh
`LayananDenda`.

## 2. Dependency Inversion Principle (DIP)

Modul tingkat tinggi tidak bergantung pada kelas JDBC, tetapi pada interface `AsetDAO` dan
`PeminjamanDAO`. Implementasi konkretnya adalah `JdbcAsetDAO` dan `JdbcPeminjamanDAO`.
`JdbcPeminjamanDAO` bahkan menerima `AsetDAO` lewat konstruktor, bukan membuat `JdbcAsetDAO`
sendiri. Dengan begitu kelas itu hanya tahu kontrak `AsetDAO`.

Hal serupa ada di `LayananDenda` yang bergantung pada interface `AturanDenda`, bukan pada
`DendaFlat` atau `DendaProgresif`. Karena ketergantungannya berupa interface, tes bisa menyuntikkan
implementasi palsu, misalnya lambda `(aset, hari) -> 42L`, tanpa perlu database atau perhitungan
denda asli. Ini yang membuat `LayananDenda` mudah diuji.

## Catatan Konsistensi

Diagram kelas mengikuti kelas dan method yang benar-benar ada di `core/src/main/java`. Method yang
masih berupa TODO pada minggu berikutnya tetap digambar sesuai signature-nya, bukan ditambah kelas
baru yang belum ada di kode.
