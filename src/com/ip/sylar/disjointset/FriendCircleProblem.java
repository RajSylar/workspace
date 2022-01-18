package com.ip.sylar.disjointset;

public class FriendCircleProblem {
    public static void main(String[] args) {
        FriendCircleProblem friendCircleProblem = new FriendCircleProblem();
        int[][] circle = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        DisjointSet disjointSet = new DisjointSet();
        System.out.println(friendCircleProblem.findFriendCircle(circle, disjointSet));
    }

    private int findFriendCircle(int[][] matrix, DisjointSet disjointSet) {
        int circle = matrix.length;
        for (int i = 0; i < circle; i++) {
            disjointSet.makeSet(i);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != j && matrix[i][j] == 1) {
                    DisjointSet.Node node1 = disjointSet.findSet(disjointSet.map.get(i));
                    DisjointSet.Node node2 = disjointSet.findSet(disjointSet.map.get(j));

                    if (node1 != node2) {
                        disjointSet.union(i, j);
                        circle--;
                    }
                }
            }
        }
        return circle;
    }
}
