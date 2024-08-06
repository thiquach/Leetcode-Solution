package main.java.com.leetcode;

public class MinFlips {
    public static void main(String[] args) {

        int a = 8;
        int b = 3;
        int c = 5;

        int result = minFlips(a,b,c);
        System.out.println("a,b,c " + a + "," + b + "," + c + " result " + result);
    }
    public static int minFlips(int a, int b, int c) {
        if (a < 1 || b < 1 || c < 1
                || a > Math.pow(10,9) || b > Math.pow(10,9) || c > Math.pow(10,9))
            return 0;

        int bits = 0;
        int count = 0;
        while (c > 0 || a > 0 || b > 0) {
            if (((a & 1) | (b & 1)) != (c & 1)) {
                if ((c & 1) == 1) {
                    a = a | 1;
                    count++;
                } else {
                    if ((a & 1) == 1) {
                        a = (a | 1) ^ 1;
                        count++;
                    }
                    if ((b & 1) == 1) {
                        b = (b | 1) ^ 1;
                        count++;
                    }
                }
;            }
            c = c >> 1;
            a = a >> 1;
            b = b >> 1;
        }
        return count;
    }
}
