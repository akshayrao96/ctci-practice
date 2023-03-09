package buildOrder;

import graph.GraphDirected;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Question {

  public static void buildGraph(GraphDirected<Character> g, List<Character> p, List<Pair<Character, Character>> d) {
    for (Character c : p) {
      g.addNodeToGraph(c);
    }
    for (Pair<Character, Character> pair : d) {
      g.addEdges(pair.first, pair.second);
    }
  }

  private static List<Character> noDependencies(GraphDirected<Character> g) {
    List<Character> result = new ArrayList<>();
    List<Character> prev = new ArrayList<>();
    while (result.size() != g.getNodes().size()) {
      for (LinkedList<Character> edges : g.getNodes()) {
        if (result.contains(edges.getFirst())) continue;
        result.add(edges.getFirst());
      }
      for (LinkedList<Character> edges : g.getNodes()) {
        for (int i = 1; i < edges.size(); i++) {
          if (!result.contains(edges.get(i))) {
            continue;
          }
          result.remove(edges.get(i));
        }
      }

      if (!result.equals(prev))
        prev = new ArrayList<>(result);
      else {
        throw new IllegalCallerException();
      }

      for (Character c : result) {
        while (g.getNode(c).size() != 1) {
          g.getNode(c).remove(1);
        }
      }
    }
    return result;
  }

  private static List<Character> buildOrder(List<Character> p, List<Pair<Character, Character>> d) {
    GraphDirected<Character> g  = new GraphDirected<>();
    buildGraph(g, p, d);
    return noDependencies(g);
  }

  public static void main(String[] args) {
    List<Character> projects = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f');
    List<Pair<Character, Character>> dep = new ArrayList<>(){{
      add(new Pair<>('a', 'd'));
      add(new Pair<>('f', 'b'));
      add(new Pair<>('b', 'd'));
      add(new Pair<>('f', 'a'));
      add(new Pair<>('d', 'c'));
    }};
    List<Character> list = buildOrder(projects, dep);
    System.out.println(list);
  }

  private record Pair<K, T>(K first, T second) {
  }
}
