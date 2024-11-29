package main.java.com.leetcode;

public class MaximumSubsequenceCount {
    public static void main(String[] args) {
        String text = "abdcdbc"; // pattern "ac
//        String text = "aabb"; // "ab
        String pattern = "ac";
        System.out.println("MaximumSubsequenceCount " + maximumSubsequenceCount(text, pattern));
    }

    public static long maximumSubsequenceCount(String text, String pattern) {

        long count1 = countSubsequence(pattern, pattern.charAt(0) + text);
        long count2 = countSubsequence(pattern, text + pattern.charAt(1));
        return Math.max(count1,count2);
    }

    public static long countSubsequence(String pattern, String text) {
        if (pattern.length() < 2 || text.isEmpty()) {
            return 0L;
        }

        long count = 0;
        int firstCharCount = 0;

        for (char c : text.toCharArray()) {
            if (c == pattern.charAt(1)) {
                count += firstCharCount;
            }
            if (c == pattern.charAt(0)) {
                firstCharCount++;
            }
        }

        return count;
    }
}
