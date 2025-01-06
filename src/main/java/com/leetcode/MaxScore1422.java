package main.java.com.leetcode;

public class MaxScore1422 {
    public static void main(String[] args) {
        String s = "1111";
        System.out.println("max score " + maxScore(s));
    }

    public static int maxScore(String s) {
        if (s.isEmpty())
            return 0;

        int zeros = 0;
        int ones = 0;
        int totalOnes = 0;
        int maxScore = 0;

        for (char ch: s.toCharArray()) {
            if (ch == '1') {
                totalOnes++;
            }
        }

        for (int i=0; i<s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones++;
            }

            int currentScore = zeros + (totalOnes - ones);
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }
}
