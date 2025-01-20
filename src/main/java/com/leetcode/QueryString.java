package main.java.com.leetcode;
// 1016
public class QueryString {
    public static void main(String[] args) {
        String s = "0110";
        int n = 3;
        System.out.println("query string " + queryString( s, n));
    }

    public static boolean queryString(String s, int n) {

        for (int i=1; i<=n; i++) {
            String binary = convertDecimalToBinary(i);
            if (!s.contains(binary)) {
                return false;
            }
        }
        return true;
    }

    public static String convertDecimalToBinary(Integer n) {

        StringBuilder binary = new StringBuilder();

        while (n > 0) {
            int remainder = n % 2;
            binary.append(remainder);
            n = n/2;
        }

        return binary.reverse().toString();
    }
}