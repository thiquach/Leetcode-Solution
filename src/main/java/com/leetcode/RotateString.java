package main.java.com.leetcode;

public class RotateString {
    public static void main(String[] args) {
//        String s = "abcde";
//        String goal = "cdeab";
        String s = "abcde";
        String goal = "abced";
        System.out.print("rotate string " + s + " " + goal );
        System.out.println(" -> " + rotateString(s, goal));
    }

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        return (s + s).contains(goal);
    }
}
