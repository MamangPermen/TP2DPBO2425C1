import java.util.*;

public class Main 
{
    // Global list untuk menyimpan data
    static ArrayList<RumahTangga> daftar = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // === Helper Repeat Character ===
    public static String repeatChar(char c, int n)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    // === Helper Pad Right String ===
    public static String padRight(String s, int width) 
    {
        if (s.length() >= width) return s;
        return s + repeatChar(' ', width - s.length());
    }

    // === Helper Pad Right Integer ===
    public static String padRightInt(int num, int width) 
    {
        return padRight(String.valueOf(num), width);
    }

    // === fungsi Tambah Data ===
    public static void addata() 
    {
        RumahTangga rt = new RumahTangga();

        System.out.println("\n--- Tambah Barang ---");
        System.out.print(" > Masukkan ID Produk        : ");
        String id = scanner.nextLine();
        rt.setId(id);

        System.out.print(" > Masukkan Nama Produk      : ");
        String nama = scanner.nextLine();
        rt.setNama(nama);

        System.out.print(" > Masukkan Merek            : ");
        String merek = scanner.nextLine();
        rt.setMerek(merek);

        System.out.print(" > Masukkan Harga            : ");
        int harga = Integer.parseInt(scanner.nextLine());
        rt.setHarga(harga);

        System.out.print(" > Masukkan Stok             : ");
        int stok = Integer.parseInt(scanner.nextLine());
        rt.setStok(stok);

        System.out.print(" > Masukkan Tahun Produksi   : ");
        int tahun = Integer.parseInt(scanner.nextLine());
        rt.setTahun(tahun);

        System.out.print(" > Masukkan Seri/Model       : ");
        String seri = scanner.nextLine();
        rt.setSeri(seri);

        System.out.print(" > Masukkan Konsumsi Daya (W): ");
        int daya = Integer.parseInt(scanner.nextLine());
        rt.setDaya(daya);

        System.out.print(" > Fitur                     : ");
        String fitur = scanner.nextLine();
        rt.setFitur(fitur);

        daftar.add(rt);
        System.out.println("Data berhasil ditambahkan!\n");
    }

    // === fungsi Tampilkan Tabel ===
    public static void showdata() 
    {
        if (daftar.isEmpty()) 
        {
            System.out.println("\nKosong euy\n");
            return;
        }

        String[] headers = {"ID", "Merek", "Nama", "Tahun", "Seri", "Daya(W)", "Harga", "Stok", "Fitur"};
        int[] lebar = new int[headers.length];

        // Inisialisasi lebar dari header
        for (int i = 0; i < headers.length; i++) 
        {
            lebar[i] = headers[i].length();
        }

        // Hitung lebar maksimum dari data
        for (RumahTangga brg : daftar)
        {
            if (brg.getId().length() > lebar[0]) lebar[0] = brg.getId().length();
            if (brg.getMerek().length() > lebar[1]) lebar[1] = brg.getMerek().length();
            if (brg.getNama().length() > lebar[2]) lebar[2] = brg.getNama().length();
            if (String.valueOf(brg.getTahun()).length() > lebar[3]) lebar[3] = String.valueOf(brg.getTahun()).length();
            if (brg.getSeri().length() > lebar[4]) lebar[4] = brg.getSeri().length();
            if (String.valueOf(brg.getDaya()).length() > lebar[5]) lebar[5] = String.valueOf(brg.getDaya()).length();
            if (String.valueOf(brg.getHarga()).length() > lebar[6]) lebar[6] = String.valueOf(brg.getHarga()).length();
            if (String.valueOf(brg.getStok()).length() > lebar[7]) lebar[7] = String.valueOf(brg.getStok()).length();
            if (brg.getFitur().length() > lebar[8]) lebar[8] = brg.getFitur().length();
        }

        // Hitung total panjang baris
        int totalPanjang = 0;
        for (int w : lebar) 
        {
            totalPanjang += w + 3;
        }
        totalPanjang += 1; // pipe paling kiri

        // Cetak border atas
        System.out.println("+" + repeatChar('-', totalPanjang - 2) + "+");

        // Cetak header
        System.out.print("|");
        for (int i = 0; i < headers.length; i++) 
        {
            System.out.print(" " + padRight(headers[i], lebar[i]) + " |");
        }
        System.out.println();

        // Cetak border tengah
        System.out.println("+" + repeatChar('-', totalPanjang - 2) + "+");

        // Cetak data
        for (RumahTangga brg : daftar) 
        {
            System.out.println(
                "| " + padRight(brg.getId(), lebar[0]) + " |" +
                " " + padRight(brg.getMerek(), lebar[1]) + " |" +
                " " + padRight(brg.getNama(), lebar[2]) + " |" +
                " " + padRightInt(brg.getTahun(), lebar[3]) + " |" +
                " " + padRight(brg.getSeri(), lebar[4]) + " |" +
                " " + padRightInt(brg.getDaya(), lebar[5]) + " |" +
                " " + padRightInt(brg.getHarga(), lebar[6]) + " |" +
                " " + padRightInt(brg.getStok(), lebar[7]) + " |" +
                " " + padRight(brg.getFitur(), lebar[8]) + " |"
            );
        }

        // Cetak border bawah
        System.out.println("+" + repeatChar('-', totalPanjang - 2) + "+");
    }

    public static void initAwal() // Inisialisasi 5 data awal
    {
        if (!daftar.isEmpty()) return;

        RumahTangga rt1 = new RumahTangga();
        rt1.setId("RT001"); rt1.setNama("Kipas Angin Miyako"); rt1.setMerek("Miyako");
        rt1.setHarga(250000); rt1.setStok(15); rt1.setTahun(2023);
        rt1.setSeri("MYK-FAN23"); rt1.setDaya(45); rt1.setFitur("3 kecepatan, remote");
        daftar.add(rt1);

        RumahTangga rt2 = new RumahTangga();
        rt2.setId("RT002"); rt2.setNama("Setrika Philips"); rt2.setMerek("Philips");
        rt2.setHarga(180000); rt2.setStok(8); rt2.setTahun(2022);
        rt2.setSeri("HD1173"); rt2.setDaya(300); rt2.setFitur("Anti lengket, otomatis mati");
        daftar.add(rt2);

        RumahTangga rt3 = new RumahTangga();
        rt3.setId("RT003"); rt3.setNama("Blender Oxone"); rt3.setMerek("Oxone");
        rt3.setHarga(320000); rt3.setStok(5); rt3.setTahun(2024);
        rt3.setSeri("OX-228S"); rt3.setDaya(500); rt3.setFitur("5 kecepatan, tabung kaca");
        daftar.add(rt3);

        RumahTangga rt4 = new RumahTangga();
        rt4.setId("RT004"); rt4.setNama("Rice Cooker Maspion"); rt4.setMerek("Maspion");
        rt4.setHarga(210000); rt4.setStok(12); rt4.setTahun(2023);
        rt4.setSeri("MC-123"); rt4.setDaya(400); rt4.setFitur("1.8L, penghangat otomatis");
        daftar.add(rt4);

        RumahTangga rt5 = new RumahTangga();
        rt5.setId("RT005"); rt5.setNama("Vacuum Cleaner Sharp"); rt5.setMerek("Sharp");
        rt5.setHarga(850000); rt5.setStok(3); rt5.setTahun(2024);
        rt5.setSeri("EC-1234"); rt5.setDaya(800); rt5.setFitur("Tanpa kabel, hisap kuat");
        daftar.add(rt5);
    }

    // === PROGRAM UTAMA ===
    public static void main(String[] args) 
    {
        initAwal(); // Inisialisasi 5 data awal

        while (true) 
        {
            System.out.println("\n=== Manajemen Barang Toko Ah Fung ===");
            System.out.println("1. Tambah barang");
            System.out.println("2. Lihat daftar");
            System.out.println("0. Exit");
            System.out.print("Pilih: ");
            String pilihan = scanner.nextLine();

            if (pilihan.equals("1")) 
            {
                addata();
            } else if (pilihan.equals("2")) 
            {
                showdata();
            } else if (pilihan.equals("0")) 
            {
                System.out.println("Naha geusan euy");
                break;
            } else {
                System.out.println("Pilihan gaada");
            }
        }

        scanner.close();
    }
}