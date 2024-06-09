package minggu16.Tugas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Nilai07 {
    String kodeN;
    Mahasiswa07 mhs;
    MataKuliah07 mk;
    double nilai;

    public Nilai07(String kodeN, double nilai, Mahasiswa07 mhs, MataKuliah07 mk) {
        this.kodeN = kodeN;
        this.mhs = mhs;
        this.mk = mk;
        this.nilai = nilai;
    }

    List<Mahasiswa07> mhsA = new ArrayList<>();
    List<MataKuliah07> matkulE = new ArrayList<>();
    Queue<Mahasiswa07> deletionQueue = new LinkedList<>();

    public void tambahMhs(Mahasiswa07... mahasiswa) {
        mhsA.addAll(Arrays.asList(mahasiswa));
    }

    public void tambahMatkul(MataKuliah07... matkul) {
        matkulE.addAll(Arrays.asList(matkul));
    }

    public void tampilMhs() {
        System.out.printf("%-10s %-20s %-10s\n", "NIM", "Nama", "No Telp");
        mhsA.stream().forEach(mhs -> {
            System.out.printf("%-10s %-20s %-10s\n", mhs.nim, mhs.nama, mhs.telepon);
        });
    }

    public void tampilMatkul() {
        System.out.printf("%-10s %-50s %-5s\n", "Kode", "Mata Kuliah", "SKS");
        matkulE.stream().forEach(mk -> {
            System.out.printf("%-10s %-50s %-5d\n", mk.kode, mk.namaMk, mk.sks);
        });
    }

    int linearSearchMhs(String nim) {
        for (int i = 0; i < mhsA.size(); i++) {
            if (nim.equals(mhsA.get(i).nim)) {
                return i;
            }
        }
        return -1;
    }

    int linearSearchMatkul(String matkul) {
        for (int i = 0; i < matkulE.size(); i++) {
            if (matkul.equals(matkulE.get(i).kode)) {
                return i;
            }
        }
        return -1;
    }

    Mahasiswa07 cariMhs(String nim) {
        for (int i = 0; i < mhsA.size(); i++) {
            if (nim.equals(mhsA.get(i).nim)) {
                return mhsA.get(i);
            }
        }
        return null;
    }

    MataKuliah07 cariMatkul(String matkul) {
        for (int i = 0; i < matkulE.size(); i++) {
            if (matkul.equals(matkulE.get(i).kode)) {
                return matkulE.get(i);
            }
        }
        return null;
    }

    public String toString(int idx1, int idx2) {
        return String.format("%-10s %-20s %-30s %-5d", mhsA.get(idx1).nim, mhsA.get(idx1).nama,
                matkulE.get(idx2).namaMk, matkulE.get(idx2).sks);
    }

    static Comparator<Nilai07> compNilai = (n1, n2) -> {
        if (n1.nilai < n2.nilai) {
            return -1;
        } else if (n1.nilai > (n2).nilai) {
            return 1;
        } else {
            return 0;
        }
    };

    public void enqueueDeletion(Mahasiswa07 mhs) {
        deletionQueue.add(mhs);
    }

    public void processDeletion() {
        while (!deletionQueue.isEmpty()) {
            Mahasiswa07 mhsToDelete = deletionQueue.poll();
            mhsA.remove(mhsToDelete);
            System.out.println("Mahasiswa dengan NIM " + mhsToDelete.nim + " telah dihapus.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner se = new Scanner(System.in);
        Scanner sb = new Scanner(System.in);

        List<Nilai07> noll = new ArrayList<>();
        Nilai07 n = new Nilai07("", 0, null, null);

        Mahasiswa07 m1 = new Mahasiswa07("20001", "Thalhah", "021xxx");
        Mahasiswa07 m2 = new Mahasiswa07("20002", "Zubair", "021xxx");
        Mahasiswa07 m3 = new Mahasiswa07("20003", "Abdur-Rahman", "021xxx");
        Mahasiswa07 m4 = new Mahasiswa07("20004", "Sa'ad", "021xxx");
        Mahasiswa07 m5 = new Mahasiswa07("20005", "Said", "021xxx");
        Mahasiswa07 m6 = new Mahasiswa07("20006", "Ubaidah", "021xxx");

        n.tambahMhs(m1, m2, m3, m4, m5, m6);

        MataKuliah07 mk1 = new MataKuliah07("00001", "Internet of Things", 3);
        MataKuliah07 mk2 = new MataKuliah07("00002", "Algoritma dan Struktur Data", 2);
        MataKuliah07 mk3 = new MataKuliah07("00003", "Algoritma dan Pemrograman", 2);
        MataKuliah07 mk4 = new MataKuliah07("00004", "Praktikum Algoritma dan Struktur Data", 3);
        MataKuliah07 mk5 = new MataKuliah07("00005", "Praktikum Algoritma dan Pemrograman", 3);

        n.tambahMatkul(mk1, mk2, mk3, mk4, mk5);

        Nilai07 n1 = null;
        String nimMhs, mkMhs;

        int menu;
        do {
            System.out.println("===============================================");
            System.out.println("Sistem Pengolahan Data Nilai Mahasiswa Semester");
            System.out.println("===============================================");
            System.out.println("1. Input Nilai");
            System.out.println("2. Tampil Nilai");
            System.out.println("3. Mencari Nilai Mahasiswa");
            System.out.println("4. Urut Data Nilai");
            System.out.println("5. Hapus Data Mahasiswa");
            System.out.println("6. Keluar");
            System.out.println("===============================================");
            System.out.print("Masukkan Pilihan Menu : ");
            menu = se.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("=======================================");
                    System.out.print("Kode\t: ");
                    String kd = sc.nextLine();
                    System.out.print("Nilai\t: ");
                    double nilMhs = sb.nextDouble();
                    System.out.println("");

                    System.out.println("========================================");
                    System.out.println("             Daftar Mahasiswa           ");
                    System.out.println("========================================");
                    n.tampilMhs();
                    System.out.println("----------------------------------------");
                    System.out.print("Pilih Mahasiswa by NIM : ");
                    nimMhs = sc.nextLine();
                    Mahasiswa07 mhaSiswas;
                    mhaSiswas = n.cariMhs(nimMhs);

                    System.out.println("========================================");
                    System.out.println("            Daftar Mata Kuliah          ");
                    System.out.println("========================================");
                    n.tampilMatkul();
                    System.out.println("----------------------------------------");
                    System.out.print("Pilih Mata Kuliah by Kode : ");
                    mkMhs = sc.nextLine();
                    MataKuliah07 mtKuliah;
                    mtKuliah = n.cariMatkul(mkMhs);

                    n1 = new Nilai07(kd, nilMhs, mhaSiswas, mtKuliah);

                    noll.add(n1);
                    System.out.println("");
                    break;

                case 2:
                    System.out.println("========================================");
                    System.out.println("             Daftar Mahasiswa           ");
                    System.out.println("========================================");
                    System.out.println("NIM         Nama\t\tMata Kuliah                   SKS  Nilai");
                    for (int i = 0; i < noll.size(); i++) {
                        n.linearSearchMhs(noll.get(i).mk.kode);
                        System.out.println(n.toString(n.linearSearchMhs(noll.get(i).mhs.nim),
                                n.linearSearchMatkul(noll.get(i).mk.kode)) + noll.get(i).nilai);
                    }
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("========================================");
                    System.out.println("             Daftar Mahasiswa           ");
                    System.out.println("========================================");
                    System.out.println("NIM         Nama\t\tMata Kuliah                   SKS  Nilai");
                    int sks = 0;
                    for (int i = 0; i < noll.size(); i++) {
                        n.linearSearchMhs(noll.get(i).mhs.nim);
                        n.linearSearchMatkul(noll.get(i).mk.kode);
                        System.out.println(n.toString(n.linearSearchMhs(noll.get(i).mhs.nim),
                                n.linearSearchMatkul(noll.get(i).mk.kode)) + noll.get(i).nilai);
                    }
                    System.out.println("----------------------------------------");
                    System.out.print("Masukkan Data Mahasiswa NIM : ");
                    String input = sc.nextLine();
                    System.out.println("");
                    System.out.println("----------------------------------------");
                    for (int i = 0; i < noll.size(); i++) {
                        if (input.equalsIgnoreCase(noll.get(i).mhs.nim)) {
                            sks += n.matkulE.get(i).sks;
                            n.linearSearchMhs(noll.get(i).mhs.nim);
                            n.linearSearchMatkul(noll.get(i).mk.kode);
                            System.out.println(n.toString(n.linearSearchMhs(noll.get(i).mhs.nim),
                                    n.linearSearchMatkul(noll.get(i).mk.kode)) + noll.get(i).nilai);
                        }
                    }
                    System.out.println("Total SKS " + sks + " Telah Diambil");
                    System.out.println("");
                    break;

                case 4:
                    System.out.println("========================================");
                    System.out.println("             Daftar Mahasiswa           ");
                    System.out.println("========================================");
                    System.out.println("NIM         Nama\t\tMata Kuliah                   SKS  Nilai");
                    noll.sort(compNilai);
                    for (int i = 0; i < noll.size(); i++) {
                        n.linearSearchMhs(noll.get(i).mhs.nim);
                        n.linearSearchMatkul(noll.get(i).mk.kode);
                        System.out.println(n.toString(n.linearSearchMhs(noll.get(i).mhs.nim),
                                n.linearSearchMatkul(noll.get(i).mk.kode)) + noll.get(i).nilai);
                    }
                    System.out.println("");
                    break;

                case 5:
                    System.out.println("========================================");
                    System.out.println("           Hapus Data Mahasiswa         ");
                    System.out.println("========================================");
                    System.out.println("Daftar Mahasiswa:");
                    n.tampilMhs();
                    System.out.println("----------------------------------------");
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                    String nimToDelete = sc.nextLine();
                    Mahasiswa07 mhsToDelete = n.cariMhs(nimToDelete);
                    if (mhsToDelete != null) {
                        n.enqueueDeletion(mhsToDelete);
                        System.out.println("Data mahasiswa dengan NIM " + nimToDelete
                                + " telah berhasil di hapus.");
                    } else {
                        System.out.println("Mahasiswa dengan NIM " + nimToDelete + " tidak ditemukan.");
                    }
                    System.out.println("");
                    break;
                case 6:
                    System.out.println("+=====================================+");
                    System.out.println("+             Terima Kasih            +");
                    System.out.println("+=====================================+");
                    break;

            }
        } while (menu < 5 && menu > 0);
    }
}
