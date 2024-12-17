package main.java.com.leetcode;

public class MinimizeMaximum {
    public static void main(String[] args) {
//        int[] quantities = {11,6};
        int[] quantities = {5,7};
        int n = 2;
        System.out.println("min Maximum " + minimizedMaximum(n, quantities));
    }

    public static int minimizedMaximum(int n, int[] quantities) {

        int low = 1;
        int high = 0;
        for (int i=0; i<quantities.length; i++) {
            high = Math.max(high, quantities[i]);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            boolean result = canDistribute(quantities, mid, n);

            if (result) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean canDistribute(int[] quantities, int x, int n) {
        int stores = 0;
        for (int q : quantities) {
            stores += (q + x - 1) / x;
        }
        return stores <= n;
    }
}