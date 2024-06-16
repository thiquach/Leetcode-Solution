package main.java.com.leetcode;

public class MergeStringsAltternately {

    public static void main(String[] args) {
        String str1 = "abcdefg";
        String str2 = "ABCDEFGHI";
        System.out.println("str1 " + str1 + " str2 " + str2);
        System.out.println("merge        " + mergeAlternately(str1, str2));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder mergeString = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int i=0;
        int j=0;

        while (i < len1 || j < len2) {
            if (i < len1) {
                mergeString.append(word1.charAt(i++));
            }
            if (j < len2) {
                mergeString.append(word2.charAt(j++));
            }
        }
        return mergeString.toString();
    }
}
