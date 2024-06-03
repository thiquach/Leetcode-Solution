package main.java.com.leetcode;

import static java.lang.Math.abs;

public class Reverse {
    public static void main(String[] args) {
        int number = 1534236469;
        if (number < Integer.MAX_VALUE && number > Integer.MIN_VALUE)
            System.out.println("input : " + number + " reverse " + reverse(number));
        else {
            System.out.println("out of range 1");
        }
    }

    public static int reverse(int number) {
        boolean isNegative = (number < 0);
        if (isNegative)
            number = -number;

        if (number > Integer.MAX_VALUE || number < Integer.MIN_VALUE) {
            System.out.println("out of range 2");
            return 0;
        }
        System.out.println(" number " + number);
        String numberAsString = Integer.toString(number);
        String trimmedString = numberAsString.trim();
        StringBuilder reversedStringBuilder = new StringBuilder(trimmedString).reverse();
        System.out.println(" reversed string builder " + reversedStringBuilder);

        String reversedString = reversedStringBuilder.toString();
        reversedString = reversedString.replaceAll("\0", "");
        System.out.println(" reversed string         " + reversedString);

        long reversedNumber = Long.parseLong(reversedString);
        System.out.println(" long " + reversedNumber);
        if (reversedNumber > Integer.MAX_VALUE || reversedNumber < Integer.MIN_VALUE) {
            System.out.println("reversed number out of range");
            return 0;
        } else {
            System.out.println(" int no cast " + reversedNumber);
            System.out.println(" int cast " + (int)reversedNumber);
            return isNegative ? (int)-reversedNumber : (int)reversedNumber;
        }
    }
}
