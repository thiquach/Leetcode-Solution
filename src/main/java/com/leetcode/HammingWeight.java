package main.java.com.leetcode;

public class HammingWeight {
    public static void main(String[] args) {
        int n = 7;
        System.out.println("Hamming weight n " + n + " " + hammingWeight(n));
    }

    public static int hammingWeight(int n) {
        int setBits = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                setBits++;
            }
            n = n / 2;
        }

        return setBits;
    }
}