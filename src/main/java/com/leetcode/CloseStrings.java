package main.java.com.leetcode;

import java.util.*;

// 1657 Hash Map /  Set
public class CloseStrings {
    public static void main(String[] args) {

        String word1 = "abbzzca";
        String word2 = "babzzcz";
        System.out.println("CloseStrings " + word1 + " " + word2);
        System.out.println("result " + closeStrings(word1, word2));
    }

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> word1Map = new HashMap<>();
        Map<Character, Integer> word2Map = new HashMap<>();

        for (char ch : word1.toCharArray()) {
            word1Map.merge(ch, 1, Integer::sum);
        }

        for (char ch : word2.toCharArray()) {
            word2Map.merge(ch, 1, Integer::sum);
        }

        List<Integer> list1 = new ArrayList<>(word1Map.values());
        List<Integer> list2 = new ArrayList<>(word2Map.values());

        Collections.sort(list1);
        Collections.sort(list2);

        return word1Map.keySet().equals(word2Map.keySet()) && list1.equals(list2);
    }
}