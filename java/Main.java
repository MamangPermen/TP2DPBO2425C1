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
        rt.setTahunKeluaran(tahun);

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
            if (String.valueOf(brg.getTahunKeluaran()).length() > lebar[3]) lebar[3] = String.valueOf(brg.getTahunKeluaran()).length();
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
                " " + padRightInt(brg.getTahunKeluaran(), lebar[3]) + " |" +
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

    // === PROGRAM UTAMA ===
    public static void main(String[] args) 
    {
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