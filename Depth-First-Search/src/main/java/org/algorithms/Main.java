package org.algorithms;

public class Main {
    static void main() {

        // Test Case 1: Balanced tree
        ListNode test1 = new ListNode(1);
        test1.left = new ListNode(2);
        test1.right = new ListNode(3);
        test1.left.left = new ListNode(4);
        test1.left.right = new ListNode(5);

        IO.println("Test 1 - Balanced Tree:");
        IO.println("       1");
        IO.println("      / \\");
        IO.println("     2   3");
        IO.println("    / \\");
        IO.println("   4   5");
        IO.println("Expected: 3");
        IO.println("Actual: " + ListNode.max(test1));
        IO.println();

        // Test Case 2: Single node
        ListNode test2 = new ListNode(1);

        IO.println("Test 2 - Single Node:");
        IO.println("   1");
        IO.println("Expected: 1");
        IO.println("Actual: " + ListNode.max(test2));
        IO.println();

        // Test Case 3: Empty tree
        ListNode test3 = null;

        IO.println("Test 3 - Empty Tree:");
        IO.println("Expected: 0");
        IO.println("Actual: " + ListNode.max(test3));
        IO.println();

        // Test Case 4: Left-skewed tree
        ListNode test4 = new ListNode(1);
        test4.left = new ListNode(2);
        test4.left.left = new ListNode(3);
        test4.left.left.left = new ListNode(4);
        test4.left.left.left.left = new ListNode(5);

        IO.println("Test 4 - Left-Skewed Tree:");
        IO.println("   1");
        IO.println("  /");
        IO.println(" 2");
        IO.println("/");
        IO.println("3");
        IO.println("/");
        IO.println("4");
        IO.println("/");
        IO.println("5");
        IO.println("Expected: 5");
        IO.println("Actual: " + ListNode.max(test4));
        IO.println();

        // Test Case 5: Right-skewed tree
        ListNode test5 = new ListNode(1);
        test5.right = new ListNode(2);
        test5.right.right = new ListNode(3);
        test5.right.right.right = new ListNode(4);

        IO.println("Test 5 - Right-Skewed Tree:");
        IO.println("1");
        IO.println(" \\");
        IO.println("  2");
        IO.println("   \\");
        IO.println("    3");
        IO.println("     \\");
        IO.println("      4");
        IO.println("Expected: 4");
        IO.println("Actual: " + ListNode.max(test5));
        IO.println();

        // Test Case 6: Complete binary tree
        ListNode test6 = new ListNode(1);
        test6.left = new ListNode(2);
        test6.right = new ListNode(3);
        test6.left.left = new ListNode(4);
        test6.left.right = new ListNode(5);
        test6.right.left = new ListNode(6);
        test6.right.right = new ListNode(7);

        IO.println("Test 6 - Complete Binary Tree:");
        IO.println("       1");
        IO.println("      / \\");
        IO.println("     2   3");
        IO.println("    / \\ / \\");
        IO.println("   4  5 6  7");
        IO.println("Expected: 3");
        IO.println("Actual: " + ListNode.max(test6));
        IO.println();

        // Test Case 7: Deep tree (one side deeper)
        ListNode test7 = new ListNode(1);
        test7.left = new ListNode(2);
        test7.right = new ListNode(3);
        test7.left.left = new ListNode(4);
        test7.left.left.left = new ListNode(5);
        test7.left.left.left.left = new ListNode(6);
        test7.left.left.left.left.left = new ListNode(7);

        IO.println("Test 7 - Deep Left Side:");
        IO.println("       1");
        IO.println("      / \\");
        IO.println("     2   3");
        IO.println("    /");
        IO.println("   4");
        IO.println("  /");
        IO.println(" 5");
        IO.println("Expected: 5");
        IO.println("Actual: " + ListNode.max(test7));
        }
    }

