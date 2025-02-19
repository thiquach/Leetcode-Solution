package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    public static void main(String[] args) {
//        String s = "aab";
        String s = "cdd";
        System.out.println(s + " partition " + partition(s));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        findCombinations(s, 0, current, result);
        return result;
    }

    private static boolean isStringPalindrome (String s) {
        int left = 0;
        int right = s.length() - 1;
         while (left < right) {
             if (s.charAt(left) != s.charAt(right)) {
                 return false;
             }
             left++;
             right--;
         }
         return true;
    }

    private static void findCombinations(String s, int start,
                                         List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String subString = s.substring(start, i + 1);
            if (isStringPalindrome(subString)) {
                current.add(subString);
                findCombinations(s, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}