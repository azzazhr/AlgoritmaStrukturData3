package minggu14.Tugas;

public class BinaryTree07 {
    Node07 root;

    public BinaryTree07() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    Node07 addRecursive(Node07 root, int data) {
        if (root == null) {
            root = new Node07(data);
            return root;
        }
        if (data < root.data) {
            root.left = addRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = addRecursive(root.right, data);
        }
        return root;
    }

    void add(int data) {
        root = addRecursive(root, data);
    }

    void traversePreOrder(Node07 node) {
        if (node != null) {
            System.out.print(" " + node.data);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    void traversePostOrder(Node07 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.data);
        }
    }

    void traverseInOrder(Node07 node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.data);
            traverseInOrder(node.right);
        }
    }

    int cariMin() {
        if (isEmpty()) {
            System.out.println("Binary Tree kosong!");
            return -1;
        }
        Node07 current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    int cariMax() {
        if (isEmpty()) {
            System.out.println("Binary Tree kosong!");
            return -1;
        }
        Node07 current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    void leaf(Node07 node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
        }
        leaf(node.left);
        leaf(node.right);
    }

    int countLeaf(Node07 node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeaf(node.left) + countLeaf(node.right);
    }

}
