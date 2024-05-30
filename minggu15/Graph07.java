package minggu15;

import java.util.Stack;

public class Graph07 {
    int vertex;
    DoubleLinkedList07 list[];

    public Graph07(int v) {
        vertex = v;
        list = new DoubleLinkedList07[v];
        for (int i = 0; i < v; i++) {
            list[i] = new DoubleLinkedList07();
        }
    }

    public void addEdge(int asal, int tujuan, int jarak) {
        list[asal].addFirst(tujuan, jarak);
    }

    public void degree(int asal) throws Exception {
        int k, totalIn = 0, totalOut = 0;
        for (int i = 0; i < vertex; i++) {
            // inDegree
            for (int j = 0; j < list[i].size(); j++) {
                if (list[i].get(j) == asal) {
                    ++totalIn;
                }
            }
            // outDegree
            for (k = 0; k < list[asal].size(); k++) {
                list[asal].get(k);
            }
            totalOut = k;
        }
        System.out.println("InDegree dari Gedung " + (char) ('A' + asal) + ": " + totalIn);
        System.out.println("OutDegree dari Gedung " + (char) ('A' + asal) + ": " + totalOut);
        System.out.println("Degree dari Gedung " + (char) ('A' + asal) + ": " + (totalIn + totalOut));
    }

    public void removeEdge(int asal, int tujuan) {
        list[asal].remove(tujuan);
    }

    public void removeAllEdges() {
        for (int i = 0; i < vertex; i++) {
            list[i].clear();
        }
        System.out.println("Graf berhasil dikosongkan");
    }

    public void printGraph() throws Exception {
        for (int i = 0; i < vertex; i++) {
            if (list[i].size() > 0) {
                System.out.println("Gedung " + (char) ('A' + i) + " terhubung dengan");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print((char) ('A' + list[i].get(j)) + " (" + list[i].getJarak(j) + " m)");
                    if (j < list[i].size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println(); // Tambahkan baris baru di akhir untuk format yang rapi
            }
        }
    }

    public boolean isPathExists(int start, int end) throws Exception {
        boolean[] visited = new boolean[vertex];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (current == end) {
                return true;
            }

            if (!visited[current]) {
                visited[current] = true;

                for (int i = 0; i < list[current].size(); i++) {
                    int neighbor = list[current].get(i);
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        return false;
    }

    public boolean hasEdge(int asal, int tujuan) throws Exception {
        for (int i = 0; i < list[asal].size(); i++) {
            if (list[asal].get(i) == tujuan) {
                return true;
            }
        }
        return false;
    }

    public void updateJarak(int asal, int tujuan, int jarakBaru) {
        list[asal].updateJarak(asal, tujuan, jarakBaru);
        list[tujuan].updateJarak(asal, tujuan, jarakBaru);
    }

    public int hitungEdge() {
        int totalEdge = 0;
        for (int i = 0; i < vertex; i++) {
            totalEdge += list[i].size();
        }
        // Karena setiap edge dihitung dua kali (sebagai hubungan antara dua node),
        // harus membagi total edge dengan 2.
        return totalEdge / 2;
    }

}
