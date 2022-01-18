package com.ip.sylar.dp.mcm;

public class MCM {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 3};
        int i = 1;
        int j = arr.length - 1;
        System.out.println(findMinimumCostForMatrixMul(arr, i, j));
    }

    private static int findMinimumCostForMatrixMul(int[] arr, int i, int j) {
        // base condition
        if (i >= j)
            return 0;

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            // calculate temp solution
            int tempSol = findMinimumCostForMatrixMul(arr, i, k) + findMinimumCostForMatrixMul(arr, k + 1, j) +
                    (arr[i - 1] * arr[k] * arr[j]);

            if (tempSol < min) {
                min = tempSol;
            }
        }
        return min;
    }
}
