public class IntBST {
    protected TreeNode root;
    protected int size = 0;

    public IntBST() {
    }

    public IntBST(int[] numbers) {
        for (int number : numbers) {
            insert(number);
        }
    }

    public boolean insert(int number) {
        if (size == 0) {
            root = createNewNode(number);
        } else {
            TreeNode current = root;
            TreeNode parent = null;
            while (current != null) {
                if (number < current.key) {
                    parent = current;
                    current = current.left;
                } else if (number > current.key) {
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }
            assert parent != null;
            if (number < parent.key) {
                parent.left = createNewNode(number);
            } else {
                parent.right = createNewNode(number);
            }
        }
        size++;
        return true;
    }

    private TreeNode createNewNode(int number) {
        return new TreeNode(number);
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(TreeNode node) {
        if (node == null) return;
        System.out.print(" " + node.key);
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(" " + node.key);
        inorder(node.right);
    }

    public int getSize() {
        return size;
    }
}
