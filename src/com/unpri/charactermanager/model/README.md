# Character Manager — TP3 (Java Visual SIH-6406)

## Deskripsi

Character Manager adalah program Java sederhana untuk mengelola data karakter menggunakan konsep Object-Oriented Programming (OOP). Program ini menerapkan class, constructor, enum, encapsulation, serta fitur tambahan berupa mana dan pengecekan status hidup karakter.

## Screenshot Output

!![alt text](image.png)(output.png)

## Struktur Folder

```text
CharacterManager/
├── README.md
├── output.png
└── src/
    ├── Main.java
    └── com/
        └── unpri/
            └── charactermanager/
                └── model/
                    ├── Character.java
                    └── CharacterType.java
```

https://docs.google.com/document/d/1KItXMR23LWpFIc2pxm6GX3PtGBmMKYAsuRWfwW_jIm0/edit?usp=sharing



# Java Visual TP5 — CharacterManager

## Identitas Mahasiswa

- Nama: [Nama Lengkap]
- NIM: [NIM]
- Kelas: [Kelas]
- Mata Kuliah: Pemrograman Berorientasi Objek

## Deskripsi Project

Project ini merupakan pengembangan dari CharacterManager yang dibuat menggunakan bahasa pemrograman Java. Project ini bertujuan untuk mengelola data karakter dengan menerapkan konsep Object-Oriented Programming (OOP), seperti encapsulation, class, object, method, dan reference.

## Fitur Utama

### 1. Character

Class Character digunakan untuk menyimpan data karakter, seperti nama, tipe, level, HP, attack, dan mana.

Method equals() digunakan untuk membandingkan nama karakter. Perbandingan nama dilakukan tanpa membedakan huruf besar dan kecil, sehingga nama "Arthur" dan "arthur" dianggap sama.

### 2. CharacterManager

CharacterManager digunakan untuk mengelola daftar karakter. Method yang tersedia meliputi:

- addCharacter(): menambahkan karakter baru dan menolak nama duplikat.
- findByName(): mencari karakter berdasarkan nama.
- removeCharacter(): menghapus karakter berdasarkan nama.
- getTotalCharacters(): menghitung jumlah karakter.
- getAllCharacters(): mengembalikan salinan daftar karakter.
- getAverageLevel(): menghitung rata-rata level karakter.
- findByType(): mencari karakter berdasarkan tipe.
- findStrongest(): mencari karakter dengan nilai attack tertinggi.

## Mini-Challenge

Method getAverageLevel() menghitung rata-rata level seluruh karakter. Jika daftar karakter kosong, method mengembalikan 0.0 untuk menghindari pembagian dengan nol.

Method findByType() mengembalikan daftar baru yang berisi karakter sesuai tipe yang dipilih.

## Fitur Tambahan: findStrongest()

Fitur tambahan yang saya buat adalah findStrongest(). Method ini digunakan untuk mencari karakter dengan nilai attack tertinggi.

Fitur ini membantu pengguna mengetahui karakter yang memiliki attack paling besar tanpa harus membandingkan nilai attack satu per satu secara manual.

Method ini hanya membaca data karakter dan tidak mengubah daftar internal CharacterManager. Jika daftar karakter kosong, method mengembalikan null karena belum ada karakter yang bisa dipilih.

## Encapsulation dan Defensive Copy

Class CharacterManager menggunakan ArrayList private untuk menyimpan daftar karakter. Daftar tersebut tidak dapat diakses secara langsung dari luar class.

Method getAllCharacters() mengembalikan salinan daftar menggunakan new ArrayList<>(characters). Dengan demikian, penambahan atau penghapusan elemen pada daftar hasil tidak akan mengubah daftar internal CharacterManager.

Namun, salinan ini bersifat shallow copy. Objek Character di dalam daftar hasil masih menggunakan reference ke objek yang sama.

## Hasil Pengujian

Pengujian program dilakukan untuk memeriksa beberapa fitur berikut:

1. Menambahkan karakter baru.
2. Menolak penambahan karakter dengan nama duplikat.
3. Mencari dan menghapus karakter.
4. Menghitung jumlah karakter.
5. Menghitung rata-rata level.
6. Mencari karakter berdasarkan tipe.
7. Mencari karakter dengan attack tertinggi.
8. Menguji defensive copy pada getAllCharacters().
9. Menguji perilaku reference pada objek Character.

### Screenshot Output
![alt text](image-1.png)
## Analisis Reference

Analisis mengenai reference, primitive value, static variable, equals(), dan defensive copy dijelaskan lebih lanjut pada Google Docs berikut:

**Link Google Docs:** https://docs.google.com/document/d/1xOGdtX8e_b4P3pPjKPBP1YwG6WKi52PwaSiJyu9EP0A/edit?usp=sharing

## Kesimpulan

Melalui project ini, saya mempelajari cara mengelola objek menggunakan Java, membandingkan objek berdasarkan data tertentu, menghindari duplikasi nama, serta menjaga data internal menggunakan encapsulation dan defensive copy. Saya juga mempelajari bahwa reference berpengaruh terhadap cara objek diakses dan diubah dalam program Java.


## TP8 — Character Manager GUI dan Analisis MVC

### 1. Implementasi MainWindow

Pada TP8 ini, program Character Manager dikembangkan dari program berbasis console menjadi aplikasi berbasis GUI (Graphical User Interface) menggunakan Java Swing.

Class `MainWindow` menggunakan `JFrame` sebagai jendela utama. Data karakter ditampilkan secara dinamis menggunakan perulangan (`for`), sehingga setiap karakter yang dimasukkan ke dalam `CharacterManager` dapat ditampilkan secara otomatis.

Aplikasi juga memiliki JLabel statistik yang menampilkan rata-rata level seluruh karakter.

### 2. Screenshot Hasil Program

**Screenshot sebelum penambahan data:**
![alt text](<Screenshot 2026-10-23 165624.png>)

**Screenshot setelah penambahan data:**

![alt text](<Screenshot 2026-10-23 165707.png>)

Simpan gambar dengan nama `tp8-sesudah.png`.

### 3. Alur Data dan Konsep MVC

Alur kerja program dimulai dari class `Main` yang membuat objek karakter dan memasukkannya ke dalam `CharacterManager`. Selanjutnya, objek `CharacterManager` diberikan kepada `MainWindow` untuk menampilkan seluruh data karakter melalui perulangan. `CharacterManager` berperan sebagai bagian Model karena mengelola data karakter, sedangkan `MainWindow` berperan sebagai View karena menampilkan data kepada pengguna. Dengan demikian, program sudah menerapkan pemisahan antara pengelolaan data dan tampilan, meskipun pada implementasi sederhana ini View masih mengambil data langsung dari Manager.

### 4. Karakter Baru

Karakter yang ditambahkan dalam pengembangan TP8:

| Nama | Tipe | Level | Alasan Pemilihan |
|---|---|---|---|
| Necro | ASSASSIN | Default | Memiliki tipe karakter dengan peran menyerang secara cepat dan menggunakan mana 50. |
| Luna | MAGE | 5 | Dipilih sebagai karakter penyihir dengan level lebih tinggi. |
| Boris | WARRIOR | 4 | Dipilih sebagai karakter petarung dengan level 4 dan HP 180. |

Selain ketiga karakter tersebut, program juga menampilkan Arthur, Merlin, dan Robin sebagai karakter awal.

### 5. Link Analisis GUI dan MVC

Dokumen analisis lengkap Bagian D dapat diakses melalui Google Docs berikut:

**[Masukkan link Google Docs Bagian D di sini]
https://docs.google.com/document/d/1e4WSpcUuLrjbcymYySnkJd_caUBpeygr76uJX331IHs/edit?usp=sharing
