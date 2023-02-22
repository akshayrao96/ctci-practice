package graph;

import java.util.LinkedList;

public class GraphUndirected<T> extends Graph<T> {

    public GraphUndirected() {
        super();
    }

    @Override
    public void addEdges(T start, T end) {
        super.addEdges(start, end);
        super.addEdges(end, start);
    }
}
