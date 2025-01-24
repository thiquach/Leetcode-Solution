package main.java.com.leetcode;
// 2429
public class MinimizeXor {
    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 5;
        System.out.println("minimize Xor " + minimizeXor(num1, num2));
    }

    public static int minimizeXor(int num1, int num2) {
        if (num1 == 0 || num2 == 0)
            return 0;

        int num2set = Integer.bitCount(num2);
        int result = 0;
        for (int i=31; i>=0 && num2set>0; i--) {
            int current = num1 & (1 << i);
            if (current > 0) {
                result |= current;
                num2set--;
            }
        }

        for (int i=0; i<31 && num2set>0; i++) {
            int current = num1 & (1 << i);
            if (current == 0) {
                result |= (1<<i);
                num2set--;
            }
        }

        return result;
    }
}