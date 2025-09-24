#include <bits/stdc++.h>
#include "rumahtangga.cpp"
using namespace std;

vector<rumahtangga> daftar; // Menyimpan daftar barang

// Helper: membuat string berisi karakter berulang
string repeatChar(char c, int n)
{
    string s = "";
    for (int i = 0; i < n; i++) s += c;
    return s;
}

// Helper: padding string ke kanan
string padRight(string s, int width)
{
    if ((int)s.length() >= width) return s;
    return s + repeatChar(' ', width - s.length());
}

// Helper: padding integer ke kanan
string padRightInt(int num, int width)
{
    return padRight(to_string(num), width);
}

// Fungsi tambah data
void addata()
{
    rumahtangga rt;
    string id, nama, merek, seri, fitur;
    int harga, stok, tahun, daya;

    cout << "--- Tambah Barang ---\n";
    cout << " > Masukkan ID Produk        : "; cin >> id;
    rt.setId(id);

    cin.ignore();
    cout << " > Masukkan Nama Produk      : "; getline(cin, nama);
    rt.setNama(nama);

    cout << " > Masukkan Merek            : "; getline(cin, merek);
    rt.setMerek(merek);

    cout << " > Masukkan Harga            : "; cin >> harga;
    rt.setHarga(harga);

    cout << " > Masukkan Stok             : "; cin >> stok;
    rt.setStok(stok);

    cout << " > Masukkan Tahun Produksi   : "; cin >> tahun;
    rt.setTahun(tahun);

    cin.ignore();
    cout << " > Masukkan Seri/Model       : "; getline(cin, seri);
    rt.setSeri(seri);

    cout << " > Masukkan Konsumsi Daya (W): "; cin >> daya;
    rt.setDaya(daya);

    cin.ignore();
    cout << " > Fitur                     : "; getline(cin, fitur);
    rt.setFitur(fitur);

    // Set atribut
    rt.setId(id);
    rt.setNama(nama);
    rt.setHarga(harga);
    rt.setStok(stok);
    rt.setMerek(merek);
    rt.setTahun(tahun);
    rt.setSeri(seri);
    rt.setDaya(daya);
    rt.setFitur(fitur);

    daftar.push_back(rt);
    cout << "Data berhasil ditambahkan!\n";
}

// Fungsi tampilkan tabel
void showdata() 
{
    if (daftar.empty()) // Kalo kosong
    {
        cout << "\nKosong euy\n";
        return;
    }

    vector<string> headers = // Definisikan nama kolom
    {
        "ID", "Merek", "Nama", "Tahun", "Seri", "Daya(W)", "Harga", "Stok", "Fitur"
    };

    vector<int> lebar; // Hitung lebar tiap kolom
    for (int i = 0; i < headers.size(); i++)
    {
        lebar.push_back(headers[i].length());
    }

    for (int idx = 0; idx < daftar.size(); idx++) // Loop index buat cek panjang tiap atribut
    {
        rumahtangga& brg = daftar[idx];

        if (brg.getId().length() > lebar[0]) lebar[0] = brg.getId().length();

        if (brg.getMerek().length() > lebar[1]) lebar[1] = brg.getMerek().length();

        if (brg.getNama().length() > lebar[2]) lebar[2] = brg.getNama().length();

        int panjangTahun = to_string(brg.getTahun()).length();
        if (panjangTahun > lebar[3]) lebar[3] = panjangTahun;

        if (brg.getSeri().length() > lebar[4]) lebar[4] = brg.getSeri().length();

        int panjangDaya = to_string(brg.getDaya()).length();
        if (panjangDaya > lebar[5]) lebar[5] = panjangDaya;
        
        int panjangHarga = to_string(brg.getHarga()).length();
        if (panjangHarga > lebar[6]) lebar[6] = panjangHarga;
        
        int panjangStok = to_string(brg.getStok()).length();
        if (panjangStok > lebar[7]) lebar[7] = panjangStok;
        
        if (brg.getFitur().length() > lebar[8]) lebar[8] = brg.getFitur().length();
    }

    int totalPanjang = 0;
    for (int w : lebar) // Hitung total panjang baris
    {
        totalPanjang += w + 3;
    }
    totalPanjang += 1; // pipe paling kiri

    cout << "+" << repeatChar('-', totalPanjang - 2) << "+" << endl; // Border atas

    cout << "|"; // Header
    for (int i = 0; i < headers.size(); i++) // Loop kolom
    {
        cout << " " << padRight(headers[i], lebar[i]) << " |";
    }
    cout << endl;

    cout << "+" << repeatChar('-', totalPanjang - 2) << "+" << endl; // Border pemisah

    for (int i = 0; i < daftar.size(); i++) // Isi tabel
    {
        rumahtangga& x = daftar[i];
        cout << "| " << padRight(x.getId(), lebar[0]) << " |"
             << " " << padRight(x.getMerek(), lebar[1]) << " |"
             << " " << padRight(x.getNama(), lebar[2]) << " |"
             << " " << padRightInt(x.getTahun(), lebar[3]) << " |"
             << " " << padRight(x.getSeri(), lebar[4]) << " |"
             << " " << padRightInt(x.getDaya(), lebar[5]) << " |"
             << " " << padRightInt(x.getHarga(), lebar[6]) << " |"
             << " " << padRightInt(x.getStok(), lebar[7]) << " |"
             << " " << padRight(x.getFitur(), lebar[8]) << " |" << endl;
    }

    cout << "+" << repeatChar('-', totalPanjang - 2) << "+" << endl; // Border bawah
}

void initAwal() // Inisialisasi 5 data awal
{
    if (!daftar.empty()) return; // Hindari duplikasi

    rumahtangga rt1;
    rt1.setId("RT001"); rt1.setNama("Kipas Angin"); rt1.setMerek("Miyako");
    rt1.setHarga(250000); rt1.setStok(15); rt1.setTahun(2023);
    rt1.setSeri("MYK-FAN23"); rt1.setDaya(45); rt1.setFitur("3 kecepatan, remote");
    daftar.push_back(rt1);

    rumahtangga rt2;
    rt2.setId("RT002"); rt2.setNama("Setrika Philips"); rt2.setMerek("Philips");
    rt2.setHarga(180000); rt2.setStok(8); rt2.setTahun(2022);
    rt2.setSeri("HD1173"); rt2.setDaya(300); rt2.setFitur("Anti lengket, otomatis mati");
    daftar.push_back(rt2);

    rumahtangga rt3;
    rt3.setId("RT003"); rt3.setNama("Blender Oxone"); rt3.setMerek("Oxone");
    rt3.setHarga(320000); rt3.setStok(5); rt3.setTahun(2024);
    rt3.setSeri("OX-228S"); rt3.setDaya(500); rt3.setFitur("5 kecepatan, tabung kaca");
    daftar.push_back(rt3);

    rumahtangga rt4;
    rt4.setId("RT004"); rt4.setNama("Rice Cooker Maspion"); rt4.setMerek("Maspion");
    rt4.setHarga(210000); rt4.setStok(12); rt4.setTahun(2023);
    rt4.setSeri("MC-123"); rt4.setDaya(400); rt4.setFitur("1.8L, penghangat otomatis");
    daftar.push_back(rt4);

    rumahtangga rt5;
    rt5.setId("RT005"); rt5.setNama("Vacuum Cleaner Sharp"); rt5.setMerek("Sharp");
    rt5.setHarga(850000); rt5.setStok(3); rt5.setTahun(2024);
    rt5.setSeri("EC-1234"); rt5.setDaya(800); rt5.setFitur("Tanpa kabel, hisap kuat");
    daftar.push_back(rt5);
}