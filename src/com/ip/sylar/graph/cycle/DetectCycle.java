package com.ip.sylar.graph.cycle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DetectCycle {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1}, {1, 2}, {2, 3}, {0, 3}, {4, 5}, {5, 6}};
        DetectCycle detectCycle = new DetectCycle();
        System.out.println(detectCycle.detectCycleInDirectedGraph(7, matrix));
    }

    static class Graph {
        int vertices;
        List<List<Integer>> adj;


        public Graph(int v) {
            this.vertices = v;
            adj = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int src, int dest) {
            adj.get(src).add(dest);
        }
    }

    public boolean detectCycle(int vertices, int[][] adjMatrix)
    {
        Graph graph = new Graph(vertices);
        for(int i=0; i<vertices; i++)
        {
            graph.addEdge(adjMatrix[i][0], adjMatrix[i][1]);
        }

        boolean[] visited = new boolean[vertices];

        for(int i=0; i<vertices; i++)
        {
            if(!visited[i])
            {
                if(isCyclePresent(graph, i, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean isCyclePresent(Graph graph, int v, boolean[] visited) {
        visited[v] = true;
        Iterator<Integer> itr = graph.adj.get(v).iterator();

        while(itr.hasNext())
        {
            int neigh = itr.next();

        }
        return false;
    }

    public boolean detectCycleInDirectedGraph(int vertices, int[][] adjMatrix) {
        Graph g = new Graph(vertices);

        for (int i = 0; i < adjMatrix.length; i++) {
            g.addEdge(adjMatrix[i][0], adjMatrix[i][1]);
        }

        int[] color = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            color[i] = 0;
        }

        for (int i = 0; i < vertices; i++) {
            if (color[i] != 2) {
                if (isCycle(g, i, color))
                    return true;
            }
        }
        return false;
    }

    public boolean isCycle(Graph g, int v, int[] color) {
        color[v] = 1;

        Iterator<Integer> itr = g.adj.get(v).iterator();

        while (itr.hasNext()) {
            int neigh = itr.next();

            if (color[neigh] == 2) {
                continue;
            }

            if (color[neigh] == 1) {
                return true;
            }

            if (isCycle(g, neigh, color))
                return true;
        }

        color[v] = 2;
        return false;
    }

}
