#include <bits/stdc++.h>
#include "produk.cpp"
using namespace std;

class barang : public produk // Class barang
{
private: // Atribut
    string merek;
    int stok;
    int tahunKeluaran;

public:
    // Constructor
    barang() : produk() {}

    // Getter
    string getMerek() const { return this->merek; }
    int getStok() const { return this->stok; }
    int getTahunKeluaran() const { return this->tahunKeluaran; }

    // Setter
    void setMerek(string merek) { this->merek = merek; }
    void setStok(int stok) { this->stok = stok; }
    void setTahunKeluaran(int tahun) { this->tahunKeluaran = tahun; }

    // Destructor
    ~barang() {}
};