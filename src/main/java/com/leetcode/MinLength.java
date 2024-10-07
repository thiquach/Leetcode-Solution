package main.java.com.leetcode;
// 2696
public class MinLength {
    public static void main(String[] args) {
        String s = "ABFCACDB";
        System.out.println(" s minlenth " + s + " " + minLength(s));
    }

    public static int minLength(String s) {
        if (s == null)
            return 0;

        while (s.contains("AB") || s.contains("CD")) {
            StringBuilder sb = new StringBuilder(s);
            int left = sb.indexOf("AB");
            if (left != -1) {
                sb.delete(left, left + 2);
            }
            left = sb.indexOf("CD");
            if (left != -1) {
                sb.delete(left, left + 2);
            }
            s = sb.toString();
        }
        return s.length();
    }
}