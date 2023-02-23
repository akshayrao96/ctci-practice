package myQueue;

import stackImplementation.MyStack;

public class MyQueue<T> {

  private final MyStack<T> stack1;
  private final MyStack<T> stack2;

  public MyQueue() {
    stack1 = new MyStack<>();
    stack2 = new MyStack<>();
  }

  public int size() {
    return stack1.size() + stack2.size();
  }

  public void add(T item) {
    stack1.push(item);
  }

  public T peek() {
    moveStack();
    return stack2.peek();
  }

  public T remove() {
    moveStack();
    return stack2.pop();
  }

  private void moveStack() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(this.stack1.pop());
      }
    }
  }
}
