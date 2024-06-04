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

        try {
            long reversedNumber = Long.parseLong(reversedString.toString());
            if (reversedNumber > Integer.MAX_VALUE || reversedNumber < Integer.MIN_VALUE) {
                return 0;
            }
            return isNegative ? (int)-reversedNumber : (int)reversedNumber;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
