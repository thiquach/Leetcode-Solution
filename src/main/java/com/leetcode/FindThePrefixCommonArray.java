package main.java.com.leetcode;

import java.util.*;

public class FindThePrefixCommonArray {
    public static void main(String[] args) {
//        int[] A = {1,3,2,4};
//        int[] B = {3,1,2,4};
        int[] A = {2,3,1};
        int[] B = {3,1,2};
        System.out.println("prefix common array " + Arrays.toString(findThePrefixCommonArray(A,B)));
    }
    
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0 || A.length != B.length)
            return new int[] {};

        int[] result = findCommon(A, B);
        System.out.println("common prefix " + Arrays.toString(result));
        return result;
    }

    private static int[] findCommon(int[] A, int[] B) {
        int[] common = new int[A.length];

        Set<Integer> seenInA = new HashSet<>();
        Set<Integer> seenInB = new HashSet<>();
        int count = 0;
        for (int i=0; i<A.length; i++) {
            if (seenInB.contains(A[i])) {
                count++;
            }
            seenInA.add(A[i]);

            if (seenInA.contains(B[i])) {
                count++;
            }
            seenInB.add(B[i]);

            common[i] = count;
        }
        return common;
    }
}