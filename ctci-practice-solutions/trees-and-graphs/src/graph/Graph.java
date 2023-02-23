package graph;

import java.util.LinkedList;

public abstract class Graph<T> {

  protected LinkedList<LinkedList<T>> nodes;

  public Graph() {
    this.nodes = new LinkedList<>();
  }

  public void addNodeToGraph(T node) {
    LinkedList<T> newNode = new LinkedList<>();
    newNode.add(node);
    this.nodes.add(newNode);
  }

  public void addEdges(T start, T end) {
    for (LinkedList<T> subList : this.nodes) {
      if (subList.getFirst().equals(start)) {
        subList.addLast(end);
      }
    }
  }

  public LinkedList<T> getNode(T node) {
    for (LinkedList<T> subList : this.nodes) {
      if (subList.getFirst().equals(node)) {
        return subList;
      }
    }
    throw new IllegalArgumentException();
  }
}
