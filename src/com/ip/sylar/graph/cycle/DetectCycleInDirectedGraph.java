package com.ip.sylar.graph.cycle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DetectCycleInDirectedGraph {
    static class Graph {
        int vertices;
        private List<List<Integer>> edges;

        public Graph(int v) {
            this.vertices = v;
            edges = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                edges.add(new ArrayList<>());
            }
        }

        public void addEdge(int src, int dest) {
            edges.get(src).add(dest);
        }
    }

    public static void main(String[] args) {
        DetectCycleInDirectedGraph d = new DetectCycleInDirectedGraph();
        int[][] mat = {{1, 0}};
        if(d.detectCycleInDirectedGraph(2, mat))
        {
            System.out.println(false);
        }
        else
        {
            System.out.println(true);
        }
    }

    public boolean detectCycleInDirectedGraph(int vertices, int[][] adjMatrix) {
        Graph g = new Graph(vertices);
        for (int i = 0; i < adjMatrix.length; i++) {
            int[] adj = adjMatrix[i];
            g.addEdge(adj[0], adj[1]);
        }

        return isCycle(g);
    }

    private boolean isCycle(Graph graph) {
        int v = graph.vertices;
        boolean[] whiteSet = new boolean[v];

        for (int i = 0; i < v; i++) {
            whiteSet[i] = true;
        }

        boolean[] greySet = new boolean[v];
        boolean[] blackSet = new boolean[v];

        for (int i = 0; i < whiteSet.length; i++) {
            if (isCyclic(graph, i, whiteSet, greySet, blackSet))
                return true;
        }
        return false;
    }

    private boolean isCyclic(Graph graph, int i, boolean[] whiteSet, boolean[] greySet, boolean[] blackSet) {
        moveFromOneSetToAnother(i, whiteSet, greySet);

        List<Integer> child = graph.edges.get(i);
        Iterator<Integer> itr = child.iterator();
        while (itr.hasNext()) {
            int c = itr.next();
            ;
            if (blackSet[c]) {
                continue;
            }
            if (greySet[c]) {
                return true;
            }
            if (isCyclic(graph, c, whiteSet, greySet, blackSet)) {
                return true;
            }
        }
        moveFromOneSetToAnother(i, greySet, blackSet);
        return false;
    }

    private void moveFromOneSetToAnother(int v, boolean[] sourceSet, boolean[] destSet) {
        sourceSet[v] = false;
        destSet[v] = true;
    }
}
