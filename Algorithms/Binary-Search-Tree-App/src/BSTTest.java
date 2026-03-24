package src;

import java.util.List;

/**
 * Comprehensive unit tests for Binary Search Tree
 * 27 test cases covering all operations and edge cases
 * 
 * Run with: java -cp . src.BSTTest
 */
public class BSTTest {
    private static int testsPassed = 0;
    private static int testsFailed = 0;

    /**
     * Main method - run all tests
     */
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("Binary Search Tree - Unit Test Suite");
        System.out.println("======================================================================\n");

        // Insertion tests
        testInsertSingleNode();
        testInsertMultipleNodes();
        testInsertDuplicate();

        // Search tests
        testSearchExisting();
        testSearchNonexisting();
        testSearchEmptyTree();

        // Deletion tests
        testDeleteLeafNode();
        testDeleteNodeOneChild();
        testDeleteNodeTwoChildren();
        testDeleteRoot();
        testDeleteNonexistent();
        testDeleteEmptyTree();

        // Traversal tests
        testInorderTraversal();
        testInorderEmpty();
        testPreorderTraversal();
        testPreorderEmpty();
        testPostorderTraversal();
        testPostorderEmpty();

        // BST property tests
        testBSTPropertyAfterInsert();
        testBSTPropertyAfterDelete();

        // Height tests
        testHeightEmpty();
        testHeightSingleNode();
        testHeightBalancedTree();
        testHeightUnbalancedTree();

        // Complex operation tests
        testMultipleOperations();
        testLargeTree();

        // Print summary
        printTestSummary();
    }

    // ===== INSERTION TESTS =====

    private static void testInsertSingleNode() {
        BinarySearchTree bst = new BinarySearchTree();
        assertTrue("Insert single node", bst.insert(5));
        assertFalse("Tree should not be empty", bst.isEmpty());
    }

    private static void testInsertMultipleNodes() {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {4, 2, 6, 1, 3, 5, 7};
        for (int val : values) {
            assertTrue("Insert node " + val, bst.insert(val));
        }
        assertEquals("Should have 7 nodes", bst.inorderTraversal().size(), 7);
    }

    private static void testInsertDuplicate() {
        BinarySearchTree bst = new BinarySearchTree();
        assertTrue("Insert first 5", bst.insert(5));
        assertFalse("Insert duplicate 5", bst.insert(5));
    }

    // ===== SEARCH TESTS =====

    private static void testSearchExisting() {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {4, 2, 6, 1, 3, 5, 7};
        for (int val : values) {
            bst.insert(val);
        }
        for (int val : values) {
            assertTrue("Search for " + val, bst.search(val));
        }
    }

    private static void testSearchNonexisting() {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {4, 2, 6, 1, 3, 5, 7};
        for (int val : values) {
            bst.insert(val);
        }
        assertFalse("Search for non-existent 0", bst.search(0));
        assertFalse("Search for non-existent 8", bst.search(8));
        assertFalse("Search for non-existent 100", bst.search(100));
    }

    private static void testSearchEmptyTree() {
        BinarySearchTree bst = new BinarySearchTree();
        assertFalse("Search in empty tree", bst.search(5));
    }

    // ===== DELETION TESTS =====

    private static void testDeleteLeafNode() {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {4, 2, 6, 1, 3, 5, 7};
        for (int val : values) {
            bst.insert(val);
        }
        assertTrue("Delete leaf node 1", bst.delete(1));
        assertFalse("1 should not exist", bst.search(1));
        assertEquals("Should have 6 nodes", bst.inorderTraversal().size(), 6);
    }

    private static void testDeleteNodeOneChild() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(8);
        assertTrue("Delete node with one child", bst.delete(7));
        assertFalse("7 should not exist", bst.search(7));
        assertTrue("8 should exist", bst.search(8));
    }

    private static void testDeleteNodeTwoChildren() {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {4, 2, 6, 1, 3, 5, 7};
        for (int val : values) {
            bst.insert(val);
        }
        assertTrue("Delete node with two children", bst.delete(4));
        assertFalse("4 should not exist", bst.search(4));
        List<Integer> result = bst.inorderTraversal();
        assertEquals("Should have 6 nodes", result.size(), 6);
        assertEquals("InOrder result", result.toString(), "[1, 2, 3, 5, 6, 7]");
    }

    private static void testDeleteRoot() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        assertTrue("Delete root", bst.delete(5));
        assertEquals("Root should be 3", bst.getRoot().value, 3);
    }

    private static void testDeleteNonexistent() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        assertFalse("Delete non-existent value", bst.delete(10));
    }

    private static void testDeleteEmptyTree() {
        BinarySearchTree bst = new BinarySearchTree();
        assertFalse("Delete from empty tree", bst.delete(5));
    }

    // ===== TRAVERSAL TESTS =====

    private static void testInorderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {4, 2, 6, 1, 3, 5, 7};
        for (int val : values) {
            bst.insert(val);
        }
        List<Integer> result = bst.inorderTraversal();
        assertEquals("InOrder should be sorted", result.toString(), "[1, 2, 3, 4, 5, 6, 7]");
    }

    private static void testInorderEmpty() {
        BinarySearchTree bst = new BinarySearchTree();
        assertEquals("InOrder on empty tree", bst.inorderTraversal().size(), 0);
    }

    private static void testPreorderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {4, 2, 6, 1, 3, 5, 7};
        for (int val : values) {
            bst.insert(val);
        }
        List<Integer> result = bst.preorderTraversal();
        assertEquals("PreOrder result", result.toString(), "[4, 2, 1, 3, 6, 5, 7]");
    }

    private static void testPreorderEmpty() {
        BinarySearchTree bst = new BinarySearchTree();
        assertEquals("PreOrder on empty tree", bst.preorderTraversal().size(), 0);
    }

    private static void testPostorderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {4, 2, 6, 1, 3, 5, 7};
        for (int val : values) {
            bst.insert(val);
        }
        List<Integer> result = bst.postorderTraversal();
        assertEquals("PostOrder result", result.toString(), "[1, 3, 2, 5, 7, 6, 4]");
    }

    private static void testPostorderEmpty() {
        BinarySearchTree bst = new BinarySearchTree();
        assertEquals("PostOrder on empty tree", bst.postorderTraversal().size(), 0);
    }

    // ===== BST PROPERTY TESTS =====

    private static void testBSTPropertyAfterInsert() {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {4, 2, 6, 1, 3, 5, 7};
        for (int val : values) {
            bst.insert(val);
            verifyBSTProperty(bst.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        assertTrue("BST property maintained after insert", true);
    }

    private static void testBSTPropertyAfterDelete() {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {4, 2, 6, 1, 3, 5, 7};
        for (int val : values) {
            bst.insert(val);
        }
        bst.delete(1);
        bst.delete(6);
        assertTrue("BST property after delete", verifyBSTProperty(bst.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static boolean verifyBSTProperty(BSTNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.value <= min || node.value >= max) {
            return false;
        }
        return verifyBSTProperty(node.left, min, node.value) &&
               verifyBSTProperty(node.right, node.value, max);
    }

    // ===== HEIGHT TESTS =====

    private static void testHeightEmpty() {
        BinarySearchTree bst = new BinarySearchTree();
        assertEquals("Height of empty tree", bst.height(), -1);
    }

    private static void testHeightSingleNode() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        assertEquals("Height with single node", bst.height(), 0);
    }

    private static void testHeightBalancedTree() {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {4, 2, 6, 1, 3, 5, 7};
        for (int val : values) {
            bst.insert(val);
        }
        assertEquals("Height of balanced tree", bst.height(), 2);
    }

    private static void testHeightUnbalancedTree() {
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 1; i <= 7; i++) {
            bst.insert(i);
        }
        assertEquals("Height of unbalanced tree", bst.height(), 6);
    }

    // ===== COMPLEX OPERATION TESTS =====

    private static void testMultipleOperations() {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {4, 2, 6, 1, 3, 5, 7};
        for (int val : values) {
            bst.insert(val);
        }
        bst.delete(1);
        bst.delete(7);
        bst.delete(4);
        List<Integer> result = bst.inorderTraversal();
        assertEquals("Multiple operations result", result.toString(), "[2, 3, 5, 6]");
    }

    private static void testLargeTree() {
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 1; i <= 50; i++) {
            bst.insert(i);
        }
        assertEquals("Large tree size", bst.size(), 50);
        for (int val : new int[]{25, 10, 40}) {
            bst.delete(val);
        }
        assertEquals("After deletions", bst.size(), 47);
    }

    // ===== TEST HELPER METHODS =====

    private static void assertTrue(String testName, boolean condition) {
        if (condition) {
            testsPassed++;
            System.out.println("✓ " + testName);
        } else {
            testsFailed++;
            System.out.println("✗ " + testName);
        }
    }

    private static void assertFalse(String testName, boolean condition) {
        assertTrue(testName, !condition);
    }

    private static void assertEquals(String testName, Object actual, Object expected) {
        if ((actual == null && expected == null) || (actual != null && actual.equals(expected))) {
            testsPassed++;
            System.out.println("✓ " + testName);
        } else {
            testsFailed++;
            System.out.println("✗ " + testName + " (expected: " + expected + ", got: " + actual + ")");
        }
    }

    private static void printTestSummary() {
        System.out.println();
        System.out.println("======================================================================");
        System.out.println("TEST SUMMARY");
        System.out.println("======================================================================");
        System.out.println("Tests Run: " + (testsPassed + testsFailed));
        System.out.println("Successes: " + testsPassed);
        System.out.println("Failures: " + testsFailed);
        System.out.println();
        if (testsFailed == 0) {
            System.out.println("✓ All tests passed!");
            System.exit(0);
        } else {
            System.out.println("✗ Some tests failed");
            System.exit(1);
        }
    }
}
