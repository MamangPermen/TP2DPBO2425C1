public class Barang extends Produk 
{
    private String merek;
    private int stok;
    private int tahun;

    // Constructor
    public Barang() 
    {
        super();
        this.merek = "";
        this.stok = 0;
        this.tahun = 0;
    }

    // Getter
    public String getMerek() { return this.merek; }
    public int getStok() { return this.stok; }
    public int getTahun() { return this.tahun; }

    // Setter
    public void setMerek(String merek) { this.merek = merek; }
    public void setStok(int stok) { this.stok = stok; }
    public void setTahun(int tahun) { this.tahun = tahun; }
}