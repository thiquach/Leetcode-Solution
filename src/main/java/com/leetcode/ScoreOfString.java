package main.java.com.leetcode;

public class ScoreOfString {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println("score of string " + scoreOfString(s));
    }
    public static int scoreOfString(String s) {
        if (s == null)
            return 0;

        int sum = 0;
        int lastChar = s.charAt(0);
        for (Character ch : s.toCharArray()) {
            sum += Math.abs(lastChar - ch);
            lastChar = ch;
        }
        return sum;
    }
}
