package com.ip.sylar.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphRepAdjacencyList {
    private int vertices;
    private LinkedList<Integer>[] adjList;

    public GraphRepAdjacencyList(int v) {
        this.vertices = v;
        this.adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        GraphRepAdjacencyList graph = new GraphRepAdjacencyList(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);


        graph.dfs();
        graph.bfs();
    }

    private void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    private void dfs() {
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, visited);
            }
        }
    }

    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> itr = adjList[v].iterator();
        while (itr.hasNext()) {
            int next = itr.next();
            if (!visited[next]) {
                dfs(next, visited);
            }
        }
    }

    private void bfs() {
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                bfs(i, visited);
            }
        }
    }

    private void bfs(int v, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");
            Iterator<Integer> adj = adjList[temp].iterator();

            while (adj.hasNext()) {
                int w = adj.next();
                if (!visited[w]) {
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }
    }
}
