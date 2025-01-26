package main.java.com.leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
//        String[] strs = {"flower","flow","flight"};
        String[] strs = {"dog","racecar","car"};
        System.out.println("longest common prefix " + longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null)
            return "";

        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        int length = strs.length;
        for (int i=0; i<strs[0].length() && i<strs[length-1].length(); i++) {
            char ch0 = strs[0].toCharArray()[i];
            char chn = strs[length - 1].toCharArray()[i];
            if (ch0 != chn) {
                break;
            } else {
                sb.append(ch0);
            }
        }

        return sb.length() > 0 ? sb.toString() : "";
    }
}
