package main.java.com.leetcode;

// 1945
public class GetLucky {
    public static void main(String[] args) {
//        String s = "Leetcode";
        String s = "zbax";
        int k = 2;  // 2
        System.out.println("get lucky s " + s + " " + getLucky(s, k));
    }

    public static int getLucky(String s, int k) {
        if (k == 0)
            return 0;

        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<len; i++) {
            sb.append(isIndex(s.charAt(i)));
        }

        int result = sumOfStringDigits(sb.toString());
        for (int i=1; i<k; i++) {
            result = sumOfStringDigits(Integer.toString(result));
        }
        return result;
    }

    private static int isIndex(char ch) {
        int nums = "abcdefghijklmnopqrstuvwxyz".indexOf(ch);
        if (nums == -1) {
            nums = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(ch);
        }
        return nums + 1;
    }

    private static int sumOfStringDigits(String s) {
        if (s == null)
            return 0;

        int sum = 0;
        for (int i=0; i<s.length(); i++) {
            sum += (s.charAt(i) - '0');
        }
        return sum;
    }
}
