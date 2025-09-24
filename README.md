# TP2DPBO2425C1

---

# Manajemen Barang Toko Elektronik Ah Fung #2

---

## Janji
Saya Nadhif Arva Anargya dengan NIM 2404336 mengerjakan Tugas Praktikum 2 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek. Untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

---

## 📌 Deskripsi
Repositori ini berisi sebuah program berbasis **Object-Oriented Programming (OOP)** dengan implementasi konsep **multi-level inheritance** menggunakan bahasa pemrograman **C++, Java, Python, dan PHP**.  
Program ini dirancang untuk membantu pengelolaan barang di toko sederhana dengan fitur **tambah data barang** dan **menampilkan daftar barang**.

---

## 🏗️ Struktur Kelas
Program dibangun dengan tiga tingkat kelas:

### 1. `produk`
Kelas paling dasar yang merepresentasikan sebuah produk umum.
**Atribut:**
- `id : string` → kode unik produk
- `nama : string` → nama produk
- `harga : int` → harga produk  

**Method:**
- `produk()` → constructor default
- `~produk()` → destructor
- `getId(), getNama(), getHarga()` → mengambil nilai atribut
- `setId(), setNama(), setHarga()` → mengubah nilai atribut

---

### 2. `barang` (turunan dari `produk`)
Menambahkan atribut yang lebih spesifik terkait barang dagangan, yaitu:
**Atribut:**
- `merek : string` → merek barang
- `stok : int` → jumlah stok tersedia
- `tahun : int` → tahun produksi  

**Method:**
- `barang()` → constructor default
- `~barang()` → destructor
- `getMerek(), getStok(), getTahun()` → mengambil nilai atribut
- `setMerek(), setStok(), setTahun()` → mengubah nilai atribut

---

### 3. `rumahtangga` (turunan dari `barang`)
Merepresentasikan produk rumah tangga dengan detail tambahan:
**Atribut:**
- `seri : string` → seri atau model
- `daya : int` → konsumsi daya (Watt)
- `fitur : string` → fitur tambahan  

**Method:**
- `rumahtangga()` → constructor default
- `~rumahtangga()` → destructor
- `getSeri(), getDaya(), getFitur()` → mengambil nilai atribut
- `setSeri(), setDaya(), setFitur()` → mengubah nilai atribut

---
## 📊 Diagram

![alt text](https://github.com/MamangPermen/TP2DPBO2425C1/blob/main/Screenshots/diagram.png)

---

## ⚙️ Alur Program
1. **Menu Utama**  
   Program menampilkan pilihan:
   - `1` → Tambah data barang  
   - `2` → Lihat daftar barang  
   - `0` → Keluar
   - GUI pada PHP yang langsung menampilkan form penambahan barang serta daftar barang.

2. **Tambah Data Barang**  
   - Program menggunakan setter untuk mengisi data atribut.
   - User diminta mengisi seluruh atribut (`id`, `nama`, `merek`, `harga`, `stok`, `tahun`, `seri`, `daya`, `fitur`).

3. **Tampilkan Data**  
   - Program menggunakan getter untuk mengambil nilai atribut.
   - Seluruh data barang yang tersimpan ditampilkan dalam format tabel dengan lebar kolom otomatis menyesuaikan isi.

5. **Output**
   - Program Mengeluarkan output mengenai informasi lengkap data barang.

4. **Keluar Program**  
   - Program berhenti saat user memilih opsi `0` pada C++, Java, dan Python.

---

## 🖥️Dokumentasi
1. **C++**
![alt text](https://github.com/MamangPermen/TP2DPBO2425C1/blob/main/Screenshots/cpp.png)

---

2. **Java**
![alt text](https://github.com/MamangPermen/TP2DPBO2425C1/blob/main/Screenshots/java.png)

---

3. **Python**
![alt text](https://github.com/MamangPermen/TP2DPBO2425C1/blob/main/Screenshots/python.png)

---

3. **PHP**
![alt text](https://github.com/MamangPermen/TP2DPBO2425C1/blob/main/Screenshots/php1.png)
![alt text](https://github.com/MamangPermen/TP2DPBO2425C1/blob/main/Screenshots/php2.png)
