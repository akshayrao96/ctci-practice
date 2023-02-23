package linkedListImplementation;

public class LinkedList {

  private int size;
  private Node head;

  public LinkedList() {
    this.size = 0;
    this.head = null;
  }

  public void add(int data) {
    if (this.head == null) {
      this.head = new Node(data, null);
    } else {
      this.head = new Node(data, this.head);
    }
    this.size += 1;
  }

  public void remove(int data) {
    if (this.head != null) {
      if (this.head.data == data) {
        this.head = this.head.next;
      } else {
        Node n = this.head;
        while (n.next != null) {
          if (n.next.data == data) {
            n.next = n.next.next;
            break;
          }
          n = n.next;
        }
      }
    }
    this.size -= 1;
  }

  public void addToTail(int data) {
    if (this.head == null) {
      this.head = new Node(data, null);
    } else {
      Node n = this.head;
      while (n.next != null) {
        n = n.next;
      }
      n.next = new Node(data, null);
    }
    size += 1;
  }

  public int getSize() {
    return this.size;
  }

  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append("[");
    if (this.head != null) {
      str.append(this.head.data);
      Node n = this.head;
      while (n.next != null) {
        str.append(", ").append(n.next.data);
        n = n.next;
      }
    }
    return str.append("]").toString();
  }

  private static class Node {

    protected int data;
    protected Node next;

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  public static void main(String[] args) {
    LinkedList list1 = new LinkedList();
    list1.add(4);
    list1.add(1);
    list1.add(8);
    list1.add(0);
    list1.add(2);
    list1.addToTail(100);
    System.out.println(list1);
    System.out.println(list1.getSize());
  }
}
