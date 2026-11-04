# Catatan Minggu 06: UML dan SOLID

## Yang saya kerjakan

Saya membuat class diagram dan sequence diagram dalam format Mermaid di folder `docs/uml`. Class diagram berisi kelas model, interface, DAO, dan kelas denda beserta atribut, method, relasi, dan multiplicity. Sequence diagram menggambarkan pengajuan peminjaman dengan fragmen `alt` untuk skenario sukses dan bentrok. Saya juga menulis `docs/uml/solid.md` dan merapikan `LayananDenda` agar menyimpan `AturanDenda` lewat konstruktor.

## Keputusan desain

Saya memilih OCP dan DIP karena keduanya sudah terlihat di kode tanpa perlu menambah banyak kelas baru. OCP saya tunjukkan lewat hierarki `Aset` dan implementasi `AturanDenda`, sedangkan DIP saya tunjukkan lewat interface `AsetDAO`, `PeminjamanDAO`, dan `AturanDenda`. Saya memakai Mermaid karena sumbernya berupa teks, mudah di-commit, dan tidak perlu alat gambar tambahan. Sequence diagram saya buat memakai kelas yang memang ada, yaitu `JadwalPeminjaman`, `Peminjaman`, dan `Aset`, tanpa menambahkan service baru.

## Kendala

Method `ajukan` dan `bentrok` masih TODO pada minggu ini, jadi sequence diagram saya susun dari signature dan aturan bisnis di `docs/aturan-bisnis.md`, bukan dari implementasi final. Di Mermaid, sintaks namespace dan generic perlu dicek agar diagram tidak rusak. Untuk relasi, saya memakai aggregation pada `KatalogAset` dan `JadwalPeminjaman` karena keduanya hanya menyimpan daftar objek, bukan memiliki siklus hidup objek tersebut.

## Penggunaan AI

- Alat yang dipakai: opencode (DeepSeek)
- Bagian yang dibantu AI: diagram Mermaid, `docs/uml/solid.md`, `LayananDenda`, dan catatan ini
- Prompt utama: buat class diagram dan sequence diagram Mermaid yang sesuai dengan kode minggu 6; pilih dua prinsip SOLID yang benar-benar terlihat di kode; isi catatan minggu 6 dengan bahasa sederhana
- Yang saya ubah atau tolak dari saran AI, dan alasannya: AI sempat menyarankan menambah kelas service khusus untuk sequence diagram. Saya tolak karena kelas itu belum ada di kode dan akan membuat diagram tidak konsisten. Saya juga tidak menambah kelas baru untuk SOLID, cukup memakai interface dan subclass yang sudah ada.
- Satu hal yang saya pahami lebih baik sekarang: DIP membuat kelas bergantung pada interface, jadi implementasi asli bisa diganti dengan objek palsu saat tes.
