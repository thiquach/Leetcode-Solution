package main.java.com.leetcode;

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

        String numberAsString = Integer.toString(x);
        String trimmedString = numberAsString.trim();
        String[] numberAsArray = new String[] {trimmedString};
        int start = 0;
        int len = numberAsArray.length;
        int end = len - 1;

        boolean result = true;
        while (start < end) {
            if (numberAsArray[start].equals(numberAsArray[end])) {
                start++;
                end--;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}
