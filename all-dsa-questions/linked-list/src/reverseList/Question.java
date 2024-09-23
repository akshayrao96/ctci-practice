package reverseList;

import linkedListImplementation.LinkedList;
import linkedListImplementation.LinkedList.Node;

public class Question {

  public static void reverseList(LinkedList<Integer> list) {
    Node<Integer> prev = null;
    Node<Integer> curr = list.ListNode();
    Node<Integer> temp = curr;

    while (curr != null) {
      temp = temp.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
    }
    list.head = prev;

  }

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 10; i++) {
      list.addToTail((int)(Math.random() * 5));
    }
    System.out.println(list);
    reverseList(list);
    System.out.println(list);
  }
}
