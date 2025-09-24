<?php
require_once 'rumahtangga.php';

function cekIdDuplikat($id, $indexToIgnore = null) 
{
    if (!isset($_SESSION['barang'])) return false;

    foreach ($_SESSION['barang'] as $index => $barang) {
        if ($indexToIgnore !== null && $index == $indexToIgnore) continue;
        if ($barang->id === $id) {
            return true;
        }
    }
    return false;
}

function initAwal() 
{
    if (!isset($_SESSION['barang']) || empty($_SESSION['barang'])) {
        $data = [
            ["RT001", "Kipas Angin Miyako", "Miyako", 250000, 15, 2023, "MYK-FAN23", 45, "3 kecepatan, remote", "gambar/kipas.jpg"],
            ["RT002", "Setrika Philips", "Philips", 180000, 8, 2022, "HD1173", 300, "Anti lengket, otomatis mati", "gambar/setrika.jpg"],
            ["RT003", "Blender Oxone", "Oxone", 320000, 5, 2024, "OX-228S", 500, "5 kecepatan, tabung kaca", "gambar/blender.jpeg"],
            ["RT004", "Rice Cooker Maspion", "Maspion", 210000, 12, 2023, "MC-123", 400, "1.8L, penghangat otomatis", "gambar/ricecooker.jpg"],
            ["RT005", "Vacuum Cleaner Sharp", "Sharp", 850000, 3, 2024, "EC-1234", 800, "Tanpa kabel, hisap kuat", "gambar/vacuum.jpg"]
        ];

        foreach ($data as $d) {
            $rt = new RumahTangga();
            $rt->setId($d[0]);
            $rt->setNama($d[1]);
            $rt->setMerek($d[2]);
            $rt->setHarga($d[3]);
            $rt->setStok($d[4]);
            $rt->setTahun($d[5]);
            $rt->setSeri($d[6]);
            $rt->setDaya($d[7]);
            $rt->setFitur($d[8]);
            $rt->setFotoProduk($d[9]);   // Gambar default

            $_SESSION['barang'][] = $rt; // Tambahkan ke session
        }
    }
}