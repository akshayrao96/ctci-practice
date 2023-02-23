package stackMin;

import stackImplementation.MyStack;

public class StackMin2 extends MyStack<Integer> {

  private final MyStack<Integer> min;

  public StackMin2() {
    min = new MyStack<>();
  }

  @Override
  public void push(Integer item) {
    if (min.isEmpty() || item <= min.peek()) {
      min.push(item);
    }
    super.push(item);
  }

  @Override
  public Integer pop() {
    int val = super.pop();
    if (val == this.min()) {
      this.min.pop();
    }
    return val;
  }

  public int min() {
    if (this.min.isEmpty()) {
      return Integer.MAX_VALUE; // error
    }
    return min.peek();
  }

  public static void main(String[] args) {
    StackMin2 stack = new StackMin2();
    for (int i : new int[]{3, 7, 200, 44, 9, 2, 10, 8, 6, 1, 10, 8, 6}) {
      stack.push(i);
    }
    System.out.println(stack.min()); // 1
  }
}
