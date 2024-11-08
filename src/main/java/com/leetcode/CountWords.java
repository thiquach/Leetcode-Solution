package main.java.com.leetcode;

import java.util.*;
// 2085
public class CountWords {
    public static void main(String[] args) {
//        String[] words1= {"leetcode","is","amazing","as","is"};
//        String[] words2 = {"amazing","leetcode","is"};
        String[] words1= {"a","ab"};
        String[] words2 = {"a","a","a","ab"};
        System.out.println("count words " + countWords(words1, words2));
    }

    public static int countWords(String[] words1, String[] words2) {
        if (words1 == null || words2 == null)
            return 0;

        Map<String, Integer> words1Map = builtWordsMap(words1);
        Map<String, Integer> words2Map = builtWordsMap(words2);
        words1Map.keySet().retainAll(words2Map.keySet());

        return words1Map.size();
    }

    private static Map<String, Integer> builtWordsMap (String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<words.length; i++) {
            map.merge(words[i], 1, Integer::sum);
        }
        map.values().removeIf(count -> count > 1);
        return map;
    }
}