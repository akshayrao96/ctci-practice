package routeBetweenNodes;

import CtCILibrary.CtCILibrary.LinkedListNode;

import java.util.LinkedList;

public class Graph {

    protected LinkedList<LinkedList<Integer>> nodes;

    public Graph(int size) {
        this.nodes = new LinkedList<>();
        addNodeToGraph(size);
    }

    private void addNodeToGraph(int size) {
        for (int i = 1; i <= size; i++) {
            this.nodes.add(new LinkedList<>());
        }
    }

    public void addEdges(int start, int end) {
        for (int i = 1; i <= this.nodes.size(); i++) {
            if (start == i) {
                this.nodes.get(i - 1).add(end);
            } else if (end == i) {
                this.nodes.get(end - 1).add(start);
            }
        }
    }
}
