package fibonacci;

import stackImplementation.MyStack;

public class Question {

  // returns num-th number in a fibonacci sequence
  public static int fibonacci(int num) {
    if (num <= 1) {
      return 1;
    }
    return fibonacci(num - 1) + fibonacci(num - 2);
  }

  public static int fibonacciStack(int num) {
    if (num <= 1) {
      return 1;
    }
    MyStack<Integer> stack = new MyStack<>();
    stack.push(1);
    stack.push(1);
    for (int i = 1; i < num; i++) {
      int num1 = stack.pop();
      int num2 = stack.pop();
      stack.push(num1);
      stack.push(num1 + num2);
    }
    return stack.peek();
  }

  public static void main(String[] args) {

    long startTime1 = System.nanoTime();
    System.out.println(fibonacci(45));
    long endTime1 = System.nanoTime();
    System.out.println((endTime1 - startTime1) / 1000);

    long startTime2 = System.nanoTime();
    System.out.println(fibonacciStack(45));
    long endTime2 = System.nanoTime();
    System.out.println((endTime2 - startTime2) / 1000);

  }
}
