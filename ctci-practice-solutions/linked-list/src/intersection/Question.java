package intersection;

import CtCILibrary.CtCILibrary.AssortedMethods;
import CtCILibrary.CtCILibrary.LinkedListNode;

public class Question {

    public static LinkedListNode intersection(LinkedListNode n1, LinkedListNode n2) {
        LinkedListNode n1Itr = n1;
        int n1Count = 0;
        LinkedListNode n2Itr = n2;
        int n2Count = 0;

        while (n1Itr != null) {
            n1Count += 1;
            if (n1Itr.next == null) break;
            n1Itr = n1Itr.next;
        }

        while (n2Itr != null) {
            n2Count += 1;
            if (n2Itr.next == null) break;
            n2Itr = n2Itr.next;
        }

        LinkedListNode result = null;

        if (!(n1Itr.equals(n2Itr))) return result;

        n1Itr = n1;
        n2Itr = n2;

        for (int i = 0; i < Math.abs(n1Count - n2Count); i++) {
            if (n1Count > n2Count) {
                n1Itr = n1Itr.next;
            } else {
                n2Itr = n2Itr.next;
            }
        }
        while (n1Itr != null && n2Itr != null) {
            if (n1Itr.equals(n2Itr)) {
                result = n1Itr;
                break;
            }
            n1Itr = n1Itr.next;
            n2Itr = n2Itr.next;
        }
        return result;
    }

    public static void main(String[] args) {
        /* Create linked list */
        int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vals);

        int[] vals2 = {12, 14, 15};
        LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vals2);

        list2.next.next = list1.next.next.next.next;

        System.out.println(list1.printForward());
        System.out.println(list2.printForward());


        LinkedListNode intersection = intersection(list1, list2);

        System.out.println(intersection.printForward());
    }
}
