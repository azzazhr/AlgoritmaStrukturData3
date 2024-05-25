package minggu14.Tugas;

public class MainBinaryTree07 {
    public static void main(String[] args) {
        BinaryTree07 bt = new BinaryTree07();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        System.out.print("Preorder Traversal: ");
        bt.traversePreOrder(bt.root);
        System.out.println("");
        System.out.print("InOrder Traversal: ");
        bt.traverseInOrder(bt.root);
        System.out.println("");
        System.out.print("PostOrder Traversal: ");
        bt.traversePostOrder(bt.root);
        System.out.println("");
        System.out.println("Nilai Terkecil dalam Binary Tree: " + bt.cariMin());
        System.out.println("Nilai Terbesar dalam Binary Tree: " + bt.cariMax());
        System.out.print("Data yang merupakan Leaf: ");
        bt.leaf(bt.root);
        System.out.println("");
        System.out.println("Jumlah Leaf yang ada dalam Binary Tree: " + bt.countLeaf(bt.root));
    }
}
