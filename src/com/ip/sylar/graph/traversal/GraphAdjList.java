package com.ip.sylar.graph.traversal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GraphAdjList {

    private int vertices;

    private List<List<Integer>> list;

    GraphAdjList(int v) {
        this.vertices = v;
        list = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        GraphAdjList graph = new GraphAdjList(6);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(1, 4);
        graph.addEdge(4, 5);

        graph.dfs();
    }

    private void dfs() {
        boolean[] visited = new boolean[this.vertices];
        for (int v = 0; v < vertices; v++) {
            if (!visited[v]) {
                dfs(v, visited);
            }
        }
    }

    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println(v);

        Iterator<Integer> itr = list.get(v).iterator();
        while (itr.hasNext()) {
            int neighbour = itr.next();
            if (!visited[neighbour]) {
                dfs(neighbour, visited);
            }
        }
    }

    private void addEdge(int src, int dest) {
        list.get(src).add(dest);
        list.get(dest).add(src);
    }
}
