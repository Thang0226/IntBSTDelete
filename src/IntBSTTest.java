import java.util.Scanner;

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

        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter a number to search in the tree: ");
        int value = input.nextInt();
        if (tree.search(value)) {
            System.out.println(value + " is in the tree!");
        } else {
            System.out.println(value + " is NOT in the tree.");
        }
    }
}
