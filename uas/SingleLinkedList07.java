package uas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SingleLinkedList07 {
    private Node07 head;
    private int size;

    public SingleLinkedList07() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(Object data) {
        Node07 newNode = new Node07(data, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node07 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void displayTransaksi() {
        Node07 current = head;
        while (current != null) {
            if (current.data instanceof TransaksiRental07) {
                System.out.println(current.data.toString());
                System.out.println("--------------------------------------");
            }
            current = current.next;
        }
    }

    public void sortTransaksiByNoTNKB() {
        List<TransaksiRental07> transaksiList = new ArrayList<>();
        Node07 current = head;
        while (current != null) {
            if (current.data instanceof TransaksiRental07) {
                transaksiList.add((TransaksiRental07) current.data);
            }
            current = current.next;
        }

        Collections.sort(transaksiList, Comparator.comparing(tr -> tr.noTNKB));

        System.out.println("Transaksi setelah diurutkan berdasarkan No TNKB:");
        for (TransaksiRental07 transaksi : transaksiList) {
            System.out.println(transaksi.toString());
            System.out.println("--------------------------------------");
        }
    }

    public void sortTransaksiSpecial() {
        List<TransaksiRental07> transaksiList = new ArrayList<>();
        Node07 current = head;
        while (current != null) {
            if (current.data instanceof TransaksiRental07) {
                transaksiList.add((TransaksiRental07) current.data);
            }
            current = current.next;
        }

        // Membuat dua Comparator berdasarkan kriteria yang diminta
        Comparator<TransaksiRental07> comparatorAM = (tr1, tr2) -> {
            // Mendapatkan huruf pertama dari nama lengkap untuk transaksi 1 dan 2
            char firstChar1 = tr1.barangRental.namaKendaraan.charAt(0);
            char firstChar2 = tr2.barangRental.namaKendaraan.charAt(0);

            // Membandingkan dan mengurutkan secara descending
            return Character.compare(firstChar2, firstChar1);
        };

        Comparator<TransaksiRental07> comparatorNZ = (tr1, tr2) -> {
            // Mendapatkan huruf pertama dari nama lengkap untuk transaksi 1 dan 2
            char firstChar1 = tr1.barangRental.namaKendaraan.charAt(0);
            char firstChar2 = tr2.barangRental.namaKendaraan.charAt(0);

            // Membandingkan dan mengurutkan secara descending
            return Character.compare(firstChar2, firstChar1);
        };

        // Menggabungkan kedua Comparator dengan reversed() untuk descending order
        Comparator<TransaksiRental07> combinedComparator = comparatorAM
                .thenComparing(comparatorNZ.reversed());

        // Menggunakan Comparator yang sudah di-gabungkan untuk melakukan sorting
        Collections.sort(transaksiList, combinedComparator);

        System.out.println("Transaksi setelah diurutkan secara spesial:");
        for (TransaksiRental07 transaksi : transaksiList) {
            System.out.println(transaksi.toString());
            System.out.println("--------------------------------------");
        }
    }

    public int getSize() {
        return size;
    }

    public Node07 getHead() {
        return head;
    }

    public Node07 findNodeByNoTNKB(String noTNKB) {
        Node07 current = head;
        while (current != null) {
            if (current.data instanceof BarangRental07) {
                BarangRental07 br = (BarangRental07) current.data;
                if (br.noTNKB.equals(noTNKB)) {
                    return current;
                }
            }
            current = current.next;
        }
        return null; // Jika tidak ditemukan
    }
}