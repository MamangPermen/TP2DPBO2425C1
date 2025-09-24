public class Produk 
{
    private String id;
    private String nama;
    private int harga;

    // Constructor
    public Produk() 
    {
        this.id = "";
        this.nama = "";
        this.harga = 0;
    }

    // Getter
    public String getId() { return this.id; }
    public String getNama() { return this.nama; }
    public int getHarga() { return this.harga; }

    // Setter
    public void setId(String id) { this.id = id; }
    public void setNama(String nama) { this.nama = nama; }
    public void setHarga(int harga) { this.harga = harga; }
}