package heapImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Heap {

    public static void insert(int data, List<Integer> sample) {
        sample.add(data);
        int index = sample.size() - 1;
        int addedElem = sample.get(index);
        int parentElem = sample.get((index - 1) / 2);
        while (index != 0 && addedElem < parentElem) {
            sample.set(index, parentElem);
            sample.set((index - 1) / 2, addedElem);
            index = (index - 1) / 2;
            if (index == 0) continue;
            addedElem = sample.get(index);
            parentElem = sample.get((index - 1) / 2);
        }
    }

    public static int peekFirst(List<Integer> list) {
        return !list.isEmpty() ? list.get(0) : -1;
    }

    public static int removeFirst(List<Integer> sampleHeap) {
        if (sampleHeap.isEmpty()) return -1;
        int getFirst = peekFirst(sampleHeap);
        sampleHeap.set(0, sampleHeap.get(sampleHeap.size() - 1));
        sampleHeap.remove(sampleHeap.size() - 1);

        int index = 0;
        int smallerChild = 1;

        while (smallerChild < sampleHeap.size()) { // checks if there is a left child
            if (smallerChild + 1 < sampleHeap.size()) {
                if (sampleHeap.get(smallerChild) > sampleHeap.get(smallerChild + 1)) {
                    smallerChild += 1;
                }
            }
            if (sampleHeap.get(index) <= sampleHeap.get(smallerChild)) {
                break;
            } else {
                int bigger = sampleHeap.get(index);
                int smaller = sampleHeap.get(smallerChild);
                sampleHeap.set(index, smaller);
                sampleHeap.set(smallerChild, bigger);
            }
            index = smallerChild;
            smallerChild = smallerChild * 2 + 1;
        }
        return getFirst;
    }

    public static int peekFirst(PriorityQueue<Integer> list) {
        return !list.isEmpty() ? list.peek() : -1;
    }

    public static void main(String[] args) {

        List<Integer> sampleHeap = new ArrayList<>();
        PriorityQueue<Integer> correct = new PriorityQueue<>();
        BuildHeap createdHeap = new BuildHeap();

        int[] arrNum = new int[]{3, 7, 4, 25, 18, 5, 6};
        for (int num : arrNum) {
            sampleHeap.add(num);
            correct.add(num);
            createdHeap.insert(num);
        }

        insertVal(sampleHeap, correct, createdHeap);

        printLists(sampleHeap, correct, createdHeap);

        int size = sampleHeap.size();

        for (int i = 0; i < size - 2; i++) {
            if (peekFirst(sampleHeap) != correct.peek() && correct.peek() != createdHeap.peekFirst()) {
                System.out.println("FALSE");
                break;
            }
            removeFirst(sampleHeap);
            correct.poll();
            createdHeap.removeFirst();
        }
        printLists(sampleHeap, correct, createdHeap);
    }

    public static void insertVal(List<Integer> sampleHeap, PriorityQueue<Integer> correct, BuildHeap h) {
        insert(1, sampleHeap);
        correct.add(1);
        h.insert(1);

        insert(2, sampleHeap);
        correct.add(2);
        h.insert(2);


        insert(10, sampleHeap);
        correct.add(10);
        h.insert(10);


        insert(44, sampleHeap);
        correct.add(44);
        h.insert(44);


        insert(33, sampleHeap);
        correct.add(33);
        h.insert(33);

        insert(93, sampleHeap);
        correct.add(93);
        h.insert(93);

        insert(12, sampleHeap);
        correct.add(12);
        h.insert(12);


        insert(17, sampleHeap);
        correct.add(17);
        h.insert(17);


        insert(32, sampleHeap);
        correct.add(32);
        h.insert(32);


        insert(21, sampleHeap);
        correct.add(21);
        h.insert(21);


        insert(12, sampleHeap);
        correct.add(12);
        h.insert(12);


    }

    public static void printLists(List<Integer> sampleHeap, PriorityQueue<Integer> correct, BuildHeap h) {
        System.out.println(sampleHeap);
        System.out.println(correct);
        System.out.println(h);
    }
}