public class PremiumLayanan implements Layanan {
    @Override
    public double hitungHarga(int jumlahFoto) {
        return jumlahFoto * 10000; // Harga per foto untuk layanan premium
    }
}
