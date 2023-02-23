package sortStack;

import stackImplementation.MyStack;

public class Question {

  public static void sortStack(MyStack<Integer> stack) {
    if (stack.isEmpty()) {
      return;
    }
    MyStack<Integer> temp = new MyStack<>();
    while (!stack.isEmpty()) {
      temp.push(stack.pop());
    }
    while (!temp.isEmpty()) {
      int val = temp.pop();
      while (!stack.isEmpty() && val > stack.peek()) {
        temp.push(stack.pop());
      }
      stack.push(val);
    }
  }

  public static void main(String[] args) {
    MyStack<Integer> stack = new MyStack<>();
    for (int i : new int[]{6, 5, 8, 10, 55, 33, 0, 1, 4, 2, 99}) {
      stack.push(i);
    }
    sortStack(stack);
    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }
}
