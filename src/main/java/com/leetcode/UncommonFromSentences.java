package main.java.com.leetcode;

import java.util.*;
// 884
public class UncommonFromSentences {
    public static void main(String[] args) {
        String s1 = "This apple is sweet";
        String s2 = "This apple is sour";
        String[] result = uncommonFromSentences(s1, s2);
        System.out.println(" uncommon " + Arrays.toString(result));
    }
    public static String[] uncommonFromSentences(String s1, String s2) {
        if (s1 == null && s2 == null)
            return new String[] {};

        Map<String, Integer> wordMap = new HashMap<>();

        String[] subStrings1 = s1.split(" ");
        for (String s : subStrings1) {
            wordMap.put(s, wordMap.getOrDefault(s, 0) + 1);
        }

        String[] subStrings2 = s2.split(" ");
        for (String s : subStrings2) {
            wordMap.put(s, wordMap.getOrDefault(s, 0) + 1);
        }

        int size = wordMap.size();

        List<String> resultList = new ArrayList<>();

        // Check the integer value of wordMap and print the string if the value is less than 2
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue() < 2) {
                resultList.add(entry.getKey());
            }
        }
        return resultList.toArray(new String[0]);
    }
}
