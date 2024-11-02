package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsCircularSentence {
    public static void main(String[] args) {
//        String sentence = "leetcode exercises sound delightful";
//        String sentence = "eetcode";
//        String sentence = "leetcode";
        String sentence = "Leetcode eisc cool";
//        String sentence = "Leetcode is cool";
        System.out.println("is circular? " + isCircularSentence(sentence));
    }

    public static boolean isCircularSentence(String sentence) {
        if (sentence == null)
            return false;

        String[] words = sentence.split(" ");
        int len = words.length;

        int left = 0;
        int right = left + 1;
        boolean flag = false;

        if (len == 1) {
            if (words[0].charAt(0) != words[0].charAt(words[0].length() - 1))
                return false;
            else {
                flag = true;
            }
        } else {
            while (left < len) {
                if (words[left].charAt(words[left].length() - 1) != words[right].charAt(0)) {
                    flag = false;
                    break;
                }
                if (!flag) {
                    left = right;
                    right++;
                    if (right == len) {
                        right = 0;
                        flag = true;
                    }
                } else break;
            }
        }
        return flag;
    }
}