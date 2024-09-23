package queueImplementation;

public class MyQueue<T> {

  private static class QueueNode<T> {

    private final T data;
    private QueueNode<T> next;

    public QueueNode(T data) {
      this.data = data;
    }
  }

  private QueueNode<T> front;
  private QueueNode<T> last;

  public void add(T item) {
    if (front == null) {
      front = new QueueNode<>(item);
      last = front;
    } else {
      last.next = new QueueNode<>(item);
      last = last.next;
    }
  }

  public T remove() {
    if (front == null) {
      throw new IllegalArgumentException();
    }
    T data = front.data;
    if (front.equals(last)) {
      front = null;
      last = null;
    } else {
      front = front.next;
    }
    return data;
  }

  public T peek() {
    if (front == null) {
      throw new IllegalArgumentException();
    }
    return front.data;
  }

  public boolean isEmpty() {
    return front == null;
  }
}
