package com.ip.sylar.graph.connectivity;

public class NumberOfIslands {
    public static void main(String[] args) {
        int matrix[][] = new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};
        NumberOfIslands islands = new NumberOfIslands();
        System.out.println(islands.countIslands(matrix));
    }

    private int countIslands(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    dfsForHorAndVer(matrix, i, j, n, m, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] matrix, int rowNbr, int colNbr, int n, int m, boolean[][] visited) {
        int row[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int col[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        visited[rowNbr][colNbr] = true;

        for (int k = 0; k < 8; k++) {
            if (isSafe(matrix, rowNbr + row[k], colNbr + col[k], n, m, visited)) {
                dfs(matrix, rowNbr + row[k], colNbr + col[k], n, m, visited);
            }
        }
    }

    private void dfsForHorAndVer(int[][] matrix, int rowNbr, int colNbr, int n, int m, boolean[][] visited) {
        int row[] = new int[]{-1, 0, 0, 1};
        int col[] = new int[]{0, -1, 1, 0};

        visited[rowNbr][colNbr] = true;

        for (int k = 0; k < 4; k++) {
            if (isSafe(matrix, rowNbr + row[k], colNbr + col[k], n, m, visited)) {
                dfsForHorAndVer(matrix, rowNbr + row[k], colNbr + col[k], n, m, visited);
            }
        }
    }

    private boolean isSafe(int[][] matrix, int rowNbr, int colNbr, int n, int m, boolean[][] visited) {
        return rowNbr >= 0 && rowNbr < n && colNbr >= 0 && colNbr < m && matrix[rowNbr][colNbr] == 1 && !visited[rowNbr][colNbr];
    }
}
