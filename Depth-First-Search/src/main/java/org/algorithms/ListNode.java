package org.algorithms;

public class ListNode implements Comparable<ListNode> {
    int val;
    public ListNode left;
    public ListNode right;

    public ListNode(int val) {
        this.val = val;
        ListNode left = null, right = null;
    }
    @Override
    public int compareTo(ListNode node) {
        return this.val - node.val;
    }
    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public static int max(ListNode root) {
        if (root == null) {
            return 0;
        }
        int left = max(root.left);
        int right = max(root.right);

        int maxChild = Math.max(left, right);
        return maxChild + 1;
    }
}

