# Catatan Minggu 03: Inheritance

## Yang saya kerjakan

Minggu ini saya mengerjakan dimulai dari file `Ruang.java` saya menambahkan field `kapasitas` dengan status akses private dalam keadaan final di class `Ruang`, setelah itu pada bagian exception pada konstraktor `Ruang` diubah menjadi `IllegalArgumentException` dengan mengisikan `"kapasitas harus lebih dari 0"` dengan pengkondisian jika kapasitas lebih besar dari 0 maka `"kapasitas harus lebih dari 0"` dan menambahkan ekspresi pada kostraktor `Ruang`, selanjutnya saya menambahkan `return kapasitas` dari getter `getKapasitas`, selanjutnya saya membuat override `getJenis` dengan menambahkan `return JenisAset`

file Kedua saya mengerjakan pada `Laptop.java` dengan menambahkan field `spesifikasi` dan `nomorInventaris` dengan keadaan private dan final dengan tipe data String, selanjutnya saya menambahkan ekspresi `spesifikasi` dan `nomorInventaris` pada Konstraktor `Laptop` dengan mereferensikan pada method `wajibAdaIsi` dengan parameter nilai dan namafield dengan tipe data string dengan pengkondisian jika nilai sama dengan null atau nilai kosong maka namefield tidak boleh kosong jika tidak keluarkan nilai tanpa spasi, selanjutnya menambahkan return spesifikasi pada getter `getSpesifikasi`, selanjutnya menambahkan return nomorInventaris pada getter `getNomorInventaris` untuk mengeluarkan nilai tersebut, selanjutnya menambahkan override `getJenis` dengan menambahkan `return JenisAset.LAPTOP`

file ketiga saya mengerjakan pada `AlatLab.java` dengan menambahkan field `laboratorium` dengan tipe data String dan `tingkatRisiko` dengan mereferensikan konstanta pada fungsi `TingkatRisiko` dan menambahkan keadaan private dan final, selanjutnya saya menambahkan pengkondisian dalam Konstraktor `AlatLab` jika laboratorium null atau laboratorium kosong maka laboratorium tidak boleh kosong, jika tingkatRisiko null maka tingkatRisiko tidak boleh null selanjutnya saya menambahkan ekspresi laboratorium dan tingkatRisiko dan saya menambahkan return pada getter `getLaboratorium` dan `getTingkatRisiko` dan selanjutnya saya menambhakan override `getjenis` dengan mengeluarkan `JenisAset.ALAT_LAB`

## Keputusan desain

Field `kode` dan `nama` saya biarkan tetap di induk `Aset` karena semua aset pasti punya keduanya, jadi tidak masuk akal kalau ditulis ulang di tiap subclass. Sementara `kapasitas`, `spesifikasi`/`nomorInventaris`, dan `laboratorium`/`tingkatRisiko` saya taruh di subclass masing-masing karena cuma relevan buat jenis aset itu sendiri, kalau dipaksa masuk ke `Aset` malah jadi field yang nganggur di subclass lain. Untuk validasi saya juga bagi dua: aturan umum seperti kode/nama tidak boleh kosong tetap di `Aset`, sedangkan aturan khusus (kapasitas > 0, spesifikasi dan nomor inventaris tidak kosong, laboratorium tidak kosong dan risiko tidak null) saya simpan di konstruktor subclass. Override `getJenis()` saya buat di tiap subclass biar tiap objek tahu jenis dirinya sendiri tanpa perlu cek `instanceof` dari luar.

Satu contoh di sistem ini yang menurut saya lebih pas pakai komposisi daripada inheritance: `Laptop` yang punya `spesifikasi`. Kalau nanti spesifikasi jadi makin detail (CPU, RAM, storage), bikin class turunan `LaptopGaming extends Laptop`, karena laptop bisa berganti spesifikasi. Lebih rapi kalau `Spesifikasi` dijadikan class sendiri.

## Kendala

Yang paling bikin saya muter-muter itu lupa manggil `super(kode, nama)` di konstruktor subclass. Awalnya validasi `Aset` seolah nggak jalan, padahal memang belum dipanggil. Setelah saya tambahkan `super` di baris pertama, validasi induk langsung ikut berlaku lagi.

Kendala kedua soal `wajibAdaIsi`. Di `Aset` method itu private, jadi nggak bisa saya pakai langsung di `Laptop`, akhirnya saya bikin ulang versi private di `Laptop`. Sempat kepikiran ubah jadi protected di induk, tapi saya belum mau ngutak-ngatik `Aset` minggu ini, jadi saya pilih duplikat dulu sambil nanti dipikirkan apakah perlu diangkat ke induk.

## Penggunaan AI

- Alat yang dipakai: Deepseek
- Bagian yang dibantu AI: pada bagian pengkondisian setiap file `Ruang.java, AlatLab.java, Laptop.java`
- Prompt utama: berikan penjelasan dan berikan kisi-kisi pada pengkondisian setiap konstruktor pada minggu-03
- Yang saya ubah atau tolak dari saran AI, dan alasannya:ada usulan menormalkan kode jadi huruf besar, itu tidak saya pakai karena belum ada kebutuhannya.
- Satu hal yang saya pahami lebih baik sekarang:
  penggunaan pengkondisian dan penggunan override pada java.
