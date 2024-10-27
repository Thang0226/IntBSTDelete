import com.sun.source.tree.Tree;

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

    public boolean search(int value) {
        if (size == 0) {
            System.out.println("Tree is empty!");
            return false;
        }
        return getNode(value) != null;
    }

    private TreeNode getNode(int value) {
        TreeNode current = root;
        while (current != null) {
            if (value < current.key) {
                current = current.left;
            } else if (value > current.key) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    public boolean delete(int value) {
        if (size == 0) {
            System.out.println("Tree is empty!");
            return false;
        }
        TreeNode current = root;
        TreeNode parent = null;
        while (current != null) {
            if (value < current.key) {
                parent = current;
                current = current.left;
            } else if (value > current.key) {
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }
        if (current == null) {
            System.out.println(value + " is not in the tree.");
            return false;
        }

        if (current.left == null) {
            if (parent == null) {   // found node is root, root has not left child
                root = root.right;
                return true;
            }
            pointParentToRightChild(current, parent);
        } else {
            swapCurrentWithMostRightChild(current, parent);
        }
        size--;
        return true;
    }

    private void pointParentToRightChild(TreeNode current, TreeNode parent) {
        if (current == parent.left) {
            parent.left = current.right;
        } else {
            parent.right = current.right;
        }
    }

    private void swapCurrentWithMostRightChild(TreeNode current, TreeNode parent) {
        TreeNode mostRight = current.left;
        TreeNode mostRightParent = null;
        while (mostRight.right != null) {
            mostRightParent = mostRight;
            mostRight = mostRight.right;
        }
        if (parent == null) {   // found node is root
            root = mostRight;
        } else {
            if (current == parent.left) {
                parent.left = mostRight;
            } else {
                parent.right = mostRight;
            }
        }
        if (mostRightParent != null) {
            mostRightParent.right = mostRight.left;
            mostRight.left = current.left;
        }
        mostRight.right = current.right;
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
