package graphTraversals;

import graph.GraphUndirected;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS {

    public static GraphUndirected<Integer> buildGraph() {
        return getIntegerGraphUndirected();
    }

    public static GraphUndirected<Integer> getIntegerGraphUndirected() {
        GraphUndirected<Integer> g = new GraphUndirected<>();
        g.addNodeToGraph(1);
        g.addNodeToGraph(2);
        g.addNodeToGraph(3);
        g.addNodeToGraph(4);
        g.addNodeToGraph(5);
        g.addNodeToGraph(6);

        g.addEdges(1, 2);
        g.addEdges(2, 5);
        g.addEdges(5, 3);
        g.addEdges(4, 3);
        g.addEdges(6, 4);
        return g;
    }

    public static void dfs(GraphUndirected<Integer> g, int start) {
        System.out.println("---ORDER---");
        Stack<Integer> toProcess = new Stack<>();
        Queue<Integer> visited = new LinkedList<>();
        toProcess.add(start);
        visited.add(start);

        while (!toProcess.isEmpty()) {
            Integer node = toProcess.pop();
            System.out.println(node);
            LinkedList<Integer> curr = g.getNode(node);
            for (int i = 1; i < curr.size(); i++) {
                if (!visited.contains(curr.get(i))) {
                    toProcess.add(curr.get(i));
                    visited.add(curr.get(i));
                }
            }
        }
    }

    public static void dfsRecursion(GraphUndirected<Integer> g, int start) {
        System.out.println("---ORDER---");
        dfsRecursion(g, start, new HashSet<>());
    }

    public static void dfsRecursion(GraphUndirected<Integer> g, int start, HashSet<Integer> visited) {
        System.out.println(start);
        visited.add(start);
        LinkedList<Integer> curr = g.getNode(start);
        for (int i = 1; i < curr.size(); i++) {
            if (!visited.contains(curr.get(i))) {
                visited.add(curr.get(i));
                dfsRecursion(g, curr.get(i), visited);
            }
        }
    }


    public static void main(String[] args) {
        GraphUndirected<Integer> g = buildGraph();
        dfs(g, 1);
        dfs(g, 3);
        dfs(g, 2);

        dfsRecursion(g, 1);
        dfsRecursion(g, 3);
        dfsRecursion(g, 2);
    }
}
