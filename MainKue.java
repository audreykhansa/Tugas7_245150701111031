package TugasPraktikum7;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Comparator;

public class MainKue {
    public static void main(String[] args) {
        Kue[] daftarKue = new Kue[20];

        daftarKue[0] = new KuePesanan("Brownies", 500, 500);
        daftarKue[1] = new KuePesanan("Bolu Kukus", 400, 350);
        daftarKue[2] = new KuePesanan("Lapis Surabaya", 600, 800);
        daftarKue[3] = new KuePesanan("Lapis Legit", 450, 950);
        daftarKue[4] = new KuePesanan("Kue Ulang Tahun", 750, 1000);
        daftarKue[5] = new KuePesanan("Nagasari", 350,100);
        daftarKue[6] = new KuePesanan("Kue Talam", 850, 100);
        daftarKue[7] = new KuePesanan("Kue Cubit", 150, 100);
        daftarKue[8] = new KuePesanan("Tart", 900, 950);
        daftarKue[9] = new KuePesanan("Brownies Kukus", 550, 900);
        daftarKue[10] = new KueJadi("Donat", 7000, 10);
        daftarKue[11] = new KueJadi("Serabi", 10000, 5);
        daftarKue[12] = new KueJadi("Kue Lumpur", 8000, 8);
        daftarKue[13] = new KueJadi("Pastel", 6000, 12);
        daftarKue[14] = new KueJadi("Lemper", 3000, 15);
        daftarKue[15] = new KueJadi("Klepon", 2500, 20);
        daftarKue[16] = new KueJadi("Martabak Mini", 9000, 6);
        daftarKue[17] = new KueJadi("Bakpia Pathok", 35000, 10);
        daftarKue[18] = new KueJadi("Nastar", 45000, 7);
        daftarKue[19] = new KueJadi("Bika Ambon", 75000, 9);


        Arrays.sort(daftarKue, Comparator.comparing(Kue::hitungHarga).reversed());

        tampilkanKueDalamTabel(daftarKue);
    }

    public static void tampilkanKueDalamTabel(Kue[] daftarKue) {
        DecimalFormat dfHarga = new DecimalFormat("#,##0");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        dfHarga.setDecimalFormatSymbols(symbols);
    
        System.out.println("\n--------------------------- KUE PESANAN ---------------------------");
        System.out.printf("| %-3s | %-17s | %-11s | %-8s | %-13s |\n", "No", "Nama Kue", "Harga/gr", "Berat", "Total Harga");
        System.out.println("|-----|-------------------|-------------|----------|---------------|");
    
        int no = 1;
        double totalHarga = 0, totalHargaPesanan = 0, totalBeratPesanan = 0;
        double totalHargaJadi = 0, totalJumlahJadi = 0;
    
        for (Kue kue : daftarKue) {
            if (kue instanceof KuePesanan) {
                KuePesanan kp = (KuePesanan) kue;
                String beratStr = (kp.getBerat() % 1 == 0) ? String.format("%d", (int) kp.getBerat()) : String.format("%.2f", kp.getBerat()).replace('.', ',');
                System.out.printf("| %-3d | %-17s | Rp%-9s | %-5s gr | Rp%-11s |\n", no++, kp.getNama(), dfHarga.format(kp.getHarga()), beratStr, dfHarga.format(kp.hitungHarga()));
                totalHarga += kp.hitungHarga();
                totalHargaPesanan += kp.hitungHarga();
                totalBeratPesanan += kp.getBerat();
            }
        }
    
        System.out.println("--------------------------------------------------------------------");
    
        System.out.println("\n---------------------------- KUE JADI -----------------------------");
        System.out.printf("| %-3s | %-17s | %-11s | %-8s | %-13s |\n", "No", "Nama Kue", "Harga", "Jumlah", "Total Harga");
        System.out.println("|-----|-------------------|-------------|----------|---------------|");
    
        no = 1;
        for (Kue kue : daftarKue) {
            if (kue instanceof KueJadi) {
                KueJadi kj = (KueJadi) kue;
                String jumlahStr = (kj.getJumlah() % 1 == 0) ? String.format("%d", (int) kj.getJumlah()) : String.format("%.2f", kj.getJumlah()).replace('.', ',');
                System.out.printf("| %-3d | %-17s | Rp%-9s | %-8s | Rp%-11s |\n", no++, kj.getNama(), dfHarga.format(kj.getHarga()), jumlahStr, dfHarga.format(kj.hitungHarga()));
                totalHarga += kj.hitungHarga();
                totalHargaJadi += kj.hitungHarga();
                totalJumlahJadi += kj.getJumlah();
            }
        }
    
        System.out.println("--------------------------------------------------------------------");
    
        String totalJumlahStr = (totalJumlahJadi % 1 == 0) ? String.format("%d", (int) totalJumlahJadi) : String.format("%.2f", totalJumlahJadi).replace('.', ',');
    
        System.out.println("");
        System.out.printf("%-37s: Rp%s\n", "Total Harga Semua Kue", dfHarga.format(totalHarga));
        System.out.printf("%-37s: Rp%s\n", "Total Harga Kue Pesanan", dfHarga.format(totalHargaPesanan));
        System.out.printf("%-37s: %s gr\n", "Total Berat Kue Pesanan", dfHarga.format(totalBeratPesanan));
        System.out.printf("%-37s: Rp%s\n", "Total Harga Kue Jadi", dfHarga.format(totalHargaJadi));
        System.out.printf("%-37s: %s\n", "Total Jumlah Kue Jadi", totalJumlahStr);
    }         
}
