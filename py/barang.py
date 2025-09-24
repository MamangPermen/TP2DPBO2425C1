from produk import Produk

class Barang(Produk):
    def __init__(self):
        super().__init__()
        self.merek = ""
        self.stok = 0
        self.tahun = 0

    # Getter
    def get_merek(self):
        return self.merek

    def get_stok(self):
        return self.stok

    def get_tahun(self):
        return self.tahun

    # Setter
    def set_merek(self, merek):
        self.merek = merek

    def set_stok(self, stok):
        self.stok = stok

    def set_tahun(self, tahun):
        self.tahun = tahun

    # Destructor
    def __del__(self):
        pass