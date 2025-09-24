public class Barang extends Produk 
{
    private String merek;
    private int stok;
    private int tahunKeluaran;

    // Constructor
    public Barang() 
    {
        super();
        this.merek = "";
        this.stok = 0;
        this.tahunKeluaran = 0;
    }

    // Getter
    public String getMerek() { return this.merek; }
    public int getStok() { return this.stok; }
    public int getTahunKeluaran() { return this.tahunKeluaran; }

    // Setter
    public void setMerek(String merek) { this.merek = merek; }
    public void setStok(int stok) { this.stok = stok; }
    public void setTahunKeluaran(int tahun) { this.tahunKeluaran = tahun; }
}