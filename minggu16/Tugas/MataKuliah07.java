package minggu16.Tugas;

public class MataKuliah07 {
    String kode;
    String namaMk;
    int sks;

    public MataKuliah07(String kode, String namaMk, int sks) {
        this.kode = kode;
        this.namaMk = namaMk;
        this.sks = sks;
    }

    public String toString() {
        return String.format("%s\t%-45s%s", kode, namaMk, sks);
    }
}
