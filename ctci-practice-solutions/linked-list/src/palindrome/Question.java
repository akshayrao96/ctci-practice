package palindrome;

import CtCILibrary.CtCILibrary.LinkedListNode;

public class Question {

    public static boolean palindromeV2(LinkedListNode head) {
        if (head == null || head.next == null) return true;
        LinkedListNode fast = head;
        LinkedListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        LinkedListNode prev = null;
        LinkedListNode curr = slow;
        while (curr != null) {
            LinkedListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        LinkedListNode start = head;
        while (start != null && prev != null) {
            if (start.data != prev.data) return false;
            start = start.next;
            prev = prev.next;
        }
        return true;
    }

    public static boolean palindrome(LinkedListNode head) {
        if (head == null || head.next == null) return true;
        LinkedListNode reverse = reverseLinkedList(head);
        return checkEquals(head, reverse);
    }

    private static LinkedListNode reverseLinkedList(LinkedListNode node) {
        LinkedListNode head = null;
        while (node != null) {
            LinkedListNode n = new LinkedListNode(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    private static boolean checkEquals(LinkedListNode n1, LinkedListNode n2) {
        while (n1 != null && n2 != null) {
            if (n1.data != n2.data) return false;
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1 == null && n2 == null;
    }

    public static void main(String[] args) {
        int max = 11;
        for (int length = 1; length < max; length++) {
            LinkedListNode[] nodes = new LinkedListNode[length];
            for (int i = 0; i < length; i++) {
                nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
            }

            for (int i = 0; i < length; i++) {
                if (i < length - 1) {
                    nodes[i].setNext(nodes[i + 1]);
                }
                if (i > 0) {
                    nodes[i].setPrevious(nodes[i - 1]);
                }
            }
            for (int i = -1; i < length; i++) {
                if (i >= 0) {
                    nodes[i].data++; // Ruin palindrome
                }

                LinkedListNode head = nodes[0];
                System.out.println(head.printForward());
                boolean resultA = palindrome(head);
                System.out.println("A: " + resultA);
                if (i >= 0) {
                    nodes[i].data--;
                }
            }
        }
    }
}
