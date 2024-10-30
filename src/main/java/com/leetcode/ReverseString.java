package main.java.com.leetcode;

import java.util.Arrays;

// 344
public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        System.out.println(" reverse " + Arrays.toString(s));
        reverseString(s);
    }

    public static void reverseString(char[] s) {
        if(s.length <= 1)
            return;

        int left = 0;
        int right = s.length - 1;
        char temp = '\0';
        while (left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        System.out.println(" reversed " + Arrays.toString(s));
    }
}