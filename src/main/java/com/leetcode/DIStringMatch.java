package main.java.com.leetcode;

import java.util.Arrays;

public class DIStringMatch {
    public static void main(String[] args) {
//        String s = "DIDI";
        String s = "DDI";
        System.out.println("DI string match " + Arrays.toString(diStringMatch(s)));
    }

    public static int[] diStringMatch(String s) {
        int length = s.length();
        int[] perm = new int[length + 1];

        int dStart = length;
        int iStart = 0;
        int index = 0;
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == 'D') {
                perm[index] = dStart--;
            } else if (ch == 'I') {
                perm[index] = iStart++;
            }
            index++;
        }
        perm[index] = iStart;
        return perm;
    }
}