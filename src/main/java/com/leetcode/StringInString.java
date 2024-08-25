package main.java.com.leetcode;

public class StringInString {
    public static void main (String[] args) {
        String haystack =  "leetcode";
        String needle = "leeto";
        int result = strStr(haystack, needle);
        System.out.println("\nstring in string " + result);
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null)
            return -1;
        return haystack.indexOf(needle);
    }
}
