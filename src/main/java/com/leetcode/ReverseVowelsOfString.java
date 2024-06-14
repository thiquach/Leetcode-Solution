package main.java.com.leetcode;

import java.util.Arrays;

public class ReverseVowelsOfString {

    public static void main(String[] args) {
        String string = "race car";
        System.out.println("original string " + string);
        System.out.println("reversed        " + reverseVowels(string));
    }

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();

        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (left < right && !isVowel(chars[left])) {
                left++;
            }
            while (left < right && !isVowel(chars[right])) {
                right--;
            }
            if (chars[left] != chars[right]) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
           }
           left++;
           right--;
         }
        return new String(chars);
    }

    private static boolean isVowel (char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }
}