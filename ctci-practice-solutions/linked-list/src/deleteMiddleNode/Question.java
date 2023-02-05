package deleteMiddleNode;

import CtCILibrary.CtCILibrary.AssortedMethods;
import CtCILibrary.CtCILibrary.LinkedListNode;

public class Question {

    public static void deleteMiddleNodeBad(LinkedListNode list, LinkedListNode given) {
        if (given != null) {
            LinkedListNode current = list;
            while (current.next.data != given.data) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }

    public static void deleteMiddleNodeGood(LinkedListNode given) {
        if (given == null || given.next == null) {
            return;
        }
        LinkedListNode next = given.next;
        given.data = next.data;
        given.next = next.next;
    }

    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());
        deleteMiddleNodeGood(head.next.next.next.next); // delete node 4
        System.out.println(head.printForward());
    }

}


/*
Deletes node in the middle, given only access to that node
void method
a->b->c->d->e->f
change reference from b->c to b->d




 */
