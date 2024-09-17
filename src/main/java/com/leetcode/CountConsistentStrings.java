package main.java.com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
// 1684
public class CountConsistentStrings {
    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};
        int result = countConsistentStrings(allowed, words);
        System.out.println(" allowed " + allowed + " words " + Arrays.toString(words));
        System.out.println(" result " + result);

    }

    public static int countConsistentStrings(String allowed, String[] words) {
        if (allowed == null)
            return 0;

        HashSet<Character> allowedSet = new HashSet<>();
        for (Character ch : allowed.toCharArray()) {
            allowedSet.add(ch);
        }

        int count = 0;
        for (int i=0; i<words.length; i++) {
            boolean inconsistent = false;
            for (int j=0; j<words[i].length(); j++) {
                System.out.print(" " + words[i].charAt(j));
                if (!allowedSet.contains(words[i].charAt(j))) {
                    inconsistent = true;
                    break;
                }
            }
            if (!inconsistent) {
                count++;
            }
        }
        return count;
    }
}
