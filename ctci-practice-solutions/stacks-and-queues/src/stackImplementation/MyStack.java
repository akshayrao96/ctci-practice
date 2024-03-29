package stackImplementation;

import java.util.EmptyStackException;

public class MyStack<T> {

  private static class StackNode<T> {

    private final T data;
    private StackNode<T> next;

    public StackNode(T data) {
      this.data = data;
    }
  }

  private StackNode<T> top;
  private final int size;

  public MyStack() {
    this.size = 0;
    this.top = null;
  }

  public T pop() {
    if (top == null) {
      throw new EmptyStackException();
    }
    T item = top.data;
    top = top.next;
    return item;
  }

  public void push(T item) {
    StackNode<T> newItem = new StackNode<>(item);
    newItem.next = top;
    top = newItem;
  }

  public T peek() {
    if (top == null) {
      throw new EmptyStackException();
    }
    return top.data;
  }

  public boolean isEmpty() {
    return top == null;
  }

  public int size() {
    return this.size;
  }
}