package com.ip.sylar.graph.traversal;

public class GraphRepAdjacencyMatrix {

    private Integer[][] adjMatrix;
    private int vertices;

    public GraphRepAdjacencyMatrix(int v) {
        this.vertices = v;
        adjMatrix = new Integer[v][v];
    }

    public static void main(String[] args) {
        GraphRepAdjacencyMatrix graph = new GraphRepAdjacencyMatrix(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.dfs();
    }

    private void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;
    }

    public void dfs() {
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
        //Iterator<Integer> itr = Arrays.stream(adjMatrix[v]).iterator();
        Integer[] adj = adjMatrix[v];
        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]) {
                dfs(i, visited);
            }
        }
    }
}
