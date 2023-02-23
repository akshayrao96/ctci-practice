package loopDetection;

import CtCILibrary.CtCILibrary.LinkedListNode;
import java.util.HashSet;

public class Question {

  public static LinkedListNode loopDetection(LinkedListNode n) {
    LinkedListNode result = null;
    HashSet<LinkedListNode> seen = new HashSet<>();
    LinkedListNode itr = n;
    while (itr != null) {
      if (seen.contains(itr)) {
        result = itr;
        break;
      } else {
        seen.add(itr);
        itr = itr.next;
      }
    }
    return result;
  }

  public static LinkedListNode loopDetectionV2(LinkedListNode n) {
    LinkedListNode fast = n;
    LinkedListNode slow = n;
    do {
      fast = fast.next.next;
      slow = slow.next;
    } while (!fast.equals(slow));
    slow = n;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

  public static void main(String[] args) {
    int list_length = 100;
    int k = 10;

    // Create linked list
    LinkedListNode[] nodes = new LinkedListNode[list_length];
    for (int i = 0; i < list_length; i++) {
      nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
    }

    // Create loop;
    nodes[list_length - 1].next = nodes[list_length - k];
    LinkedListNode loop = loopDetectionV2(nodes[91]);
    if (loop == null) {
      System.out.println("No Cycle.");
    } else {
      System.out.println(loop.data);
    }
  }
}
