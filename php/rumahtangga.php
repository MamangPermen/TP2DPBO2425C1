<?php

require_once 'barang.php';

class RumahTangga extends Barang 
{
    public $seri;
    public $daya;
    public $fitur;

    public function __construct($id = "", $nama = "", $harga = 0, $stok = 0, $foto_produk = "", $merek = "", $tahun = 0, $seri = "", $daya = 0, $fitur = "") 
    {
        parent::__construct($id, $nama, $harga, $stok, $merek, $tahun, $foto_produk);
        $this->seri = $seri;
        $this->daya = $daya;
        $this->fitur = $fitur;
    }

    // Getter
    public function getSeri() { return $this->seri; }
    public function getDaya() { return $this->daya; }
    public function getFitur() { return $this->fitur; }

    // Setter
    public function setSeri($seri) { $this->seri = $seri; }
    public function setDaya($daya) { $this->daya = $daya; }
    public function setFitur($fitur) { $this->fitur = $fitur; }
}