package minggu16.Tugas;

public class Mahasiswa07 {
    String nim;
    String nama;
    String telepon;

    public Mahasiswa07(String nim, String nama, String telepon) {
        this.nim = nim;
        this.nama = nama;
        this.telepon = telepon;
    }

    @Override
    public String toString() {
        return String.format("%s\t%-15s\t%s", nim, nama, telepon);
    }
}
