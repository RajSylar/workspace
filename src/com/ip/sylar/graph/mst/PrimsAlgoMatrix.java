package com.ip.sylar.graph.mst;

public class PrimsAlgoMatrix {
    public static void main(String[] args) {
        PrimsAlgoMatrix t = new PrimsAlgoMatrix();
        int graph[][] = new int[][]{{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};

        // Print the solution
        t.primMST(graph);
    }

    private void primMST(int[][] graph) {
        int v = graph.length;
        int[] key = new int[v];
        int[] parent = new int[v];

        boolean[] included = new boolean[v];

        // initialize all key to infinity
        for (int i = 0; i < v; i++) {
            key[i] = Integer.MAX_VALUE;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < v - 1; i++) {
            int u = minKey(key, included);

            included[u] = true;
            for (int x = 0; x < v; x++) {
                if (graph[u][x] != 0 && included[x] == false && graph[u][x] < key[x]) {
                    key[x] = graph[u][x];
                    parent[x] = u;
                }
            }
        }

        printMST(parent, graph);
    }

    void printMST(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < graph.length; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    private int minKey(int[] key, boolean[] included) {
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < key.length; i++) {
            if (included[i] != true && key[i] < min) {
                min = key[i];
                idx = i;
            }
        }
        return idx;
    }
}
