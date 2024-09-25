package main.java.com.leetcode;
// 9 Math
public class PalindromeNumber {
    public static void main(String[] args) {
        int number = 122;
        System.out.println("input: " + number);
        System.out.println("is Palindrome? " + isPalindrome(number));
    }

    public static boolean isPalindrome(int x) {
        boolean isNegative = x < 0;

        if (isNegative)
            return false;

        long div = 1;
        while (x >= div * 10) {
            div = div * 10;
        }

        long num = x;
        while (num > 0) {
            long right = num % 10;
            long left = num / div;
            if (left != right)
                return false;
            num = (num % div) / 10;
            div /= 100;
        }
        return true;
    }
}
