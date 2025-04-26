package TugasPraktikum7;

public abstract class Kue {
    private String nama;
    private double harga;

    public static final String MATA_UANG = "Rp";

    public Kue(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public abstract double hitungHarga();

    public String getJenis() {
        return "Kue";
    }

    public String toString() {
        return String.format("%s (%.2f)", nama, hitungHarga());
    }
}
