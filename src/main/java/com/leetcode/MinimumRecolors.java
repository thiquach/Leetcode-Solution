package main.java.com.leetcode;

public class MinimumRecolors {
    public static void main(String[] args) {
        String block = "WBBWWBBWBW";
        int k = 7;
        System.out.println("Minimum recolor " + minimumRecolors(block, k));
    }

    public static int minimumRecolors(String blocks, int k) {
        if (blocks.isEmpty() || blocks.length() < k)
            return -1;

        int minCount = Integer.MAX_VALUE;
        for (int i=0; i+k <= blocks.length(); i++) {
            String noWhite = removeAllWhite(blocks.substring(i, k + i), "W");
            minCount = Math.min(minCount, k - noWhite.length());
        }

        return minCount;
    }

    public static String removeAllWhite(String s, String white) {
        if (s.isEmpty())
            return "";

        StringBuilder sb = new StringBuilder(s);
        while (s.contains(white)) {
            int left = sb.indexOf(white);
            if (left != -1) {
                sb.delete(left, left + 1);
            }
            s = sb.toString();
        }
        return s;
    }
}
