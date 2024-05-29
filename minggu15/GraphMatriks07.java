package minggu15;

public class GraphMatriks07 {
    int vertex;
    int[][] matriks;

    public GraphMatriks07(int v) {
        vertex = v;
        matriks = new int[v][v];
    }

    public void makeEdge(int asal, int tujuan, int jarak) {
        matriks[asal][tujuan] = jarak;
    }

    public void removeEdge(int asal, int tujuan) {
        matriks[asal][tujuan] = 0;
    }

    public void printGraph() {
        for (int i = 0; i < vertex; i++) {
            System.out.print("\nGedung " + (char) ('A' + i) + ": ");
            for (int j = 0; j < vertex; j++) {
                System.out.print("gedung " + (char) ('A' + j) + " (" + matriks[i][j] + " m), ");
            }
        }
        System.out.println();
    }

    public int getDegree(int vertexIndex) {
        int degree = 0;
        for (int i = 0; i < vertex; i++) {
            if (matriks[vertexIndex][i] != 0) {
                degree++;
            }
        }
        return degree;
    }

    public int getInDegree(int v) {
        int inDegree = 0;
        for (int i = 0; i < vertex; i++) {
            if (matriks[i][v] != 0) {
                inDegree++;
            }
        }
        return inDegree;
    }

    public int getOutDegree(int v) {
        int outDegree = 0;
        for (int i = 0; i < vertex; i++) {
            if (matriks[v][i] != 0) {
                outDegree++;
            }
        }
        return outDegree;
    }

    public void printDegrees() {
        for (int i = 0; i < vertex; i++) {
            int degree = getDegree(i);
            int inDegree = getInDegree(i);
            int outDegree = getOutDegree(i);
            System.out.println("Vertex " + (char) ('A' + i) + ": Degree = " + degree + ": InDegree = " + inDegree
                    + ", OutDegree = " + outDegree);
        }
    }
}
