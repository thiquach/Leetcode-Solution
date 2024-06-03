package main.java.com.leetcode;

public class Reverse {
    public static void main(String[] args) {
        int number = 1534236469;
        System.out.println("input: " + number + " reverse " + reverse(number));
    }

    public static int reverse(int number) {
        boolean isNegative = (number < 0);
        if (isNegative)
            number = -number;

        String numberAsString = Integer.toString(number);
        String trimmedString = numberAsString.trim();
        String reversedString = new StringBuilder(trimmedString).reverse().toString();

        long reversedNumber = Long.parseLong(reversedString);
        if (reversedNumber > Integer.MAX_VALUE || reversedNumber < Integer.MIN_VALUE) {
            System.out.println("reversed number out of range");
            return 0;
        } else {
            return isNegative ? (int)-reversedNumber : (int)reversedNumber;
        }
    }
}
