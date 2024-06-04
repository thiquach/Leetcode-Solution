package main.java.com.leetcode;

public class IsPowerOfTwo {
    public static void main(String[] args) {
        int number = -2147483648;
        System.out.println("number " + number + " is power of 2? " + isPowerOfTwo(number));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;

        while (n != 1) {
            if ((n % 2) != 0)
                return false;
            else {
                n = n / 2;
            }
        }
        return true;
    }
}
