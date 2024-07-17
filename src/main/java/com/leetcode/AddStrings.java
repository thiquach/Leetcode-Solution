package main.java.com.leetcode;

// 415 easy
public class AddStrings {
    public static void main(String[] args) {
        String input1 = "6913259244";
        String input2 = "71103343";
//        String input1 = "1234";
//        String input2 = "6789";

        String result = addStrings(input1, input2);
        System.out.println("add strings " + result);
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1 ;
        int n1 = 0;
        int n2 = 0;
        int carry = 0;
        int sum = 0;

        while (len1 >= 0 || len2 >= 0 || carry > 0) {
            if (len1 >= 0) {
                n1 = num1.charAt(len1) - '0';
            } else {
                n1 = 0;
            }
            if (len2 >= 0) {
                n2 = num2.charAt(len2) - '0';
            } else {
                n2 = 0;
            }
            sum = n1 + n2 + carry;
            carry = sum /10;
            sb.append(sum % 10);
            len1--;
            len2--;
        }
        return sb.reverse().toString();
    }
}
