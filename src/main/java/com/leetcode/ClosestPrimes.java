package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestPrimes {
    public static void main(String[] args) {
        // left 11 right 19
        // left 19 right 31
//        int left = 12854; int right = 130337;
        int left = 11;
        int right = 19;
        System.out.println("Closest primes " + Arrays.toString(closestPrimes(left,right)));
    }

    public static int[] closestPrimes(int left, int right) {
        if (left == right) {
            return new int[] {-1,-1};
        }

        int[] primeNumbers = sieve(right);
        List<Integer> list = new ArrayList<>();
        for (int i=left; i<=right; i++) {
            if (primeNumbers[i] == 1) {
                list.add(i);
            }
        }

        int[] result = new int[list.size()];
        int index = 0;
        for (int i=0; i<list.size(); i++) {
            result[index] = list.get(i);
            index++;
        }

        int prev = 0;
        int smallest = Integer.MAX_VALUE;
        int[] pair = new int[] {-1, -1};
        int size = list.size();
        for (int i=1; i<size; i++) {
            int diff = result[i] - result[prev];
            if (diff < smallest) {
                smallest = diff;
                pair[0] = result[prev];
                pair[1] = result[i];
            }
            prev = i;
        }
        return pair;
    }

    private static int[] sieve(int upperLimit) {
        int[] sieve = new int [upperLimit + 1];
        Arrays.fill(sieve, 1);

        sieve[0] = 0;
        sieve[1] = 0;

        for (int p = 2; p * p <= upperLimit; p++) {
            if (sieve[p] == 1) {
                for (int i = p * p; i <= upperLimit; i += p)
                    sieve[i] = 0;
            }
        }
        return sieve;
    }
}