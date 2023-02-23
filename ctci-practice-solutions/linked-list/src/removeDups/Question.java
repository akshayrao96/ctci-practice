package removeDups;

import CtCILibrary.CtCILibrary.LinkedListNode;
import java.util.HashSet;

public class Question {

  public static void removeDups(LinkedListNode list) {
    HashSet<Integer> seen = new HashSet<>();
    LinkedListNode prev = null;
    LinkedListNode n = list;
    while (n != null) {
      if (seen.contains(n.data)) {
        prev.next = n.next;
      } else {
        seen.add(n.data);
        prev = n;
      }
      n = n.next;
    }
  }

  public static void removeDupsNoBuffer(LinkedListNode list) {
    LinkedListNode current = list;
    while (current != null) {
      LinkedListNode runner = current;
      while (runner.next != null) {
        if (runner.next.data == current.data) {
          runner.next = runner.next.next;
        } else {
          runner = runner.next;
        }
      }
      current = current.next;
    }
  }

  public static void main(String[] args) {
    LinkedListNode first = new LinkedListNode(0, null,
        null); //AssortedMethods.randomLinkedList(1000, 0, 2);
    LinkedListNode head = first;
    LinkedListNode second = first;
    for (int i = 1; i < 8; i++) {
      second = new LinkedListNode(i % 2, null, null);
      first.setNext(second);
      second.setPrevious(first);
      first = second;
    }
    System.out.println(head.printForward());
    removeDupsNoBuffer(head);
    System.out.println(head.printForward());
  }
}
