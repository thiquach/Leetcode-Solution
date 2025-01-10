package main.java.com.leetcode;

public class PrefixCount {
    public static void main(String[] args) {
        String[] words = {"pay","attention","practice","attend"};
        String prefix = "at";

        System.out.println("prefix count " + prefixCount(words, prefix));
    }

    public static int prefixCount(String[] words, String pref) {
        if (words == null || pref.isEmpty())
            return 0;
        int count = 0;
        for (int i=0; i<words.length; i++) {
            if (words[i].startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}