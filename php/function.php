<?php

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