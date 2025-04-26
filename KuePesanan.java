package TugasPraktikum7;

public class KuePesanan extends Kue {
    private double berat;

    public KuePesanan(String nama, double harga, double berat) {
        super(nama, harga);
        this.berat = berat;
    }

    public double getBerat() {
        return berat;
    }

    public double hitungHarga() {
        return getHarga() * berat;
    }

    public String getJenis() {
        return "KuePesanan";
    }

    public String toString() {
        String beratStr = (berat % 1 == 0) ? String.format("%d", (int) berat) : String.format("%.1f", berat).replace('.', ',');
        return "[KuePesanan] " + super.getNama() + " - Berat: " + beratStr + " gr, Total Harga: " + hitungHarga();
    }
}
