class Produk:
    def __init__(self):
        self.id = ""
        self.nama = ""
        self.harga = 0

    # Getter
    def get_id(self):
        return self.id

    def get_nama(self):
        return self.nama

    def get_harga(self):
        return self.harga

    # Setter
    def set_id(self, id):
        self.id = id

    def set_nama(self, nama):
        self.nama = nama

    def set_harga(self, harga):
        self.harga = harga

    # Destructor (opsional di Python)
    def __del__(self):
        pass