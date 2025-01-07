package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
// 1408
public class StringMatching {
    public static void main(String[] args) {
        String[] words = {"mass","as","hero","superhero"};
        List<String> result = stringMatching(words);
        System.out.println("string matching " + result);
    }

    public static List<String> stringMatching(String[] words) {
        if (words == null)
            return new ArrayList<>();

        HashSet<String> wordSet = new HashSet<>();
        for (int i=0; i<words.length; i++) {
            for (int j=i+1; j<words.length; j++) {
                if (words[i].contains(words[j])) {
                    wordSet.add(words[j]);
                }
                if (words[j].contains(words[i])) {
                    wordSet.add(words[i]);
                }
            }
        }
        return  new ArrayList<>(wordSet);
    }
}