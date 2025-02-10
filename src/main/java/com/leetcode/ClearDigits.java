package main.java.com.leetcode;
// 3174
public class ClearDigits {
    public static void main(String[] args) {
        String s = "abc";
//        String s = "cb34";
        System.out.println("clear digit " + clearDigits(s));
    }

    public static String clearDigits(String s) {
        if (s.isEmpty())
            return "";

        StringBuilder sb = new StringBuilder(s);
        for (int index = 0; index < sb.length(); index++) {
            if (Character.isDigit(sb.charAt(index))) {
                if (index > 0) {
                    sb.deleteCharAt(index - 1); // after deleteCharAt it changes sb
                    sb.deleteCharAt(index - 1); // move 1 position for the char before the digit
                } else {
                    sb.deleteCharAt(index);
                }
                index = 0;
                System.out.println(" sb " + sb.toString());
            }
        }
        return sb.toString();
    }
}
