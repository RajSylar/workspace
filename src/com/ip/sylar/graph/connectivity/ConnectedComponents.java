package com.ip.sylar.graph.connectivity;

import java.util.Iterator;
import java.util.LinkedList;

public class ConnectedComponents {
    int vertices;
    LinkedList<Integer>[] adjList;

    public ConnectedComponents(int v) {
        this.vertices = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        ConnectedComponents g = new ConnectedComponents(5);
        g.addEdge(1, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.findConnectedComponents();
    }

    private void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    public void findConnectedComponents() {
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, visited);
                System.out.println("");
            }
        }
    }

    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println(v);

        Iterator<Integer> itr = adjList[v].iterator();
        while (itr.hasNext()) {
            int n = itr.next();
            if (!visited[n]) {
                dfs(n, visited);
            }
        }
    }
}
