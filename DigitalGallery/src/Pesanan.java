import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Pesanan {
    private static Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/dbphotobox"; // Ganti dengan URL database Anda
        String user = "root"; // Ganti dengan username database Anda
        String password = ""; // Ganti dengan password database Anda
        return DriverManager.getConnection(url, user, password);
    }

    // Menyimpan pesanan baru
    public static boolean simpanPesanan(int idPelanggan, String jenisLayanan, int jumlahFoto) {
        String query = "INSERT INTO pesanan (id_pelanggan, jenis_layanan, jumlah_foto, harga_total, tanggal_pesanan) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            
            double hargaTotal = jenisLayanan.equalsIgnoreCase("premium") ? jumlahFoto * 10000 : jumlahFoto * 5000;
            java.sql.Date tanggalPesanan = new java.sql.Date(System.currentTimeMillis()); // Menyimpan tanggal pesanan

            stmt.setInt(1, idPelanggan);
            stmt.setString(2, jenisLayanan);
            stmt.setInt(3, jumlahFoto);
            stmt.setDouble(4, hargaTotal);
            stmt.setDate(5, tanggalPesanan);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0; // Jika ada perubahan, berarti pesanan berhasil disimpan
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Memperbarui pesanan
    public static boolean updatePesanan(int idPesanan, String jenisLayanan, int jumlahFoto, double hargaTotal) {
        String query = "UPDATE pesanan SET jenis_layanan = ?, jumlah_foto = ?, harga_total = ? WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, jenisLayanan);
            stmt.setInt(2, jumlahFoto);
            stmt.setDouble(3, hargaTotal);
            stmt.setInt(4, idPesanan);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Menampilkan semua pesanan
    public static void tampilkanSemuaPesanan() {
        String query = "SELECT id, id_pelanggan, jenis_layanan, jumlah_foto, harga_total, tanggal_pesanan FROM pesanan";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                System.out.println("ID Pesanan: " + rs.getInt("id"));
                System.out.println("ID Pelanggan: " + rs.getInt("id_pelanggan"));
                System.out.println("Jenis Layanan: " + rs.getString("jenis_layanan"));
                System.out.println("Jumlah Foto: " + rs.getInt("jumlah_foto"));
                System.out.println("Harga Total: " + rs.getDouble("harga_total"));

                // Cek apakah tanggal_pesanan NULL atau 0000-00-00
                java.sql.Date tanggalPesanan = rs.getDate("tanggal_pesanan");
                if (tanggalPesanan != null) {
                    System.out.println("Tanggal Pesanan: " + tanggalPesanan);
                } else {
                    System.out.println("Tanggal Pesanan: Tidak valid");
                }
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}