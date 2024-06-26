package main.java.com.leetcode;

public class MaxVowels {
    public static void main(String[] args) {
        String s = "zpuerktejfp";
        int k = 3;
        System.out.println("[" + s + ", " + k + "]" + " maxVowels " + maxVowels(s, k));
    }

    public static int maxVowels(String s, int k) {
        int len = s.length();
        if (len < 1 || len < k)
            return 0;
        int left = 0;
        int right = k;
        int count = 0;
        int maxCount = 0;

        for (int i=0; i<k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        maxCount = count;

        for (int i=k; i<len; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
            if (isVowel(s.charAt(i-k))) {
                count--;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }

    private static boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }
}