package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 17 Backtracking
public class LetterCombinations {
    public static void main(String[] args) {

        String digits = "23";
        System.out.println("LetterCombinations " + digits);
        System.out.println("result " + letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {

        int len = digits.length();
        if (len < 1 || len > 4)
            return new ArrayList<>();

        HashMap<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        makeCombinations(digits.toCharArray(), 0, digitToLetters, new StringBuilder(), result);
        return result;
    }

    public static void makeCombinations(char[] digits, int index, HashMap<Character, String> digitMap, StringBuilder sb, List<String> result) {

        if (index == digits.length) {
            result.add(sb.toString());
            return;
        }

        String letterOption = digitMap.get(digits[index]);
        for (int i=0; i<letterOption.length(); i++) {
            char letter = letterOption.charAt(i);
            sb.append(letter);
            makeCombinations(digits, index + 1, digitMap, sb, result);
            sb.deleteCharAt(sb.length() - 1); // backtracking
        }
    }
}