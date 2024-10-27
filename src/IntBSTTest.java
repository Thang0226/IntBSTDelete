public class IntBSTTest {
    public static void main(String[] args) {
        int[] numbers = {27, 14, 35};
        IntBST tree = new IntBST(numbers);
        tree.insert(10);
        tree.insert(19);
        tree.insert(31);
        tree.insert(42);

        System.out.println("Pre-order traverse:");
        tree.preorder();
        System.out.println("\nIn-order traverse:");
        tree.inorder();
    }
}
