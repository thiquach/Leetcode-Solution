package main.java.com.leetcode;

import java.util.Arrays;

public class ReverseVowelsOfString {

    public static void main(String[] args) {
        String string = "race car";
        System.out.println("original string " + string);
        System.out.println("reversed        " + reverseVowels(string));
    }

    public static String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !isVowel(sb.charAt(left))) {
                left++;
            }
            while (left < right && !isVowel(sb.charAt(right))) {
                right--;
            }
            if (sb.charAt(left) != sb.charAt(right)) {
                char temp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, temp);
            }
            left++;
            right--;
        }
        return sb.toString();
    }

    private static boolean isVowel (char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }
}