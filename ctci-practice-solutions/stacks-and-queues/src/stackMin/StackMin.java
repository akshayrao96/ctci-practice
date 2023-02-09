package stackMin;

import stackImplementation.MyStack;

public class StackMin<T> extends MyStack<NodeWithMin> {

    public void push(int val) {
        int min = Math.min(val, this.min());
        super.push(new NodeWithMin(val, min));
    }

    public int min() {
        if (this.isEmpty()) return Integer.MAX_VALUE; // Error value
        return this.peek().getMin();
    }

    public static void main(String[] args) {
        StackMin<Integer> stack = new StackMin<>();
        for (int i : new int[]{3, 7, 200, 44, 9, 2, 10, 8, 6, 1, 10, 8, 6}) {
            stack.push(i);
        }
        System.out.println(stack.min()); // 1
    }
}

class NodeWithMin {
    private int value;
    private int min;

    public NodeWithMin(int value, int min) {
        this.value = value;
        this.min = min;
    }

    public int getValue() {
        return value;
    }

    public int getMin() {
        return min;
    }
}



