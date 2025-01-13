package main.java.com.leetcode;

import java.util.*;

public class WordSubsets {
    public static void main(String[] args) {
//        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words1 = {"acaac","cccbb","aacbb","caacc","bcbbb"};
        String[] words2 = {"c","cc","b"};
//        String[] words2 = {"e","o"};
//        String[] words2 = {"lo","eo"};
//        String[] words2 = {"lc","eo"};
        System.out.println("word subsets " + wordSubsets(words1, words2));
    }

    public static List<String> wordSubsets(String[] words1, String[] words2) {
        if (words1 == null || words2 == null)
            return new ArrayList<>();

        List<String> universalWords = new ArrayList<>();

        int[] word2MaxCount = new int[26];
        for (int i=0; i< words2.length; i++) {
            int[] word2Count = new int[26];
            for (Character ch2: words2[i].toCharArray()) {
                int idx = ch2 - 'a';
                word2Count[idx]++;
                word2MaxCount[idx] = Math.max(word2MaxCount[idx], word2Count[idx]);
            }
        }

        for (String s : words1) {
            int[] word1Count = new int[26];
            for (Character ch : s.toCharArray()) {
                int idx = ch - 'a';
                word1Count[idx]++;
            }

            if (isSubset(word1Count, word2MaxCount))
                universalWords.add(s);
        }
        return universalWords;
    }

    private static boolean isSubset (int[] word1, int[] word2) {
        for (int i=0; i<26; i++) {
            if (word2[i] > word1[i]) {
                return false;
            }
        }
        return true;
    }
}