package minggu14.Tugas;

public class BinaryTreeArray07 {
    int[] array;
    int idxLast = -1;

    public BinaryTreeArray07() {
        array = new int[15];
    }

    void populateData(int data[], int idxLast) {
        array = data;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            traverseInOrder(2 * idxStart + 1);
            System.out.print(array[idxStart] + " ");
            traverseInOrder(2 * idxStart + 2);
        }
    }

    void traversePreOrder(int idxStart) {
        if (idxStart <= idxLast) {
            System.out.print(array[idxStart] + " ");
            traversePreOrder(2 * idxStart + 1);
            traversePreOrder(2 * idxStart + 2);
        }
    }

    void traversePostOrder(int idxStart) {
        if (idxStart <= idxLast) {
            traversePostOrder(2 * idxStart + 1);
            traversePostOrder(2 * idxStart + 2);
            System.out.print(array[idxStart] + " ");
        }
    }

    void add(int data) {
        if (idxLast == array.length - 1) {
            System.out.println("Binary Tree penuh!");
        } else if (idxLast == -1) {
            array[++idxLast] = data;
        } else {
            int root = 0;
            while (true) {
                if (data <= array[root]) {
                    int leftChild = 2 * root + 1;
                    if (array[leftChild] == 0) {
                        array[leftChild] = data;
                        if (leftChild > idxLast) {
                            idxLast = leftChild;
                        }
                        break;
                    } else {
                        root = leftChild;
                    }
                } else {
                    int rightChild = 2 * root + 2;
                    if (array[rightChild] == 0) {
                        array[rightChild] = data;
                        if (rightChild > idxLast) {
                            idxLast = rightChild;
                        }
                        break;
                    } else {
                        root = rightChild;
                    }
                }
            }
        }
    }
}
