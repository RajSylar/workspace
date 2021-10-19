package com.ip.sylar.graph.cycle;

import java.util.*;

public class PossiblePartitioning {
    private int vertices;
    private List<List<Integer>> adjList;

    public PossiblePartitioning(int v) {
        this.vertices = v;
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 3}};
        //[[1,2],[1,3],[2,3]]
        System.out.println(possiblePartition(n, dislikes));
    }

    private static boolean possiblePartition(int v, int[][] dislikes) {
        PossiblePartitioning p = new PossiblePartitioning(v);
        for (int i = 0; i < dislikes.length; i++) {
            p.adjList.get(dislikes[i][0]).add(dislikes[i][1]);
        }

        int[] color = new int[v+1];
        for (int i = 1; i < v+1; i++) {
            color[i] = -1;
        }

        for (int i = 1; i < v+1; i++) {
            if (color[i] == -1 && isPossiblePartitioning(i, p.adjList, color))
                return true;
        }
        return false;
    }

    private static boolean isPossiblePartitioning(int v, List<List<Integer>> adjList, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        color[v] = 1;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            Iterator<Integer> itr = adjList.get(temp).iterator();

            while (itr.hasNext()) {
                int adj = itr.next();
                if (color[adj] == color[temp]) {
                    return false;
                }
                if (color[adj] == -1) {
                    color[adj] = 1 - color[temp];
                    queue.add(adj);
                }
            }
        }
        return true;
    }

}
