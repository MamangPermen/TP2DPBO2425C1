#include "lib.h"

int main() // Main program
{
    int pilihan;
    do {
        cout << "=== Manajemen Barang Toko Ah Fung ===\n";
        cout << "1. Tambah barang\n";
        cout << "2. Lihat daftar\n";
        cout << "0. Exit\n";
        cout << "Pilih: ";
        cin >> pilihan;
        cin.ignore();

        if (pilihan == 1)
        {
            addata();
        } else if (pilihan == 2)
        {
            showdata();
        } else if (pilihan != 0) 
        {
            cout << "Pilihan gaada\n";
        }

    } while (pilihan != 0);

    cout << "Naha geusan euy\n";
    return 0;
}