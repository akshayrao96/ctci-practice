package heapImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BuildHeap {
    private List<Integer> list;

    public BuildHeap() {
        this.list = new ArrayList<>();
    }

    public void insert(int data) {
        this.list.add(data);
        int index = this.list.size() - 1;
        int addedElem = this.list.get(index);
        int parentElem = this.list.get((index - 1) / 2);
        while (index != 0 && addedElem < parentElem) {
            this.list.set(index, parentElem);
            this.list.set((index - 1) / 2, addedElem);
            index = (index - 1) / 2;
            if (index == 0) continue;
            addedElem = this.list.get(index);
            parentElem = this.list.get((index - 1) / 2);
        }
    }

    public int peekFirst() {
        return !this.list.isEmpty() ? this.list.get(0) : -1;
    }

    public int removeFirst() {
        if (this.list.isEmpty()) return -1;
        int getFirst = peekFirst();
        this.list.set(0, this.list.get(this.list.size() - 1));
        this.list.remove(this.list.size() - 1);

        int index = 0;
        int smallerChild = 1;

        while (smallerChild < this.list.size()) { // checks if there is a left child
            if (smallerChild + 1 < this.list.size()) {
                if (this.list.get(smallerChild) > this.list.get(smallerChild + 1)) {
                    smallerChild += 1;
                }
            }
            if (this.list.get(index) <= this.list.get(smallerChild)) {
                break;
            } else {
                int bigger = this.list.get(index);
                int smaller = this.list.get(smallerChild);
                this.list.set(index, smaller);
                this.list.set(smallerChild, bigger);
            }
            index = smallerChild;
            smallerChild = smallerChild * 2 + 1;
        }
        return getFirst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuildHeap buildHeap = (BuildHeap) o;
        return Objects.equals(list, buildHeap.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public String toString() {
        return this.list.toString();
    }
}
