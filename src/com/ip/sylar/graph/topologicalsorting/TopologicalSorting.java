package com.ip.sylar.graph.topologicalsorting;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSorting {
    private int vertices;
    private LinkedList<Integer>[] adjList;

    public TopologicalSorting(int v) {
        this.vertices = v;
        this.adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    public static void main(String[] args) {
        TopologicalSorting graph = new TopologicalSorting(6);
        graph.addEdge('A' - 'A', 'C' - 'A');
        graph.addEdge('C' - 'A', 'D' - 'A');
        graph.addEdge('D' - 'A', 'F' - 'A');
        graph.addEdge('B' - 'A', 'E' - 'A');
        graph.addEdge('E' - 'A', 'F' - 'A');

        graph.findTopologicalSorting();
    }

    private void findTopologicalSorting() {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                findTopologicalSorting(i, visited, stack);
            }
        }

        while (stack.empty() == false)
            System.out.print((char) (stack.pop() + 'A') + " ");
    }

    private void findTopologicalSorting(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        Iterator<Integer> itr = adjList[v].iterator();
        while (itr.hasNext()) {
            int n = itr.next();
            if (!visited[n]) {
                findTopologicalSorting(n, visited, stack);
            }
        }

        stack.push(v);
    }
}
