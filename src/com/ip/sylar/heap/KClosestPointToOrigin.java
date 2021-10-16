package com.ip.sylar.heap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class KClosestPointToOrigin {

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    static class Pair2 {
        int dist;
        Pair pair;

        public Pair2(int dist, Pair pair) {
            this.dist = dist;
            this.pair = pair;
        }

        public int getDist() {
            return dist;
        }

        public void setDist(int dist) {
            this.dist = dist;
        }

        public Pair getPair() {
            return pair;
        }

        public void setPair(Pair pair) {
            this.pair = pair;
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k = 2;
        findClosestToOrigin(arr, k);
    }

    private static void findClosestToOrigin(int[][] arr, int k) {
        Comparator<Pair2> comparator = Comparator.comparing(Pair2::getDist).reversed();
        PriorityQueue<Pair2> pq = new PriorityQueue<>(comparator);

        for (int i = 0; i < arr.length; i++) {
            pq.add(new Pair2(arr[i][0] * arr[i][0] + arr[i][1] * arr[i][1], new Pair(arr[i][0], arr[i][1])));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (pq.size() > 0) {
            Pair2 p = pq.poll();
            System.out.println(p.pair.getX() + "," + p.pair.getY());
        }
    }
}
