package com.ip.sylar.graph.traversal;

import java.util.*;

public class GraphRepMapList {
    private int vertices;

    private Map<Integer, List<Integer>> map;

    GraphRepMapList(int v) {
        this.vertices = v;
        map = new HashMap<>();
        for (int i = 0; i < v; i++) {
            map.put(i, new ArrayList<>());
        }
    }

    private void addEdge(int src, int dest) {
        map.get(src).add(dest);
        map.get(dest).add(src);
    }

    public static void main(String[] args) {
        GraphRepMapList graph = new GraphRepMapList(6);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(1, 4);
        graph.addEdge(4, 5);

        graph.dfs();
        graph.bfs();
        graph.dfsIterative();
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

        Iterator<Integer> itr = map.get(v).iterator();
        while (itr.hasNext()) {
            int neighbour = itr.next();
            if (!visited[neighbour]) {
                dfs(neighbour, visited);
            }
        }
    }

    private void bfs() {
        boolean[] visited = new boolean[vertices];
        for (int v = 1; v < vertices; v++) {
            if (!visited[v])
                bfs(v, visited);
        }
    }

    private void bfs(int v, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            int temp = queue.poll();

            Iterator<Integer> itr = map.get(temp).iterator();
            while (itr.hasNext()) {
                int neigh = itr.next();
                if (!visited[neigh]) {
                    queue.add(neigh);
                    visited[neigh] = true;
                }
            }
        }
    }

    private void dfsIterative() {
        boolean[] visited = new boolean[vertices];

        for (int v = 1; v < vertices; v++) {
            if (!visited[v])
                processDfsIterative(v, visited);
        }
    }

    private void processDfsIterative(int v, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;

        while (!stack.isEmpty()) {
            int temp = stack.pop();
            System.out.println(temp);

            Iterator<Integer> itr = map.get(temp).iterator();
            while (itr.hasNext()) {
                int neigh = itr.next();
                if (!visited[neigh]) {
                    stack.push(neigh);
                    visited[neigh] = true;
                }
            }
        }
    }
}
