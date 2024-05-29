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
        gedung.removeEdge(1, 3);
        gedung.printGraph();
        System.out.println();

        while (true) {
            System.out.print("Masukkan gedung asal: ");
            int start = scanner.nextInt();
            if (start == -1)
                break;

            System.out.print("Masukkan gedung tujuan: ");
            int end = scanner.nextInt();

            boolean pathExists = gedung.isPathExists(start, end);
            if (pathExists) {
                System.out.println("Gedung " + (char) ('A' + start) + " dan " + (char) ('A' + end) + " bertetangga");
            } else {
                System.out.println(
                        "Gedung " + (char) ('A' + start) + " dan " + (char) ('A' + end) + " tidak bertetangga");
            }
        }

        scanner.close();
    }
}
