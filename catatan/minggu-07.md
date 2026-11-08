# Catatan Minggu 07: Koleksi

## Yang saya kerjakan

Minggu ini saya melengkapi empat method di kelas `JadwalPeminjaman`, yaitu `bentrok`, `semuaUrutMulai`, `perAset`, dan `hapus`. Untuk `bentrok`, saya mengecek apakah ada jadwal pada aset yang sama yang jamnya saling bertabrakan. Di `semuaUrutMulai`, saya menyalin isi list lalu mengurutkannya berdasarkan waktu mulai dengan `Comparator`. Untuk `perAset`, saya mengelompokkan daftar peminjaman ke dalam `Map` berdasarkan kode asetnya, sedangkan `hapus` saya isi dengan `removeIf` untuk menghapus data yang cocok dengan id. Selain itu, saya juga mengisi asumsi batas waktu di `docs/asumsi.md` dan membuat tesnya di `BatasBentrokTest`.

## Keputusan desain

Untuk batas waktu yang bertemu pas di jam yang sama, misalnya 09:00 sampai 11:00 lalu disambung 11:00 sampai 13:00 pada aset yang sama, saya putuskan tidak bentrok (lihat `A-01` di `docs/asumsi.md`). Alasannya karena di kampus biasanya kalau peminjaman ruang atau barang selesai jam 11:00, orang berikutnya memang langsung mulai jam 11:00 tanpa harus kasih jeda satu menit dulu. Karena itu di kode saya cukup pakai `isBefore` dan `isAfter`, jadi kalau jam selesai sama persis dengan jam mulai berikutnya hasilnya tetap `false`.

Untuk struktur data di dalam `JadwalPeminjaman`, saya tetap memakai `List<Peminjaman>` saja yang sudah ada dari awal dan tidak menambah field `Map` atau `Set` baru di kelasnya. Soalnya method `tambah()` bawaan dosen hanya memasukkan data ke `daftar`, ditambah lagi ada `daftarMutable()` yang mengembalikan list itu secara langsung. Kalau saya simpan `Map` terpisah sebagai field, nanti isinya bisa tidak sinkron waktu `tambah()` dipanggil. Jadi `HashMap` baru saya bentuk di dalam method `perAset()` saat dipanggil saja. Begitu juga di `semuaUrutMulai()`, saya buat salinan `ArrayList` baru dulu sebelum diurutkan supaya urutan asli di `daftar` tidak ikut berubah.

## Kendala

Awalnya saya agak bingung waktu menyusun kondisi `if` untuk mengecek dua rentang waktu yang tumpang tindih. Sempat kepikiran mau mengecek satu-satu kasusnya, seperti mulai di tengah, selesai di tengah, atau jadwal baru berada di dalam jadwal lama. Ternyata kalau ditulis begitu malah kepanjangan dan rawan ada kasus yang kelewat. Setelah saya gambar garis waktunya di kertas, ternyata dua jadwal pasti bentrok kalau waktu mulai yang baru lebih awal dari waktu selesai yang lama, dan waktu selesai yang baru lewat dari waktu mulai yang lama.

Kendala lainnya waktu membuat `perAset()`, awalnya saya mau pakai `if (!map.containsKey(kode))` manual buat bikin list baru. Tapi setelah lihat method yang ada di `Map`, pakai `computeIfAbsent` jauh lebih ringkas karena kalau kuncinya belum ada dia langsung buatkan `ArrayList` baru dan tinggal di-`add`.

## Penggunaan AI

- Alat yang dipakai: Antigravity
- Bagian yang dibantu AI: pengecekan logika rentang waktu di `bentrok`, pemakaian `Comparator.comparing` di `semuaUrutMulai`, pengelompokan `perAset`, serta merapikan `BatasBentrokTest`
- Prompt utama: bantu lengkapi method bentrok, semuaUrutMulai, perAset, dan hapus di JadwalPeminjaman sesuai aturan minggu 7, lalu bantu buat tes batas waktu di BatasBentrokTest
- Yang saya ubah atau tolak dari saran AI, dan alasannya: AI sempat memberi opsi memakai `Streams` (`Collectors.groupingBy`) untuk `perAset` dan `semuaUrutMulai`. Saya pilih tetap memakai perulangan `for` biasa dengan `computeIfAbsent` serta `ArrayList.sort` supaya lebih gampang saya baca dan jelaskan waktu ditanya cara kerjanya.
- Satu hal yang saya pahami lebih baik sekarang: `List` cocok dipakai untuk menyimpan urutan data utama yang bisa langsung diurutkan dengan `Comparator`, sedangkan `Map` enak dipakai saat kita butuh mengelompokkan banyak data berdasarkan satu kunci seperti kode aset.
