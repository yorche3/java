package data_structures_advanced;

public class TreeNode extends Node {

    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value) {
        super(value);
        this.left = null;
        this.right = null;
    }

    public TreeNode getLeft() {
        return this.left;
    }

    public TreeNode getRight() {
        return this.right;
    }

    public void setLeft(TreeNode node) {
        this.left = node;
    }

    public void setRight(TreeNode node) {
        this.right = node;
    }
}
