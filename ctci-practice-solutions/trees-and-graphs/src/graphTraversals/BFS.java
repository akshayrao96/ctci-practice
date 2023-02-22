package graphTraversals;

import graph.GraphUndirected;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import static graphTraversals.DFS.getIntegerGraphUndirected;

public class BFS {

    public static GraphUndirected<Integer> buildGraph() {
        return getIntegerGraphUndirected();
    }

    public static void bfs(GraphUndirected<Integer> g, int start) {
        System.out.println("---ORDER---");
        Queue<Integer> toProcess = new LinkedList<>();
        Queue<Integer> visited = new LinkedList<>();
        toProcess.add(start);
        visited.add(start);

        while (!toProcess.isEmpty()) {
            Integer node = toProcess.poll();
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

    public static void main(String[] args) {
        GraphUndirected<Integer> g = buildGraph();
        bfs(g, 1);
        bfs(g, 3);
    }
}
