package routeBetweenNodes;

public class Question {

    public static Graph buildGraph() {
        Graph g = new Graph(5);
        g.addEdges(1, 2);
        g.addEdges(2, 5);
        g.addEdges(2, 4);
        g.addEdges(4, 1);
        g.addEdges(1, 3);
        return g;
    }

    public static void main(String[] args) {
        Graph g = buildGraph();

    }
}
