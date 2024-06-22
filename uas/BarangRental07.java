package uas;

public class BarangRental07 {
    String noTNKB;
    String namaKendaraan;
    String jenisKendaraan;
    int tahun;
    int biayaSewa;

    BarangRental07(String noTNKB, String namaKendaraan, String jenisKendaraan, int tahun, int biayaSewa) {
        this.noTNKB = noTNKB;
        this.namaKendaraan = namaKendaraan;
        this.jenisKendaraan = jenisKendaraan;
        this.tahun = tahun;
        this.biayaSewa = biayaSewa;
    }

    @Override
    public String toString() {
        return "No TNKB: " + noTNKB +
                ", Nama Kendaraan: " + namaKendaraan +
                ", Jenis Kendaraan: " + jenisKendaraan +
                ", Tahun: " + tahun +
                ", Biaya Sewa: " + biayaSewa;
    }
}
