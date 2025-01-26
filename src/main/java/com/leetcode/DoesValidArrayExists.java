package main.java.com.leetcode;
// 2683
public class DoesValidArrayExists {
    public static void main(String[] args) {
//        int[] derived = {1,1,0};
        int[] derived = {1,0};
        System.out.println("does valid array exists " + doesValidArrayExist(derived));
    }

    public static boolean doesValidArrayExist(int[] derived) {
        int xorSum = 0;
        for (int j : derived) {
            xorSum ^= j;
        }
        return xorSum == 0;
    }
}
