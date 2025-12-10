package org.algorithms;

public class Main {
    static void main() {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(7);
        ListNode node7 = new ListNode(8);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(10);
        ListNode node10 = new ListNode(11);
        ListNode node11 = new ListNode(12);
        ListNode node12 = new ListNode(13);
        ListNode node13 = new ListNode(14);
        ListNode node14 = new ListNode(15);
        ListNode node15 = new ListNode(16);

        // Create a cycle: point node 16 back to node 6
        LinkLister(head, node1, node2, node3, node4, node5, node6, node7, node8);
        LinkLister(node8, node9, node10, node11, node12, node13, node14, node15, node6);

        IO.println(ListNode.hasCycle(head)); // Will print true
    }

    public static void LinkLister(ListNode head, ListNode node1, ListNode node2, ListNode node3, ListNode node4, ListNode node5, ListNode node6, ListNode node7, ListNode node8) {
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
    }
}