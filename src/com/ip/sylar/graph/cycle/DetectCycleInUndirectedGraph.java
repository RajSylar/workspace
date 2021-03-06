package com.ip.sylar.graph.cycle;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUndirectedGraph {

    static class Graph {
        int vertices;
        LinkedList<Integer>[] adjList;

        public Graph(int v) {
            this.vertices = v;
            adjList = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int src, int dest) {
            adjList[src].add(dest);
            adjList[dest].add(src);
        }
    }

    public static void main(String[] args) {

        DetectCycleInUndirectedGraph d = new DetectCycleInUndirectedGraph();
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        //g.addEdge(3, 1);
        //g.addEdge(4, 1);
        //g.addEdge(0, 5);

        System.out.println(isCyclePresent(g));
    }

    private static boolean isCyclePresent(Graph g) {
        int v = g.vertices;
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (isCyclePresent(g, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCyclePresent(Graph g, int v, boolean[] visited, int parent) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            Iterator<Integer> itr = g.adjList[temp].iterator();
            while (itr.hasNext()) {
                int neigh = itr.next();
                if (!visited[neigh]) {
                    queue.add(neigh);
                    visited[neigh] = true;
                    parent = temp;
                } else {
                    if (neigh != parent) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean hasCyclePresent(Graph g) {
        boolean[] visited = new boolean[g.vertices];

        for (int i = 0; i < g.vertices; i++) {
            if (!visited[i]) {
                if (cycleExists(g, i, visited, -1))
                    return true;
            }
        }
        return false;
    }

    private static boolean cycleExists(Graph g, int i, boolean[] visited, int parent) {
        visited[i] = true;

        Iterator<Integer> itr = g.adjList[i].iterator();

        while (itr.hasNext()) {
            int n = itr.next();

            if (!visited[n]) {
                if (cycleExists(g, n, visited, i)) {
                    return true;
                }
            } else if (n != parent)
                return true;
        }
        return false;
    }
}
