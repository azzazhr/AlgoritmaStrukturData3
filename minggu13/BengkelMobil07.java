package minggu13;

public class BengkelMobil07 {
    Antrian07 head;
    Antrian07 tail;

    public BengkelMobil07() {
        this.head = null;
        this.tail = null;
    }

    public void tambahAntrian(Pelanggan07 pelanggan, Layanan07 layanan) {
        Antrian07 newAntrian = new Antrian07(pelanggan, layanan);
        if (head == null) {
            head = newAntrian;
            tail = newAntrian;
        } else {
            tail.next = newAntrian;
            newAntrian.prev = tail;
            tail = newAntrian;
        }
        System.out.println("Antrian berhasil ditambahkan.");
    }

    public void cetakAntrian() {
        Antrian07 current = head;
        int counter = 1;
        while (current != null) {
            System.out.println("Nomor Antrian: " + counter);
            System.out.println("Nama Pelanggan: " + current.pelanggan.nama07);
            System.out.println("No. HP: " + current.pelanggan.noHp07);
            System.out.println("Layanan: " + current.layanan.namaLayanan07);
            System.out.println("===========================");
            current = current.next;
            counter++;
        }
    }

    public void hapusDanTambahLayanan(int nomorAntrian, Layanan07 newLayanan) {
        Antrian07 current = head;
        int counter = 1;
        while (current != null && counter < nomorAntrian) {
            current = current.next;
            counter++;
        }
        if (current != null) {
            current.layanan = newLayanan;
            System.out.println("Layanan pada antrian nomor " + nomorAntrian + " berhasil diubah.");
        } else {
            System.out.println("Antrian tidak ditemukan.");
        }
    }

    public int totalPemasukan() {
        Antrian07 current = head;
        int total = 0;
        while (current != null) {
            total += current.layanan.harga07;
            current = current.next;
        }
        return total;
    }
}
