package setOfStacks;

import stackImplementation.MyStack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;


public class SetOfStacks<T> {
    private final int MAX_CAPACITY = 5;
    private int size;
    private List<MyStack<T>> stackList;

    public SetOfStacks() {
        this.size = 0;
        stackList = new ArrayList<>();
    }

    public T pop() {
        if (this.isEmpty()) throw new EmptyStackException(); //error val
        MyStack<T> curr = stackList.get((this.size - 1) % MAX_CAPACITY);
        if (this.size / MAX_CAPACITY == 0) {
            curr = new MyStack<>();
        }
        T val = curr.pop();
        size -= 1;
        if (curr.isEmpty()) curr = null;
        return val;
    }

    public void push(T item) {
        MyStack<T> curr = stackList.get(this.size % MAX_CAPACITY);
        if (this.size / MAX_CAPACITY == 0) {
            curr = new MyStack<>();
        }
        curr.push(item);
        size += 1;
    }

    public T popAt(int index) {
        MyStack<T> curr = stackList.get(index);
        if (curr == null) throw new EmptyStackException();
        T val = curr.pop();
        size -= 1;
        return val;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
