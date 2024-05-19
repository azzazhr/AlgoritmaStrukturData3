package minggu13;

public class Antrian07 {
    Pelanggan07 pelanggan;
    Layanan07 layanan;
    Antrian07 next;
    Antrian07 prev;

    public Antrian07(Pelanggan07 pelanggan, Layanan07 layanan) {
        this.pelanggan = pelanggan;
        this.layanan = layanan;
        this.next = null;
        this.prev = null;
    }

}
