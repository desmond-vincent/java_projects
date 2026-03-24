package src;

/**
 * Represents a single node in the Binary Search Tree.
 * Each node contains a value and references to left and right children.
 */
public class BSTNode {
    public int value;
    public BSTNode left;
    public BSTNode right;

    /**
     * Constructor for BSTNode
     * @param value the integer value to store in this node
     */
    public BSTNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
