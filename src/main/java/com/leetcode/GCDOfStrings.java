package main.java.com.leetcode;


public class GCDOfStrings {
    public static void main(String[] args) {
        String str1 = "ABABAB";
        String str2 = "ABAB";

        System.out.println("string1 " + str1 + " string2 " + str2 + " gcd " + gcdOfStrings(str1, str2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}