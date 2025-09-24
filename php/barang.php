<?php

require_once 'produk.php';

class Barang extends Produk 
{
    public $merek;
    public $tahun;
    public $stok;

    public function __construct($id = "", $nama = "", $harga = 0, $stok = 0, $merek = "", $tahun = 0, $foto_produk = "") 
    {
        parent::__construct($id, $nama, $harga, $foto_produk);
        $this->stok = $stok;
        $this->merek = $merek;
        $this->tahun = $tahun;
    }

    // Getter
    public function getStok() { return $this->stok; }
    public function getMerek() { return $this->merek; }
    public function getTahun() { return $this->tahun; }
    // Setter
    public function setStok($stok) { $this->stok = $stok; }
    public function setMerek($merek) { $this->merek = $merek; }
    public function setTahun($tahun) { $this->tahun = $tahun; }
}