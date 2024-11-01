package main.java.com.leetcode;

public class MakeFancyString {
    public static void main(String[] args) {
//        String s = "Leeetcode";
        String s = "aaabaaaa";
        System.out.println("Make fancy string " + makeFancyString(s));
    }
    public static String makeFancyString(String s) {
        if (s.length() < 3)
            return s;

        int len = s.length();
        StringBuilder sb = new StringBuilder();
        char lastChar = s.charAt(0);
        sb.append(lastChar);
        int count = 0;
        for (int i=1; i<len; i++) {
            char ch = s.charAt(i);
            if (lastChar == ch) {
                if (count == 0) {
                    count = 2;
                } else
                    count++;
            } else {
                count = 0;
            }
            lastChar = ch;
            if (count == 3) {
                count--;
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
