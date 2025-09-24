public class RumahTangga extends Barang
{
    private String seri;
    private int daya;
    private String fitur;

    // Constructor
    public RumahTangga() 
    {
        super();
        this.seri = "";
        this.daya = 0;
        this.fitur = "";
    }

    // Getter
    public String getSeri() { return this.seri; }
    public int getDaya() { return this.daya; }
    public String getFitur() { return this.fitur; }

    // Setter
    public void setSeri(String seri) { this.seri = seri; }
    public void setDaya(int daya) { this.daya = daya; }
    public void setFitur(String fitur) { this.fitur = fitur; }
}