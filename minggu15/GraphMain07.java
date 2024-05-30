package minggu15;

import java.util.Scanner;

public class GraphMain07 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Graph07 gedung = new Graph07(6);
        gedung.addEdge(0, 1, 50);
        gedung.addEdge(0, 2, 100);
        gedung.addEdge(1, 3, 70);
        gedung.addEdge(2, 3, 40);
        gedung.addEdge(3, 4, 60);
        gedung.addEdge(4, 5, 80);
        gedung.degree(0);
        gedung.printGraph();
        System.out.println();
        // gedung.removeEdge(1, 3);
        // gedung.printGraph();

        // Menambahkan pemanggilan metode hitungEdge
        int totalEdge = gedung.hitungEdge();
        System.out.println("Total Edge dalam Graf: " + totalEdge);

        boolean continueOperation = true;
        while (continueOperation) {
            System.out.println("=========================");
            System.out.println("           MENU          ");
            System.out.println("=========================");
            System.out.println("1. Add Edge");
            System.out.println("2. Remove Edge");
            System.out.println("3. Degree");
            System.out.println("4. Print Graph");
            System.out.println("5. Check Edge");
            System.out.println("6. Update Jarak");
            System.out.println("7. Exit");
            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    System.out.print("Masukkan asal: ");
                    int asal = scanner.nextInt();
                    System.out.print("Masukkan tujuan: ");
                    int tujuan = scanner.nextInt();
                    System.out.print("Masukkan jarak: ");
                    int jarak = scanner.nextInt();
                    gedung.addEdge(asal, tujuan, jarak);
                    System.out.println("Edge telah ditambahkan.");
                    break;
                case 2:
                    System.out.print("Masukkan asal edge yang akan dihapus: ");
                    int asalRemove = scanner.nextInt();
                    System.out.print("Masukkan tujuan edge yang akan dihapus: ");
                    int tujuanRemove = scanner.nextInt();
                    gedung.removeEdge(asalRemove, tujuanRemove);
                    System.out.println("Edge telah dihapus.");
                    break;
                case 3:
                    System.out.print("Masukkan vertex untuk menghitung degree: ");
                    int vertex = scanner.nextInt();
                    gedung.degree(vertex);
                    break;
                case 4:
                    gedung.printGraph();
                    break;
                case 5:
                    System.out.print("Masukkan asal vertex: ");
                    int asalEdge = scanner.nextInt();
                    System.out.print("Masukkan tujuan vertex: ");
                    int tujuanEdge = scanner.nextInt();
                    if (gedung.hasEdge(asalEdge, tujuanEdge)) {
                        System.out.println("Edge antara vertex " + asalEdge + " dan " + tujuanEdge + " ada.");
                    } else {
                        System.out.println("Edge antara vertex " + asalEdge + " dan " + tujuanEdge + " tidak ada.");
                    }
                    break;
                case 6:
                    System.out.print("Masukkan asal node: ");
                    int asalUpdate = scanner.nextInt();
                    System.out.print("Masukkan tujuan node: ");
                    int tujuanUpdate = scanner.nextInt();
                    System.out.print("Masukkan jarak baru: ");
                    int jarakUpdate = scanner.nextInt();
                    gedung.updateJarak(asalUpdate, tujuanUpdate, jarakUpdate);
                    System.out.println("Jarak antara node " + asalUpdate + " dan " + tujuanUpdate + " telah diupdate.");
                    break;
                case 7:
                    continueOperation = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
