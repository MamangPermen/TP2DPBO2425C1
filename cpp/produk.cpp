#include <bits/stdc++.h>
using namespace std;

class produk // Class produk
{
private: // Atribut
    string id;
    string nama;
    int harga;

public:
    // Constructor
    produk() {}

    // Getter
    string getId() const { return this->id; }
    string getNama() const { return this->nama; }
    int getHarga() const { return this->harga; }

    // Setter
    void setId(string id) { this->id = id; }
    void setNama(string nama) { this->nama = nama; }
    void setHarga(int harga) { this->harga = harga; }

    // Destructor
    ~produk() {}
};