package uas;

public class TransaksiRental07 {
    int kodeTransaksi;
    String namaPeminjam;
    String noTNKB;
    int lamaPinjam;
    double totalBiaya;
    boolean isMember;
    BarangRental07 barangRental;

    TransaksiRental07(int kodeTransaksi, String namaPeminjam, String noTNKB, int lamaPinjam, boolean isMember,
            BarangRental07 barangRental) {
        this.kodeTransaksi = kodeTransaksi;
        this.namaPeminjam = namaPeminjam;
        this.noTNKB = noTNKB;
        this.lamaPinjam = lamaPinjam;
        this.isMember = isMember;
        this.barangRental = barangRental;
        this.totalBiaya = hitungTotalBiaya();
    }

    private double hitungTotalBiaya() {
        double biayaSewaPerHari = barangRental.biayaSewa;
        double diskon = isMember ? 0.1 : 0; // diskon 10% jika member
        return biayaSewaPerHari * lamaPinjam * (1 - diskon);
    }

    @Override
    public String toString() {
        String memberStatus = isMember ? "Member" : "Non-Member";
        return "Kode Transaksi: " + kodeTransaksi +
                ", Nama Peminjam: " + namaPeminjam +
                ", No TNKB: " + noTNKB +
                ", Lama Pinjam: " + lamaPinjam +
                " hari, Total Biaya: " + totalBiaya +
                ", Status: " + memberStatus +
                "\n  Barang Rental: " + barangRental.toString();
    }
}
