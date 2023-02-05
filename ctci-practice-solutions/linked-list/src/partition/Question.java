package partition;

import CtCILibrary.CtCILibrary.LinkedListNode;

public class Question {

    public static LinkedListNode partition(LinkedListNode n, int val) {
        LinkedListNode left = new LinkedListNode(-1);
        LinkedListNode leftPtr = left;

        LinkedListNode right = new LinkedListNode(-1);
        LinkedListNode rightPtr = right;


        LinkedListNode temp = new LinkedListNode(-1);
        temp.next = n;

        LinkedListNode p1 = temp;

        while (temp.next != null) {
            temp = temp.next;
            if (temp.data < val) {
                leftPtr.next = new LinkedListNode(temp.data);
                leftPtr = leftPtr.next;
            } else {
                rightPtr.next = new LinkedListNode(temp.data);
                rightPtr = rightPtr.next;
            }
        }
        leftPtr.next = right.next;
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
