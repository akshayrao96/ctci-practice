package sumLists;

import CtCILibrary.CtCILibrary.LinkedListNode;

public class Question {

    public static int sumListsSameSize(LinkedListNode n1, LinkedListNode n2) {
        int forward = 0;
        int result = 0;
        int place = 1;
        while (n1 != null) {
            int sum = n1.data + n2.data + forward;
            result += (sum % 10) * place;
            forward = 0;
            forward = sum / 10;
            place *= 10;
            n1 = n1.next;
            n2 = n2.next;
        }
        if (forward == 1) {
            result += place;
        }
        return result;
    }

    public static LinkedListNode sumLists(LinkedListNode n1, LinkedListNode n2) {
        return sumLists(n1, n2, 0);
    }

    public static LinkedListNode sumLists(LinkedListNode n1, LinkedListNode n2, int carry) {
        if (n1 == null && n2 == null && carry == 0) {
            return null;
        }
        LinkedListNode node = new LinkedListNode();
        int val = carry;
        if (n1 != null) val += n1.data;
        if (n2 != null) val += n2.data;
        node.data = val % 10;
        if (n1 != null || n2 != null) {
            LinkedListNode node2 = sumLists(n1 != null ? n1.next : null, n2 != null ? n2.next : null, val >= 10 ? 1 : 0);
            node.setNext(node2);
        }
        return node;
    }

    public static LinkedListNode sumListsVersion2(LinkedListNode n1, LinkedListNode n2) {
        LinkedListNode result = new LinkedListNode();
        LinkedListNode itr = result;

        int carry = 0;
        while (n1 != null || n2 != null || carry != 0) {
            int val = carry;
            if (n1 != null) val += n1.data;
            if (n2 != null) val += n2.data;
            itr.next = new LinkedListNode(val % 10);
            itr = itr.next;
            carry = val >= 10 ? 1 : 0;
            if (n1 != null) n1 = n1.next;
            if (n2 != null) n2 = n2.next;
        }
        return result.next;
    }

    public static int linkedListToInt(LinkedListNode node) {
        int value = 0;
        if (node.next != null) {
            value = 10 * linkedListToInt(node.next);
        }
        return value + node.data;
    }

    public static void main(String[] args) {
        LinkedListNode lA1 = new LinkedListNode(7, null, null);
        LinkedListNode lA2 = new LinkedListNode(1, null, lA1);
        LinkedListNode lA3 = new LinkedListNode(6, null, lA2);

        LinkedListNode lB1 = new LinkedListNode(5, null, null);
        LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(2, null, lB2);

        LinkedListNode list3 = sumListsVersion2(lA1, lB1);


        System.out.println("  " + lA1.printForward());
        System.out.println("+ " + lB1.printForward());
        System.out.println("= " + list3.printForward());

        int l1 = linkedListToInt(lA1);
        int l2 = linkedListToInt(lB1);
        int l3 = linkedListToInt(list3);

        System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
        System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));
    }
}
