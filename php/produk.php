<?php

class Produk 
{
    public $id;
    public $nama;
    public $harga;
    public $foto_produk;

    public function __construct($id = "", $nama = "", $harga = 0, $foto_produk = "") 
    {
        $this->id = $id;
        $this->nama = $nama;
        $this->harga = $harga;
        $this->foto_produk = $foto_produk;
    }

    // Getter
    public function getId() { return $this->id; }
    public function getNama() { return $this->nama; }
    public function getHarga() { return $this->harga; }
    public function getFotoProduk() { return $this->foto_produk; }

    // Setter
    public function setId($id) { $this->id = $id; }
    public function setNama($nama) { $this->nama = $nama; }
    public function setHarga($harga) { $this->harga = $harga; }
    public function setFotoProduk($foto_produk) { $this->foto_produk = $foto_produk; }
}