package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GraphMap<K> extends HashMap<K, LinkedList<K>> {

  public GraphMap(int initialCapacity, float loadFactor) {
    super(initialCapacity, loadFactor);
  }

  public GraphMap(int initialCapacity) {
    super(initialCapacity);
  }

  public GraphMap() {
    super();
  }

  public GraphMap(Map<? extends K, ? extends LinkedList<K>> m) {
    super(m);
  }

  public void addNodeToGraph(K node) {
    this.put(node, new LinkedList<>());
  }
}
