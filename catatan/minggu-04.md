# Catatan Minggu 04: Polymorphism

## Yang saya kerjakan

Minggu ini saya mulai dari file `Aset.java`. Saya menambahkan satu method bantu yang bernama protected long hitungDenda(int hariTerlambat, int multiplier). Isi dari method ini adalah menolak hari yang bernilai negatif, lalu menghitung hasilnya dengan mengalikan hariTerlambat dengan multiplier dan Varian.aktif().dendaPerHari. Setelah itu saya melakukan override method hitungDenda(int) di kelas Ruang, Laptop, dan AlatLab. Masing-masing dari kelas ini menggunakan multiplier 1, 2, dan 4 sesuai aturan yang berlaku. Bagian terakhir saya mengisi dua method cari di KatalogAset, yaitu versi yang hanya menggunakan kata kunci dan versi yang menggunakan kata kunci ditambah jenis aset. Setelah semua selesai, saya menjalankan perintah mvn test untuk minggu 1 sampai 4 dan hasilnya ada 27 tes yang lulus.

## Keputusan desain

Saya sengaja tidak menulis rumus denda di ketiga subclass. Saya meletakkan rumus tersebut di satu method bantu di Aset. Setiap subclass hanya perlu menyebutkan nilai multiplier-nya sendiri. Alasannya adalah agar jika tarif atau cara perhitungan berubah, saya hanya perlu mengubah satu tempat saja. Sementara itu, tiap subclass tetap bisa memiliki perilaku yang berbeda melalui override.

Untuk pencarian, saya mengubah kata kunci dan nama aset menjadi huruf kecil menggunakan Locale.ROOT, bukan toLowerCase() tanpa parameter. Saya sempat baca bahwa toLowerCase() biasanya mengikuti aturan bahasa komputer pengguna, jadi saya memilih yang lebih netral. Jika kata bernilai null, saya anggap sebagai string kosong agar semua aset tetap muncul, bukan melempar error yang tidak diminta.

Overload cari(kata, jenis) saya buat dengan hanya satu kali putaran pada daftar. Saya memeriksa apakah getJenis() sama dengan jenis, dan kecocokan nama di dalam kondisi yang sama. Jadi tidak perlu membuat daftar hasil sementara lalu menyaringnya lagi.

## Kendala

Bagian yang paling membuat saya terpikir adalah perbedaan antara overloading dan overriding, karena nama method-nya sama-sama hitungDenda. Awalnya saya bingung mengapa Aset memiliki dua method dengan nama yang sama. Setelah saya urutkan, ternyata method hitungDenda(int, int) dipilih saat kode dikompilasi berdasarkan jumlah parameter. Sedangkan method hitungDenda(int) di subclass dipanggil saat program berjalan, sesuai dengan objek aslinya.

Kendala kedua adalah pengecekan hari negatif. Jika saya taruh pengecekan itu di tiap subclass, kode jadi berulang dan mungkin terlewat. Akhirnya saya pindahkan pengecekan itu ke method bantu di Aset, jadi ketiga subclass otomatis menolak hari negatif tanpa perlu menulis if sendiri-sendiri.

## Penggunaan AI

- Alat yang digunakan: DeepSeek

- Bagian yang dibantu AI: kerangka method hitungDenda(int, int) di Aset, override di Ruang, Laptop, AlatLab, dan dua overload cari di KatalogAset

- Prompt utama:

- jelaskan perbedaan overloading dan overriding pada method hitungDenda, lalu bantu susun method bantu agar pengecekan hari negatif tidak ditulis berulang

- bantu cek dua overload cari di KatalogAset supaya pencarian nama tidak membedakan huruf besar dan kecil

- Yang saya ubah atau tolak dari saran AI, dan alasannya: AI sempat menyarankan cari(kata, jenis) memakai instanceof untuk mengecek jenis aset. Saya tidak pakai karena setiap subclass sudah punya getJenis(), jadi cukup membandingkan hasil dari method itu. Saya juga menolak saran menaruh tarif denda langsung di tiap subclass karena bikin rumus terduplikasi.

- Satu hal yang saya pahami lebih baik sekarang: saat variabel bertipe Aset menunjuk ke Laptop, method hitungDenda yang dijalankan tetap versi Laptop. Override ditentukan dari objek sebenarnya saat program berjalan, bukan dari tipe variabelnya.
