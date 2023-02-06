package partition;

import CtCILibrary.CtCILibrary.LinkedListNode;

public class Question {

    public static LinkedListNode partition(LinkedListNode n, int val) {
        LinkedListNode left = new LinkedListNode();
        LinkedListNode leftItr = left;
        LinkedListNode right = new LinkedListNode();
        LinkedListNode rightItr = right;

        while (n != null) {
            if (n.data < val) {
                leftItr.next = n;
                leftItr = leftItr.next;
            } else {
                rightItr.next = n;
                rightItr = rightItr.next;
            }
            n = n.next;
        }
        leftItr.next = right.next;
        rightItr.next = null;
        return left.next;
    }

    public static LinkedListNode createLinkedList() {
        /* Create linked list */
        int[] vals = {3, 5, 8, 5, 10, 2, 1};
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            current = new LinkedListNode(vals[i], null, current);
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(createLinkedList().printForward());

        /* Partition */
        LinkedListNode hA = Question.partition(createLinkedList(), 5);
        /* Print Result */
        System.out.println(hA.printForward());
    }
}
