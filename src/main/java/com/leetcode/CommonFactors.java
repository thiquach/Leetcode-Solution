package main.java.com.leetcode;

public class CommonFactors {
    public static void main(String[] args) {
        int a = 885;
        int b = 885;
        System.out.println("common factors " + commonFactors(a, b));
    }

    public static int commonFactors(int a, int b) {
        int maxNum = Math.max(a, b);
        int count = 0;

        System.out.println("max " + maxNum);
        for (int i=1; i <= maxNum; i++) {
            if ((a % i == 0) && (b % i == 0)) {
                System.out.println(" i=" + i);
                count++;
            }
        }
        return count;
    }
}