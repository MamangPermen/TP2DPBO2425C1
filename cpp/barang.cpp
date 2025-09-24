#include <bits/stdc++.h>
#include "produk.cpp"
using namespace std;

class barang : public produk // Class barang
{
private: // Atribut
    string merek;
    int stok;
    int tahun;

public:
    // Constructor
    barang() : produk() {}

    // Getter
    string getMerek() const { return this->merek; }
    int getStok() const { return this->stok; }
    int getTahun() const { return this->tahun; }

    // Setter
    void setMerek(string merek) { this->merek = merek; }
    void setStok(int stok) { this->stok = stok; }
    void setTahun(int tahun) { this->tahun = tahun; }

    // Destructor
    ~barang() {}
};