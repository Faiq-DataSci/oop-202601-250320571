# Catatan Minggu 01 : Membedakan Pola Kode Prosedural, OOP dan Fungsional

## Yang saya kerjakan

Bagian yang saya kerjakan adalah pada `core/src/main/java/id/ac/upb/asetpinjam/minggu01/HelloFungsional.java, HelloOOP.java, HelloProsedural.java`

Untuk Pengerjaan Pertama saya dimulai dari file `HelloFungsional.java` saya menambahkan kode java pada bagian fungsi `pembuatSapaan` dengan sebagai berikut :

```java
return nama -> "Hello Aset-Pinjam, Saya " + nama + " (" + nim + ")";
```

Untuk Pengerjaan kedua pada file `HelloOOP.java` saya menambahkan atribut pada kelas `HelloOOP` :

```java
private String nama;
private String nim;
```

Selanjutnya saya menambahkan variabel konstruktor dari `HelloOOP` dengan kode :

```java
this.nama = nama;
this.nim = nim;
```

Selanjutnya saya menambahkan hasil keluaran dari method `sapa` dengan kode :

```java
return "Hello Aset-Pinjam, Saya " + nama + " (" + nim + ")";
```

Dan Pengerjaan terakhir saya, pada file `HelloProsedural.java` yaitu saya menambahkan kode pada bagian method `sapa` saaja

```java
return "Hello Aset-Pinjam, Saya " + nama + " (" + nim + ")";
```

## Keputusan desain

1. Format Kalimat.
   - Kenapa NIM dikasih tanda dalam kurung?
   - Kenapa nama dulu baru nim?

2. Pola Kode Java.
   - Kenapa pola kode pada file `HelloOOP`, `HelloFungsional` dan `HelloProsedural` berbeda?

3. Bentuk fungsi di `HelloFungsional`.
   - Kenapa pada fungsi di `Hellofungsional` berbeda dengan `HelloProsedural`?

### Jawaban Keputusan Desain

1. **Jawaban Pertama** :

Format kalimat:

```bash
Hello Aset-Pinjam, Saya Faiq Atha Rulloh (250320571)
```

> Alasannya : Karena NIM saya dikasih tanda dalam kurung agar terbaca sebagai pelengkap identitas, bukan bagian dari nama.

2. **Jawaban Kedua** :

`HelloFungsional` menggunakan fungsi sebagai berikut :

```java
public static Function<String, String> pembuatSapaan(String nim) {
   return nama -> "Hello Aset-Pinjam, Saya " + nama + " (" + nim + ")";
}
```

> Alasannya : Karena gaya fungsional memperlakukan fungsi sebagai data.

Sementara `HelloProsedural` langsung menerima semua data dan menghasilkan String:

```java
public static String sapa(String nama, String nim)
```

> Alasan kedua: gaya prosedural memperlakukan fungsi sebagai urutan instruksi langsung yang menghasilkan nilai.

## Kendala

Bagian yang sulit :

Menurut saya pada bagian file `HelloFungsional.java` di fungsi `pembuatSapaan` saya masih awam terkait penggunaan `<String String>` dan penggunaan lambda pada java.

Cara Mengatasinya :

Saya Mencari referensi terkait tipe data pada sebuah fungsi dan penggunaan lambda pada fungsi di java

## Penggunaan AI

- Alat yang dipakai: Qoder
- Bagian yang dibantu AI: Fungsi `pembuatSapaan()`dan penggunaan lambda pada fungsi `pembuatSapaan()`
- Prompt utama: Jelaskan bagaimana penggunaan lambda pada java, jelaskan pada bagian `Function<String, String>` dan berikan contohnya.
- Yang saya ubah atau tolak dari saran AI, dan alasannya: Yang saya ubah hanyalah penataan hasil kode dari sebuah methodnya saja.
- Satu hal yang saya pahami lebih baik sekarang: yang saya pahami adalah terkait penggunaan `Function<String, String>` adalah menerima input harus dalam tipe data string dan hasil outputnya tipe datanya string
