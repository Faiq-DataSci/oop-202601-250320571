# Catatan Minggu 02: Struktur OOP: Class, Object, Encapsulation

## Yang saya kerjakan

Minggu ini saya membuat class `Aset` dengan empat field, yaitu `kode`, `nama`, `status`, dan `kondisi`. Semuanya saya buat `private` supaya tidak bisa diubah langsung dari luar class. Konstruktor hanya menerima `kode` dan `nama`, sedangkan `status` dan `kondisi` langsung saya isi dengan nilai awal `TERSEDIA` dan `BAIK`.

Untuk mengecek `kode` dan `nama`, saya membuat satu method bernama `wajibAdaIsi` karena keduanya punya aturan yang sama. Method ini saya gunakan di konstruktor dan `setNama`, jadi saya tidak perlu menulis pengecekan yang sama berulang kali. Selebihnya, saya menambahkan getter untuk membaca nilai field dan tiga setter untuk mengubah field yang memang boleh diubah.

## Keputusan desain

Saya membuat `kode` menjadi `final` karena memang tidak boleh diubah melalui `setKode`. Kalau hanya tidak membuat setter, saya masih bisa saja menambahkannya tanpa sadar di kemudian hari. Dengan `final`, compiler yang akan mencegah perubahan, jadi saya tidak perlu hanya mengandalkan ingatan sendiri.

Untuk mengecek apakah input kosong, saya menggunakan `isBlank()`. Awalnya saya sempat berpikir untuk memakai `isEmpty()`, tetapi ternyata ada tes yang mengirim `"   "`. Menurut saya, kode aset yang hanya berisi spasi sama saja tidak bergunanya dengan kode kosong.

Sebelum disimpan, `kode` dan `nama` saya rapikan menggunakan `trim()` supaya tidak ada spasi berlebih di awal atau akhir. Namun, saya tidak langsung mengubah semua huruf menjadi huruf besar karena belum ada kebutuhan untuk itu. Saya juga belum tahu apakah `A-01` dan `a-01` nantinya harus dianggap sebagai aset yang sama. Jadi, saya memilih untuk tidak mengubahnya dulu dan mencatat keputusan tersebut di `docs/asumsi.md`.

Untuk setter yang menerima nilai tidak valid, saya menggunakan `IllegalArgumentException`. Saya sempat mempertimbangkan `Objects.requireNonNull()` karena lebih praktis, tetapi cara itu menghasilkan `NullPointerException`, sedangkan yang diminta adalah `IllegalArgumentException`.

Hal kecil lain yang saya pelajari adalah pengecekan harus dilakukan sebelum nilai field diubah. Pada tes `setNamaMemvalidasi`, nama lama harus tetap tersimpan ketika `setNama("")` ditolak. Jadi, kalau urutannya salah, nilai lama bisa terlanjur berubah sebelum validasi selesai.

## Kendala

Kesalahan pertama saya sebenarnya cukup sepele, tapi malah bikin bingung. Saya menulis `illegalArgumentException` dengan huruf kecil di tiga tempat sekaligus. Saya juga salah menulis nama method. Di konstruktor, saya memanggil `wajibAdaIsi`, padahal nama method yang saya buat adalah `wajibAdaString`.

Kesalahan yang paling lama saya cari ada di `setKondisi`. Saya menyalin kode dari `setStatus`, mengganti tipe parameternya, tetapi lupa mengubah isi kodenya. Akibatnya, masih ada `if (status == null)` dan `this.status = status`. Editor tidak menunjukkan error karena `status` memang ada sebagai field. Karena nilainya juga sudah dipastikan tidak `null` oleh konstruktor, pengecekan itu tidak pernah dijalankan. Akhirnya, `setKondisi` tidak mengubah apa pun dan juga tidak menolak nilai `null`.

Saya juga sempat bingung karena `mvn compile` menampilkan `BUILD SUCCESS`, padahal kode saya masih bermasalah. Ternyata, hasil kompilasi lama di folder `target/` masih terbaca. Dari situ, saya belajar untuk menjalankan `mvn clean compile` supaya kode dikompilasi ulang dari awal dan hasilnya lebih bisa dipercaya.

## Penggunaan AI

- Alat yang dipakai: Qoder
- Bagian yang dibantu AI: pada function `setStatus` dan `setKondisi`, dan di awal saya minta aturan minggu 2 dijelaskan dari `docs/minggu-02.md` dan isi `Minggu02AsetTest`
- Prompt utama:
  - berikan penjelasan cara pengerjaan pada file `docs/minggu-02.md`
- Yang saya ubah dari saran AI, dan alasannya: ada usulan menormalkan kode jadi huruf besar, itu tidak saya pakai karena belum ada kebutuhannya.
- Hal yang sekarang lebih saya pahami adalah Java tidak selalu menampilkan error ketika saya salah menggunakan field dan parameter yang namanya mirip. Kode tetap bisa berjalan, tetapi hasilnya bisa tidak sesuai dengan yang seharusnya. Saya juga jadi lebih memahami bahwa _encapsulation_ bukan hanya tentang menggunakan `private`, tetapi juga memastikan perubahan data dilakukan melalui setter. Dengan begitu, setiap perubahan bisa diperiksa terlebih dahulu. Manfaatnya baru benar-benar terasa ketika saya salah menulis `setKondisi`, tetapi program tetap berjalan tanpa menampilkan error.
