package minggu13;

import java.util.Scanner;

public class MainAntrianPelanggan07 {
    public static void main(String[] args) {

        BengkelMobil07 bengkel = new BengkelMobil07();
        Scanner scanner = new Scanner(System.in);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===============================================");
            System.out.println("               MENU ANTRIAN BENGKEL            ");
            System.out.println("===============================================");
            System.out.println("1. Tambahkan antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian Sekaligus Tambah Layanan");
            System.out.println("4. Laporan Layanan Terdapat Total Pemasukan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    scanner.nextLine(); // consume newline
                    System.out.println("==============================");
                    System.out.print("Masukkan nama pelanggan: ");
                    String namaPelanggan = scanner.nextLine();
                    System.out.print("Masukkan nomor HP: ");
                    String nomorHp = scanner.nextLine();
                    Pelanggan07 pelanggan = new Pelanggan07(namaPelanggan, nomorHp);
                    System.out.print("Masukkan kode layanan: ");
                    int kodeLayanan = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Masukkan nama layanan: ");
                    String namaLayanan = scanner.nextLine();
                    System.out.print("Masukkan harga layanan: ");
                    int hargaLayanan = scanner.nextInt();
                    System.out.println("==============================");
                    Layanan07 layanan = new Layanan07(kodeLayanan, namaLayanan, hargaLayanan);
                    bengkel.tambahAntrian(pelanggan, layanan);
                    break;
                case 2:
                    System.out.println("==============================");
                    System.out.println("Antrian saat ini:");
                    bengkel.cetakAntrian();
                    System.out.println("==============================");
                    break;
                case 3:
                    System.out.println("===================================================");
                    System.out.print("Masukkan nomor antrian yang ingin diubah layanannya: ");
                    int nomorAntrian = scanner.nextInt();
                    System.out.print("Masukkan kode layanan baru: ");
                    int newKodeLayanan = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Masukkan nama layanan baru: ");
                    String newNamaLayanan = scanner.nextLine();
                    System.out.print("Masukkan harga layanan baru: ");
                    int newHargaLayanan = scanner.nextInt();
                    System.out.println("===================================================");
                    Layanan07 newLayanan = new Layanan07(newKodeLayanan, newNamaLayanan, newHargaLayanan);
                    bengkel.hapusDanTambahLayanan(nomorAntrian, newLayanan);
                    break;
                case 4:
                    System.out.println("==============================");
                    System.out.println("Total pemasukan: Rp " + bengkel.totalPemasukan());
                    System.out.println("==============================");
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    scanner.close();
                    System.exit(0);
                default:
            }
        }
    }
}
