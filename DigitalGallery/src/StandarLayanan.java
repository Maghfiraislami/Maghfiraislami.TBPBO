public class StandarLayanan implements Layanan {
    @Override
    public double hitungHarga(int jumlahFoto) {
        return jumlahFoto * 5000; // Harga per foto untuk layanan standar
    }
}
