package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsRecurseBacktrack {
    public static void main(String[] args) {
        String s = "abc";
        List<String> result = new ArrayList<>();
        System.out.println("Permutation " + s);
        permutations(s.toCharArray(), 0, result);
        System.out.println("result " + result);
    }

    private static void permutations(char[] s, int i, List<String> result) {
        if (i == s.length) {
            result.add(new String(s));
            return;
        }
        // recursion
        for (int j=i; j<s.length; j++) {
            swap(s, i, j);
            permutations(s, i + 1, result);
            swap(s,i,j); // backtracking
        }
    }

    private static void swap(char[] s , int i , int j ) {
        char temp = s[i];
        s[i]= s[j];
        s[j] = temp;
    }
}
