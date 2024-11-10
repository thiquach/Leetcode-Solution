package main.java.com.leetcode;
// 2914
public class MinChanges {
    public static void main(String[] args) {
        String s = "1001";
        System.out.println("Min changes " + minChanges(s));
    }

    public static int minChanges(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int count = 0;
        for (int i = 1; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                count++;
            }
        }
        return count;
    }
}
