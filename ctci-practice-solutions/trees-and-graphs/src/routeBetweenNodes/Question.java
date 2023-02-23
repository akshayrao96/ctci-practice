package routeBetweenNodes;

import graph.GraphDirected;
import java.util.LinkedList;
import java.util.Queue;

public class Question {

  public static GraphDirected<Integer> buildGraph() {
    return getIntegerGraphDirected();
  }

  private static GraphDirected<Integer> getIntegerGraphDirected() {
    GraphDirected<Integer> g = new GraphDirected<>();
    g.addNodeToGraph(1);
    g.addNodeToGraph(2);
    g.addNodeToGraph(3);
    g.addNodeToGraph(4);
    g.addNodeToGraph(5);
    g.addNodeToGraph(6);
    g.addNodeToGraph(7);

    g.addEdges(1, 6);
    g.addEdges(6, 4);
    g.addEdges(3, 6);
    g.addEdges(5, 6);
    g.addEdges(2, 5);
    g.addEdges(4, 7);
    return g;
  }

  public static boolean routeBetweenNodes(GraphDirected<Integer> g, int start, int end) {
    Queue<Integer> toProcess = new LinkedList<>();
    Queue<Integer> visited = new LinkedList<>();

    toProcess.add(start);

    while (!toProcess.isEmpty()) {
      Integer node = toProcess.poll();
      visited.add(node);
      LinkedList<Integer> nodes = g.getNode(node);
      for (int i = 1; i < nodes.size(); i++) {
        if (nodes.get(i) == end) {
          return true;
        } else {
          if (!visited.contains(nodes.get(i))) {
            visited.add(nodes.get(i));
            toProcess.add(nodes.get(i));
          }
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    GraphDirected<Integer> g = buildGraph();
    System.out.println("True -> " + routeBetweenNodes(g, 1, 4));
    System.out.println("True -> " + routeBetweenNodes(g, 5, 4));
    System.out.println("False -> " + routeBetweenNodes(g, 3, 2));
    System.out.println("False -> " + routeBetweenNodes(g, 4, 5));
    System.out.println("False -> " + routeBetweenNodes(g, 5, 1));
    System.out.println("True -> " + routeBetweenNodes(g, 2, 5));
    System.out.println("True -> " + routeBetweenNodes(g, 2, 7));

  }
}
