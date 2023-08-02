package linkedListImplementation;

public class LinkedList<E> {

  private static class Node<E> {

    protected E data;
    protected Node<E> next;

    public Node(E data, Node<E> next) {
      this.data = data;
      this.next = next;
    }
  }

  private int size;
  private Node<E> head;

  public LinkedList() {
    this.size = 0;
    this.head = null;
  }

  public void add(E data) {
    if (this.size == 0) {
      this.head = new Node<>(data, null);
    } else {
      this.head = new Node<>(data, this.head);
    }
    this.size += 1;
  }

  public void addToTail(E data) {
    if (this.head == null) {
      this.head = new Node<>(data, null);
    } else {
      Node<E> curr = this.head;
      while (curr.next != null) {
        curr = curr.next;
      }
      curr.next = new Node<>(data, null);
    }
    size += 1;
  }

  public void remove(E data) throws EmptyListException {

    if (this.isEmpty())
      throw new EmptyListException();

    Node<E> curr = this.head;
    Node<E> prev = this.head;

    if (this.head.data == data) {
      this.head = this.head.next;
    } else {
      curr = curr.next;
    }
    while (curr != null) {
      if (curr.data == data) {
        prev.next = curr.next;
        break;
      }
      prev = curr;
      curr = curr.next;
    }
  }

  public boolean isEmpty() {
    return this.getSize() == 0;
  }


  public int getSize() {
    return this.size;
  }

  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append("[");
    if (this.head != null) {
      str.append(this.head.data);
      Node<E> n = this.head;
      while (n.next != null) {
        str.append(", ").append(n.next.data);
        n = n.next;
      }
    }
    return str.append("]").toString();
  }

  public static void main(String[] args) throws EmptyListException {
    LinkedList<Integer> list1 = new LinkedList<>();
    list1.add(4);
    list1.add(1);
    list1.add(8);
    list1.add(0);
    list1.add(2);
    list1.addToTail(10);
    System.out.println(list1);
    list1.remove(10);
    System.out.println(list1);

  }
}
