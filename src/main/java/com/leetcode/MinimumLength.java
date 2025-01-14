package main.java.com.leetcode;

import java.util.*;

public class MinimumLength {
    public static void main(String[] args) {
        String s = "abaacbcbb";
//        String s = "ucvbutgkohgbcobqeyqwppbxqoynxeuuzouyvmydfhrprdbuzwqebwuiejoxsxdhbmuaiscalnteocghnlisxxawxgcjloevrdcj";
        System.out.println("mimimum length " + minimumLength(s));
    }

    public static int minimumLength(String s) {
        if (s.length() < 3)
            return s.length();

        int[] sCharCount = new int[26];
        for (Character ch: s.toCharArray()) {
            int idx = ch - 'a';
            sCharCount[idx]++;
        }
        return removeOperation(sCharCount);
    }

    private static int removeOperation(int[] sCharCount) {
        for (int i=0; i<26; i++) {
            if (sCharCount[i] > 0) {
                if (sCharCount[i] == 1 || sCharCount[i] == 2) {
                } else if (sCharCount[i] % 2 == 0) {
                    sCharCount[i] = 2;
                } else if (sCharCount[i] % 2 != 0) {
                    sCharCount[i] = 1;
                }
            }
        }
        return Arrays.stream(sCharCount).sum();
    }
}