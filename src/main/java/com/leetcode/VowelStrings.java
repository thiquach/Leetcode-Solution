package main.java.com.leetcode;

import java.util.Arrays;
// 2559
public class VowelStrings {
    public static void main(String[] args) {
        String[] words = {"aba","bcb","ece","aa","e"};
        int[][] queries = {{0,2},{1,4},{1,1}};
        System.out.println("vowel string " + Arrays.toString(vowelStrings(words, queries)));
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        if (words.length == 0)
            return new int[] {};

        System.out.println(" words " + Arrays.toString(words));
        int[] prefixSum = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            if (isVowelString(words[i])) {
                prefixSum[i] = (i > 0 ? prefixSum[i - 1] : 0) + 1;
            } else {
                prefixSum[i] = (i > 0 ? prefixSum[i - 1] : 0);
            }
        }

        System.out.println(" prefx " + Arrays.toString(prefixSum));

        int[] results = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            results[i] = prefixSum[end] - (start > 0 ? prefixSum[start - 1] : 0);
        }

        return results;
    }

    private static boolean isVowelString(String word) {
        if (word == null || word.isEmpty())
            return false;

        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }
}
