package data_structures_advanced;

public class BinaryTree {

    private TreeNode root;
    private int count;

    public BinaryTree() {
        this.root = null;
        this.count = 0;
    }

    public boolean insert(int value) {
        if (this.root == null) {
            this.root = new TreeNode(value);
            this.count++;
            return true;
        }
        TreeNode current = this.root;
        while (true) {
            int currentValue = current.getValue();
            if (value == currentValue) {
                return true;
            } else if (value < currentValue) {
                if (current.getLeft() == null) {
                    current.setLeft(new TreeNode(value));
                    this.count++;
                    return true;
                }
                current = current.getLeft();
            } else {
                if (current.getRight() == null) {
                    current.setRight(new TreeNode(value));
                    this.count++;
                    return true;
                }
                current = current.getRight();
            }
        }
    }

    public boolean contains(int value) {
        TreeNode current = this.root;
        while (current != null) {
            int currentValue = current.getValue();
            if (value == currentValue) {
                return true;
            } else if (value < currentValue) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public int size() {
        return this.count;
    }
}
