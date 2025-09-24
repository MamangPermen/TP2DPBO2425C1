from barang import Barang

class RumahTangga(Barang):
    def __init__(self):
        super().__init__()
        self.seri = ""
        self.daya = 0
        self.fitur = ""

    # Getter
    def get_seri(self):
        return self.seri

    def get_daya(self):
        return self.daya

    def get_fitur(self):
        return self.fitur

    # Setter
    def set_seri(self, seri):
        self.seri = seri

    def set_daya(self, daya):
        self.daya = daya

    def set_fitur(self, fitur):
        self.fitur = fitur

    # Destructor
    def __del__(self):
        pass