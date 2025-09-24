from rumahtangga import RumahTangga

# Global list untuk menyimpan data
daftar = []

# === FUNGSI Helper ===
def repeat_char(c, n):
    return c * n

def pad_right(s, width):
    if len(s) >= width:
        return s
    return s + " " * (width - len(s))

def pad_right_int(num, width):
    return pad_right(str(num), width)

# === FUNGSI INPUT DATA ===
def addata():
    rt = RumahTangga()

    print("\n--- Tambah Barang ---")
    id = input(" > Masukkan ID Produk        : ")
    rt.set_id(id)

    nama = input(" > Masukkan Nama Produk      : ")
    rt.set_nama(nama)

    merek = input(" > Masukkan Merek            : ")
    rt.set_merek(merek)

    harga = int(input(" > Masukkan Harga            : "))
    rt.set_harga(harga)

    stok = int(input(" > Masukkan Stok             : "))
    rt.set_stok(stok)

    tahun = int(input(" > Masukkan Tahun Produksi   : "))
    rt.set_tahun(tahun)

    seri = input(" > Masukkan Seri/Model       : ")
    rt.set_seri(seri)

    daya = int(input(" > Masukkan Konsumsi Daya (W): "))
    rt.set_daya(daya)

    fitur = input(" > Fitur                     : ")
    rt.set_fitur(fitur)

    daftar.append(rt)
    print("Data berhasil ditambahkan!\n")

# === FUNGSI TAMPILKAN TABEL ===
def showdata():
    if len(daftar) == 0:
        print("\nKosong euy\n")
        return

    headers = ["ID", "Merek", "Nama", "Tahun", "Seri", "Daya(W)", "Harga", "Stok", "Fitur"]
    lebar = [len(h) for h in headers]

    # Hitung lebar maksimum dari data
    for brg in daftar:
        if len(brg.get_id()) > lebar[0]:
            lebar[0] = len(brg.get_id())
        if len(brg.get_merek()) > lebar[1]:
            lebar[1] = len(brg.get_merek())
        if len(brg.get_nama()) > lebar[2]:
            lebar[2] = len(brg.get_nama())
        if len(str(brg.get_tahun())) > lebar[3]:
            lebar[3] = len(str(brg.get_tahun()))
        if len(brg.get_seri()) > lebar[4]:
            lebar[4] = len(brg.get_seri())
        if len(str(brg.get_daya())) > lebar[5]:
            lebar[5] = len(str(brg.get_daya()))
        if len(str(brg.get_harga())) > lebar[6]:
            lebar[6] = len(str(brg.get_harga()))
        if len(str(brg.get_stok())) > lebar[7]:
            lebar[7] = len(str(brg.get_stok()))
        if len(brg.get_fitur()) > lebar[8]:
            lebar[8] = len(brg.get_fitur())

    # Hitung total panjang baris
    total_panjang = sum(w + 3 for w in lebar) + 1

    # Print border atas
    print("+" + repeat_char("-", total_panjang - 2) + "+")

    # Print header
    print("|", end="")
    for i in range(len(headers)):
        print(" " + pad_right(headers[i], lebar[i]) + " |", end="")
    print()

    # Print border tengah
    print("+" + repeat_char("-", total_panjang - 2) + "+")

    # Print data
    for brg in daftar:
        print("| " + pad_right(brg.get_id(), lebar[0]) + " |"
              + " " + pad_right(brg.get_merek(), lebar[1]) + " |"
              + " " + pad_right(brg.get_nama(), lebar[2]) + " |"
              + " " + pad_right_int(brg.get_tahun(), lebar[3]) + " |"
              + " " + pad_right(brg.get_seri(), lebar[4]) + " |"
              + " " + pad_right_int(brg.get_daya(), lebar[5]) + " |"
              + " " + pad_right_int(brg.get_harga(), lebar[6]) + " |"
              + " " + pad_right_int(brg.get_stok(), lebar[7]) + " |"
              + " " + pad_right(brg.get_fitur(), lebar[8]) + " |")

    # Print border bawah
    print("+" + repeat_char("-", total_panjang - 2) + "+")

# === PROGRAM UTAMA ===
def main():
    while True:
        print("\n=== MENU TOKO ELEKTRONIK Ah Fung ===")
        print("1. Tambah barang")
        print("2. Lihat daftar")
        print("0. Exit")
        pilihan = input("Pilih: ")

        if pilihan == "1":
            addata()
        elif pilihan == "2":
            showdata()
        elif pilihan == "0":
            print("Naha geusan euy")
            break
        else:
            print("Pilihan gaada")

# Jalankan program
if __name__ == "__main__":
    main()