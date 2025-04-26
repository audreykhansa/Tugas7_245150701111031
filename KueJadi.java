package TugasPraktikum7;

public class KueJadi extends Kue {
    private double jumlah;

    public KueJadi(String nama, double harga, double jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }

    public double getJumlah() {
        return jumlah;
    }

    public double hitungHarga() {
        return getHarga() * jumlah * 2;
    }

    public String getJenis() {
        return "KueJadi";
    }

    public String toString() {
        String jumlahStr = (jumlah % 1 == 0) ? String.format("%d", (int) jumlah) : String.format("%.1f", jumlah).replace('.', ',');
        return "[KueJadi] " + super.getNama() + " - Jumlah: " + jumlahStr + ", Total Harga: " + hitungHarga();
    }
}
