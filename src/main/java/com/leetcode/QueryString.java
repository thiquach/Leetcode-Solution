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
            Integer binaryNumber = convertDecimalToBinary(i);
            if (!s.contains(binaryNumber.toString())) {
                return false;
            }
        }
        return true;
    }

    public static Integer convertDecimalToBinary(Integer decimalNumber) {

        if (decimalNumber == 0) {
            return decimalNumber;
        }

        StringBuilder binaryNumber = new StringBuilder();
        Integer quotient = decimalNumber;

        while (quotient > 0) {
            int remainder = quotient % 2;
            binaryNumber.append(remainder);
            quotient /= 2;
        }

        binaryNumber = binaryNumber.reverse();
        return Integer.valueOf(binaryNumber.toString());
    }
}