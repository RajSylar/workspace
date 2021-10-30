package com.ip.sylar.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    static class WeightValue {
        double wt;
        double val;
        double ratio;

        public WeightValue(double wt, double val) {
            this.wt = wt;
            this.val = val;
            this.ratio = val / wt;
        }

        public Double getRatio() {
            return this.ratio;
        }

    }

    public static void main(String[] args) {
        int[] price = new int[]{60, 100, 120};
        int[] weight = new int[]{10, 20, 30};
        int W = 50;
        int n = price.length;

        System.out.println(findMaximumProfit(weight, price, W, n));
    }

    private static double findMaximumProfit(int[] weight, int[] price, int W, int n) {
        WeightValue[] weightValues = new WeightValue[n];

        for (int i = 0; i < n; i++) {
            weightValues[i] = new WeightValue(weight[i], price[i]);
        }

        Comparator<WeightValue> comparator = Comparator.comparing(WeightValue::getRatio).reversed();

        Arrays.sort(weightValues, comparator);

        double totalProfit = 0;

        for (WeightValue wv : weightValues) {
            int wt = (int) wv.wt;
            int val = (int) wv.val;

            if (wt <= W) {
                totalProfit = totalProfit + val;
                W = W - wt;
            } else {
                double frac = (double) W / (double) wt;
                totalProfit = totalProfit + (val * frac);
                W = (int) (W - (wt * frac));
                break;
            }
        }
        return totalProfit;
    }
}
