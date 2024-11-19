package main.java.com.leetcode;

import java.util.Arrays;
// 1652 easy
public class Decrypt {
    public static void main(String[] args) {
//        int[] code = {5,7,1,4}; // k=3
        int[] code = {2,4,9,3}; // k=-2
        int k = -2;
        System.out.println("decrypt " + Arrays.toString(decrypt(code, k)));
    }

    public static int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];

        if (code.length == 0)
            return result;

        if (k == 0) {
            Arrays.fill(result, 0);
        } else {
            for (int i = 0; i < code.length; i++) {
                result[i] = sumOfCodes(code, i, k);
            }
        }
        return result;
    }

    private static int sumOfCodes(int[] code, int i, int k) {
        int sum = 0;
        int len = code.length;
        int index = i;
        int n = Math.abs(k);

        for (int j=0; j<n; j++) {
            if (k > 0) {
                index++;
            } else {
                index --;
                if (index < 0) {
                    index += len;
                }
            }
            sum += code[index % len];
        }
        return sum;
    }
}