package towerOfHanoi;

import java.util.Stack;

public class Question {

  public static void towerOfHanoi(int n, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
    if (n == 0) return;
    towerOfHanoi(n - 1, a, b, c);
    c.push(a.pop());
    towerOfHanoi(n - 1, b, a, c);
  }

  public static void main(String[] args) {
    Stack<Integer> a = new Stack<>();
    Stack<Integer> b = new Stack<>();
    Stack<Integer> c = new Stack<>();

    for (int i = 3; i >= 1; i--) {
      a.push(i);
    }

    towerOfHanoi(a.size(), a, b, c);

    System.out.println("a : " + a.toString());
    System.out.println("b : " + b.toString());
    System.out.println("c : " + c.toString());

  }
}
