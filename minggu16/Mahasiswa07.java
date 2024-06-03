package minggu16;

public class Mahasiswa07 {
    String nim;
    String nama;
    String notelp;

    public Mahasiswa07() {

    }

    public Mahasiswa07(String nim, String nama, String notelp) {
        this.nim = nim;
        this.nama = nama;
        this.notelp = notelp;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" + "nim=" + nim + ", nama=" + nama + ", notelp=" + notelp + '}';
    }
}
