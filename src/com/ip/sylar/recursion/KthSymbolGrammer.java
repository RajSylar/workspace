package com.ip.sylar.recursion;

public class KthSymbolGrammer {
    public static void main(String[] args) {
        int n = 4;
        int k = 6;

        System.out.println(kthGrammer(n, k));
    }

    private static int kthGrammer(int n, int k) {
        if(n==1 || k==1)
            return 0;

        int mid = (int) Math.pow(2, (n-1))/2;

        if(k <= mid)
        {
            return kthGrammer(n-1, k);
        }
        else
        {
            int x = (kthGrammer(n-1, (k-mid)));
            if(x==0)
                return 1;
            else
                return 0;
        }
    }


}
