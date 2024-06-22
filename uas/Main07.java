package uas;

import java.util.Scanner;

public class Main07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SingleLinkedList07 transaksiList = new SingleLinkedList07();

        // Contoh daftar kendaraan rental
        BarangRental07 br1 = new BarangRental07("S 4567 YV", "Honda Beat", "Motor", 2017, 10000);
        BarangRental07 br2 = new BarangRental07("N 4511 VS", "Honda Vario", "Motor", 2018, 10000);
        BarangRental07 br3 = new BarangRental07("N 1453 AA", "Toyota Yaris", "Mobil", 2022, 30000);
        BarangRental07 br4 = new BarangRental07("AB 4321 A", "Toyota Innova", "Mobil", 2019, 60000);
        BarangRental07 br5 = new BarangRental07("B 1234 AG", "Toyota Avanza", "Mobil", 2021, 25000);

        // Memasukkan kendaraan rental ke dalam linked list
        transaksiList.insert(br1);
        transaksiList.insert(br2);
        transaksiList.insert(br3);
        transaksiList.insert(br4);
        transaksiList.insert(br5);

        int pilihan;
        do {
            System.out.println("=========================================");
            System.out.println("                  MENU                   ");
            System.out.println("=========================================");
            System.out.println("1. Daftar Kendaraan");
            System.out.println("2. Peminjaman ");
            System.out.println("3. Tampilkan Seluruh Transaksi");
            System.out.println("4. Urutkan Transaksi Urut No TNKB");
            System.out.println("5. Keluar");
            System.out.println("=========================================");
            System.out.print("Pilih(1-5): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("--------------------------------------");
                    System.out.println("Daftar Kendaraan Rental Serba Serbi");
                    System.out.println("--------------------------------------");
                    System.out.println("1. " + br1.toString());
                    System.out.println("2. " + br2.toString());
                    System.out.println("3. " + br3.toString());
                    System.out.println("4. " + br4.toString());
                    System.out.println("5. " + br5.toString());
                    break;
                case 2:
                    // Peminjaman kendaraan
                    System.out.print("Masukkan nama peminjam: ");
                    String namaPeminjam = scanner.nextLine();

                    System.out.print("Masukkan No TNKB kendaraan yang dipinjam: ");
                    String noTNKB = scanner.nextLine();

                    System.out.print("Masukkan lama pinjam (hari): ");
                    int lamaPinjam = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Apakah peminjam adalah member? (true/false): ");
                    boolean isMember = scanner.nextBoolean();
                    scanner.nextLine();

                    // Cari barang rental berdasarkan No TNKB
                    Node07 nodeDipinjam = transaksiList.findNodeByNoTNKB(noTNKB);
                    if (nodeDipinjam != null && nodeDipinjam.data instanceof BarangRental07) {
                        BarangRental07 barangDipinjam = (BarangRental07) nodeDipinjam.data;

                        // Membuat objek TransaksiRental07
                        int kodeTransaksi = transaksiList.getSize() + 1; // Misalnya kode transaksi dihitung dari size+1
                        TransaksiRental07 transaksiBaru = new TransaksiRental07(kodeTransaksi, namaPeminjam, noTNKB,
                                lamaPinjam, isMember, barangDipinjam);

                        // Memasukkan transaksi ke dalam linked list
                        transaksiList.insert(transaksiBaru);
                        System.out.println("Peminjaman berhasil dicatat.");
                    } else {
                        System.out.println("Kendaraan dengan No TNKB tersebut tidak ditemukan.");
                    }
                    break;
                case 3:
                    // Menampilkan seluruh transaksi
                    System.out.println("=========================================");
                    System.out.println("         SELURUH TRANSAKSI RENTAL        ");
                    System.out.println("=========================================");
                    transaksiList.displayTransaksi();
                    break;
                case 4:
                    // Mengurutkan transaksi berdasarkan No TNKB
                    transaksiList.sortTransaksiByNoTNKB();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan layanan rental kami.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
                    break;
            }

            System.out.println();
        } while (pilihan != 5);

        scanner.close();
    }
}
