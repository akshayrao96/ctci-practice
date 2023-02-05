package kthToLast;

import CtCILibrary.CtCILibrary.LinkedListNode;
import linkedListImplementation.LinkedList;

public class Question {

    public static LinkedListNode returnKthToLastRercursion(LinkedListNode list, int k) {
        return returnKthToLastRecursion(list, k, 1);
    }

    public static LinkedListNode returnKthToLastRecursion(LinkedListNode list, int k, Integer idx) {
        if (list == null) {
            return null;
        }
        LinkedListNode head = returnKthToLastRecursion(list.next, k, idx);
        idx += 1;
        if (idx == k) {
            return list;
        }
        return head;
    }

    public static LinkedListNode returnKthToLast(LinkedListNode list, int k) {
        if (list == null) return null;
        LinkedListNode p1 = list;
        LinkedListNode p2 = list;
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null;
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        System.out.println(returnKthToLast(head, 4).printForward());
        System.out.println(head.printForward());
    }
}
