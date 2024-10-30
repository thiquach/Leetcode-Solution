package main.java.com.leetcode;

import java.util.*;

public class CommonChars {
    public static void main(String[] args) {
//        String[] words = {"bella","label","roller"};
        String[] words = {"cool"};
        System.out.println("common chars " + commonChars(words));
    }

    public static List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();

        if (words.length == 0)
            return result;

        Map<Character, Integer> baseWord = new HashMap<>();
        for (Character ch : words[0].toCharArray()) {
            baseWord.put(ch, baseWord.getOrDefault(ch, 0) + 1);
            result.add(ch.toString());
        }

        Map<Character, Integer> nextWord = new HashMap<>();
        for (int i=1; i<words.length; i++) {
            for (Character ch : words[i].toCharArray()) {
                nextWord.put(ch, nextWord.getOrDefault(ch, 0) + 1);
            }
            result = findChars(baseWord, nextWord);
            nextWord.clear();
        }
        return result;
    }

    private static List<String> findChars (Map<Character, Integer> first, Map<Character, Integer> second) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : first.entrySet()) {
            Character ch = entry.getKey();
            if (!second.containsKey(ch)) {
                first.put(ch, 0);
            } else {
                int val = Math.min(second.get(ch), entry.getValue());
                first.put(ch, val);
                for (int i=0; i<val; i++)
                    result.add(ch.toString());
            }
        }
        return result;
    }
}