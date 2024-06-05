package minggu16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListMahasiswa07 {

    List<Mahasiswa07> mahasiswas = new ArrayList<>();

    public void tambah(Mahasiswa07... mahasiswa) {
        mahasiswas.addAll(Arrays.asList(mahasiswa));
    }

    public void hapus(int index) {
        mahasiswas.remove(index);
    }

    public void update(int index, Mahasiswa07 mhs) {
        mahasiswas.set(index, mhs);
    }

    public void tampil() {
        mahasiswas.stream().forEach(mhs -> {
            System.out.println("" + mhs.toString());
        });
    }

    int linearSearch(String nim) {
        for (int i = 0; i < mahasiswas.size(); i++) {
            if (nim.equals(mahasiswas.get(i).nim)) {
                return i;
            }
        }
        return -1;
    }

    int binarySearch(String nim) {
        return Collections.binarySearch(mahasiswas, new Mahasiswa07(nim, null, null), new Comparator<Mahasiswa07>() {
            @Override
            public int compare(Mahasiswa07 o1, Mahasiswa07 o2) {
                return o1.nim.compareTo(o2.nim);
            }
        });
    }

    public void ascSort() {
        Collections.sort(mahasiswas, new Comparator<Mahasiswa07>() {
            @Override
            public int compare(Mahasiswa07 o1, Mahasiswa07 o2) {
                return o1.nim.compareTo(o2.nim);
            }
        });
    }

    public void dscSort() {
        Collections.sort(mahasiswas, new Comparator<Mahasiswa07>() {
            @Override
            public int compare(Mahasiswa07 o1, Mahasiswa07 o2) {
                return o2.nim.compareTo(o1.nim);
            }
        });
    }

    public static void main(String[] args) {
        ListMahasiswa07 lm = new ListMahasiswa07();
        Mahasiswa07 m = new Mahasiswa07("201234", "Noureen", "021xx1");
        Mahasiswa07 m1 = new Mahasiswa07("201235", "Akhleema", "021xx2");
        Mahasiswa07 m2 = new Mahasiswa07("201236", "Shannum", "021xx3");

        lm.tambah(m, m1, m2);
        lm.tampil();
        System.out.println();
        System.out.print("Menggunakan Linear Search :");
        lm.update(lm.linearSearch("201235"), new Mahasiswa07("201235", "Akhleema Lela", "021xx2"));
        System.out.println("");
        lm.tampil();
        System.out.println();
        System.out.print("Menggunakan Binary Search : ");
        lm.update(lm.binarySearch("201235"), new Mahasiswa07("201235", "Akhleema Lela", "021xx2"));
        System.out.println("");
        lm.tampil();
        System.out.println();
        System.out.println("Data Diurutkan Secara Ascending Collections : ");
        lm.ascSort();
        lm.tampil();
        System.out.println();
        System.out.println("Data Diurutkan Secara Descending Collections : ");
        lm.dscSort();
        lm.tampil();
    }
}
