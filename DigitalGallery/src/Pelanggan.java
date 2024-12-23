public class Pelanggan {
    private int id;
    private String nama;
    private String noHp;

    public Pelanggan(int id, String nama, String noHp) {
        this.id = id;
        this.nama = nama;
        this.noHp = noHp;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getNoHp() {
        return noHp;
    }

    @Override
    public String toString() {
        return "Pelanggan{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", noHp='" + noHp + '\'' +
                '}';
    }
}
