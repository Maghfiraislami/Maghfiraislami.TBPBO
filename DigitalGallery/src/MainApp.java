import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("--- Menu ---");
            System.out.println("1. Buat Pesanan Baru");
            System.out.println("2. Update Pesanan");
            System.out.println("3. Tampilkan Semua Pesanan");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            
            int pilihan = scanner.nextInt();
            
            switch (pilihan) {
                case 1:
                    // Buat pesanan baru
                    System.out.print("Masukkan ID Pelanggan: ");
                    int idPelanggan = scanner.nextInt();
                    System.out.print("Masukkan Jenis Layanan (standar/premium): ");
                    String jenisLayanan = scanner.next();
                    System.out.print("Masukkan Jumlah Foto: ");
                    int jumlahFoto = scanner.nextInt();
                    
                    boolean pesananBerhasil = Pesanan.simpanPesanan(idPelanggan, jenisLayanan, jumlahFoto);
                    if (pesananBerhasil) {
                        System.out.println("Pesanan berhasil disimpan!");
                    } else {
                        System.out.println("Pesanan gagal disimpan.");
                    }
                    break;

                case 2:
                    // Update pesanan
                    System.out.print("Masukkan ID Pesanan yang ingin diupdate: ");
                    int idPesanan = scanner.nextInt();
                    System.out.print("Masukkan Jenis Layanan Baru (standar/premium): ");
                    String jenisLayananBaru = scanner.next();
                    System.out.print("Masukkan Jumlah Foto Baru: ");
                    int jumlahFotoBaru = scanner.nextInt();
                    System.out.print("Masukkan Harga Total Baru: ");
                    double hargaTotalBaru = scanner.nextDouble();
                    
                    boolean updateBerhasil = Pesanan.updatePesanan(idPesanan, jenisLayananBaru, jumlahFotoBaru, hargaTotalBaru);
                    if (updateBerhasil) {
                        System.out.println("Pesanan berhasil diupdate!");
                    } else {
                        System.out.println("Pesanan gagal diupdate.");
                    }
                    break;

                case 3:
                    // Tampilkan semua pesanan
                    Pesanan.tampilkanSemuaPesanan();
                    break;

                case 4:
                    // Keluar
                    System.out.println("Terima kasih!");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}

