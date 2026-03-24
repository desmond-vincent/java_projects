package src;

import java.util.ArrayList;
import java.util.List;

/**
 * Complete Binary Search Tree implementation with insert, delete, search,
 * and three traversal methods (InOrder, PreOrder, PostOrder).
 * 
 * Time Complexities:
 * - Insert: O(log n) average, O(n) worst case
 * - Delete: O(log n) average, O(n) worst case
 * - Search: O(log n) average, O(n) worst case
 * - Traversals: O(n) for all three methods
 * - Space: O(n) for storing n nodes
 */
public class BinarySearchTree {
    private BSTNode root;

    /**
     * Constructor - initializes empty tree
     */
    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * Insert a value into the BST following BST rules
     * @param value the integer value to insert
     * @return true if inserted successfully, false if duplicate
     */
    public boolean insert(int value) {
        if (root == null) {
            root = new BSTNode(value);
            return true;
        }
        return insertRecursive(root, value);
    }

    /**
     * Helper method for recursive insertion
     * @param node current node in recursion
     * @param value value to insert
     * @return true if inserted, false if duplicate
     */
    private boolean insertRecursive(BSTNode node, int value) {
        if (value == node.value) {
            return false; // Duplicate not allowed
        }

        if (value < node.value) {
            if (node.left == null) {
                node.left = new BSTNode(value);
                return true;
            } else {
                return insertRecursive(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new BSTNode(value);
                return true;
            } else {
                return insertRecursive(node.right, value);
            }
        }
    }

    /**
     * Delete a node from the BST
     * Handles three cases: leaf node, one child, two children
     * @param value the value to delete
     * @return true if deleted successfully, false if not found
     */
    public boolean delete(int value) {
        if (root == null) {
            return false;
        }

        BSTDeleteResult result = deleteRecursive(root, value);
        root = result.node;
        return result.deleted;
    }

    /**
     * Helper class to hold deletion result (node and deleted status)
     */
    private static class BSTDeleteResult {
        BSTNode node;
        boolean deleted;

        BSTDeleteResult(BSTNode node, boolean deleted) {
            this.node = node;
            this.deleted = deleted;
        }
    }

    /**
     * Helper method for recursive deletion
     * @param node current node in recursion
     * @param value value to delete
     * @return BSTDeleteResult containing updated node and deletion status
     */
    private BSTDeleteResult deleteRecursive(BSTNode node, int value) {
        if (node == null) {
            return new BSTDeleteResult(null, false);
        }

        if (value < node.value) {
            BSTDeleteResult result = deleteRecursive(node.left, value);
            node.left = result.node;
            return new BSTDeleteResult(node, result.deleted);
        } else if (value > node.value) {
            BSTDeleteResult result = deleteRecursive(node.right, value);
            node.right = result.node;
            return new BSTDeleteResult(node, result.deleted);
        } else {
            // Node to delete found

            // Case 1: Leaf node
            if (node.left == null && node.right == null) {
                return new BSTDeleteResult(null, true);
            }

            // Case 2: Node with only right child
            if (node.left == null) {
                return new BSTDeleteResult(node.right, true);
            }

            // Case 3: Node with only left child
            if (node.right == null) {
                return new BSTDeleteResult(node.left, true);
            }

            // Case 4: Node with two children (use in-order successor)
            BSTNode successor = findMin(node.right);
            node.value = successor.value;

            BSTDeleteResult result = deleteRecursive(node.right, successor.value);
            node.right = result.node;
            return new BSTDeleteResult(node, true);
        }
    }

    /**
     * Find the node with minimum value in subtree
     * @param node the root of subtree
     * @return the node with minimum value
     */
    private BSTNode findMin(BSTNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * Search for a value in the tree
     * @param value the value to search for
     * @return true if found, false otherwise
     */
    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    /**
     * Helper method for recursive search
     * @param node current node in recursion
     * @param value value to search for
     * @return true if found, false otherwise
     */
    private boolean searchRecursive(BSTNode node, int value) {
        if (node == null) {
            return false;
        }

        if (value == node.value) {
            return true;
        } else if (value < node.value) {
            return searchRecursive(node.left, value);
        } else {
            return searchRecursive(node.right, value);
        }
    }

    /**
     * InOrder Traversal: Left → Root → Right
     * Produces sorted sequence of values
     * @return List of values in inorder sequence
     */
    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderRecursive(root, result);
        return result;
    }

    /**
     * Helper method for inorder traversal
     */
    private void inorderRecursive(BSTNode node, List<Integer> result) {
        if (node != null) {
            inorderRecursive(node.left, result);
            result.add(node.value);
            inorderRecursive(node.right, result);
        }
    }

    /**
     * PreOrder Traversal: Root → Left → Right
     * Useful for copying tree structure
     * @return List of values in preorder sequence
     */
    public List<Integer> preorderTraversal() {
        List<Integer> result = new ArrayList<>();
        preorderRecursive(root, result);
        return result;
    }

    /**
     * Helper method for preorder traversal
     */
    private void preorderRecursive(BSTNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.value);
            preorderRecursive(node.left, result);
            preorderRecursive(node.right, result);
        }
    }

    /**
     * PostOrder Traversal: Left → Right → Root
     * Useful for deletion operations
     * @return List of values in postorder sequence
     */
    public List<Integer> postorderTraversal() {
        List<Integer> result = new ArrayList<>();
        postorderRecursive(root, result);
        return result;
    }

    /**
     * Helper method for postorder traversal
     */
    private void postorderRecursive(BSTNode node, List<Integer> result) {
        if (node != null) {
            postorderRecursive(node.left, result);
            postorderRecursive(node.right, result);
            result.add(node.value);
        }
    }

    /**
     * Check if tree is empty
     * @return true if tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Calculate the height of the tree
     * Height is the longest path from root to leaf
     * @return height of tree (-1 if empty)
     */
    public int height() {
        return heightRecursive(root);
    }

    /**
     * Helper method for recursive height calculation
     */
    private int heightRecursive(BSTNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(heightRecursive(node.left), heightRecursive(node.right));
    }

    /**
     * Get the root node (for visualization)
     * @return the root node
     */
    public BSTNode getRoot() {
        return root;
    }

    /**
     * Clear the tree
     */
    public void clear() {
        root = null;
    }

    /**
     * Get total number of nodes in tree
     * @return number of nodes
     */
    public int size() {
        return inorderTraversal().size();
    }
}
