<?php
require_once 'rumahtangga.php';
require_once 'function.php';
session_start();

// FLASH MESSAGE
if (isset($_SESSION['flash'])) {
    $pesan = $_SESSION['flash'];
    unset($_SESSION['flash']);
} else {
    $pesan = '';
}

// Inisialisasi session
if (!isset($_SESSION['barang'])) {
    $_SESSION['barang'] = [];
}

// Handle tambah barang
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['tambah'])) {
    // Buat objek baru — constructor kosong
    $rt = new RumahTangga();

    $id = trim($_POST['id']);
    $nama = trim($_POST['nama']);
    $harga = (int)$_POST['harga'];
    $stok = (int)$_POST['stok'];
    $merek = trim($_POST['merek']);
    $tahun = (int)$_POST['tahun'];
    $seri = trim($_POST['seri']);
    $daya = (int)$_POST['daya'];
    $fitur = trim($_POST['fitur']);

    $gambar = '';
    if (isset($_FILES['gambar']) && $_FILES['gambar']['error'] === UPLOAD_ERR_OK) {
        $fileName = $_FILES['gambar']['name'];
        $fileTmp = $_FILES['gambar']['tmp_name'];
        $fileExt = pathinfo($fileName, PATHINFO_EXTENSION);
        $newFileName = uniqid() . '.' . strtolower($fileExt);
        $targetPath = 'gambar/' . $newFileName;

        if (move_uploaded_file($fileTmp, $targetPath)) {
            $gambar = $targetPath;
        }
    }

    if ($id && $nama && $harga >= 0 && $stok >= 0 && $merek && $tahun >= 0 && $seri && $daya >= 0 && $fitur && $gambar) {
        $rt->setId($id);
        $rt->setNama($nama);
        $rt->setHarga($harga);
        $rt->setStok($stok);
        $rt->setMerek($merek);
        $rt->setTahun($tahun);
        $rt->setSeri($seri);
        $rt->setDaya($daya);
        $rt->setFitur($fitur);
        $rt->setFotoProduk($gambar);

        $_SESSION['barang'][] = $rt; // simpan objek ke session

        $_SESSION['flash'] = "<div class='alert success'>Barang berhasil ditambahkan!</div>";
        header("Location: index.php");
        exit;
    } else {
        $_SESSION['flash'] = "<div class='alert error'>Gagal menambahkan barang. Pastikan semua data dan gambar diisi.</div>";
        header("Location: index.php");
        exit;
    }
}
?>

<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css">
    <title>Manajemen Barang</title>
</head>
<body>
    <div class="container">
        <h1>📦 Manajemen Barang Toko Ah Fung</h1>

        <?php if (isset($pesan)) echo $pesan; ?>

        <!-- FORM TAMBAH -->
        <div class="form-container">
            <h3>Tambah Barang Baru</h3>
            <form method="POST" enctype="multipart/form-data">
                <label>ID Barang:</label>
                <input type="text" name="id" required>

                <label>Nama Barang:</label>
                <input type="text" name="nama" required>

                <label>Harga:</label>
                <input type="text" name="harga" required inputmode="numeric" pattern="[0-9]*" oninput="this.value = this.value.replace(/[^0-9]/g, '')">

                <label>Stok:</label>
                <input type="number" name="stok" required min="0">

                <label>Merek:</label>
                <input type="text" name="merek" required>

                <label>Tahun Keluaran:</label>
                <input type="text" name="tahun" required oninput="this.value = this.value.replace(/[^0-9]/g, '')">

                <label>Seri/Model:</label>
                <input type="text" name="seri" required>

                <label>Daya (Watt):</label>
                <input type="text" name="daya" required oninput="this.value = this.value.replace(/[^0-9]/g, '')">

                <label>Fitur Unggulan:</label>
                <input type="text" name="fitur" required>

                <label>Gambar Barang:</label>
                <input type="file" name="gambar" required>

                <button type="submit" name="tambah">Tambah Barang</button>
            </form>
        </div>

        <!-- TABEL DATA BARANG -->
        <h3>📋 Daftar Barang</h3>
        <?php if (empty($_SESSION['barang'])): ?>
            <p>Belum ada barang.</p>
        <?php else: ?>
            <table>
                <thead>
                    <tr>
                        <th>Gambar</th>
                        <th>ID</th>
                        <th>Nama</th>
                        <th>Harga</th>
                        <th>Stok</th>
                        <th>Merek</th>
                        <th>Tahun</th>
                        <th>Seri</th>
                        <th>Daya(W)</th>
                        <th>Fitur</th>
                    </tr>
                </thead>
                <tbody>
                    <?php foreach ($_SESSION['barang'] as $barang): ?>
                    <tr>
                        <td><img src="<?php echo htmlspecialchars($barang->getFotoProduk()); ?>" alt="Gambar"></td>
                        <td><?php echo htmlspecialchars($barang->getId()); ?></td>
                        <td><?php echo htmlspecialchars($barang->getNama()); ?></td>
                        <td>Rp <?php echo number_format($barang->getHarga(), 0, ',', '.'); ?></td>
                        <td><?php echo $barang->getStok(); ?></td>
                        <td><?php echo htmlspecialchars($barang->getMerek()); ?></td>
                        <td><?php echo $barang->getTahun(); ?></td>
                        <td><?php echo htmlspecialchars($barang->getSeri()); ?></td>
                        <td><?php echo $barang->getDaya(); ?></td>
                        <td><?php echo htmlspecialchars($barang->getFitur()); ?></td>
                        </td>
                    </tr>
                    <?php endforeach; ?>
                </tbody>
            </table>
        <?php endif; ?>
    </div>
</body>
</html>