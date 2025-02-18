package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 17 Backtracking or recursive
public class LetterCombinations {
    public static void main(String[] args) {

        String digits = "23";
        System.out.println("LetterCombinations " + digits);
        System.out.println("result " + letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.isEmpty())
            return result;

        String[] mapping = {
                " ",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        StringBuilder sb = new StringBuilder();
        letterCombinationsRecursion(result, mapping, digits, 0, sb);
        return result;
    }

    private static void letterCombinationsRecursion(List<String> result, String[] mapping, String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        int d = digits.charAt(index) - '0';
        String letters = mapping[d];
        for (int i=0; i<letters.length(); i++) {
            sb.append(letters.charAt(i));
            letterCombinationsRecursion(result, mapping, digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}