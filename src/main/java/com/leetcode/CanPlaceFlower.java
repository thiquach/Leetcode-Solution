package main.java.com.leetcode;

public class CanPlaceFlower {
    public static void main(String[] args) {
        int[] flowerbed = {0, 0, 1, 0, 0};
        System.out.println(canPlaceFlowers(flowerbed, 1));
    }

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int len = flowerbed.length;
        int count = 0;

        if (len == 1 && flowerbed[len-1] == 0) {
            count++;
            flowerbed[len-1] = 1;
        }

        for (int i=0; i<len; i++) {
            if (flowerbed[i] == 0 &&
                    (i == 0 || flowerbed[i-1] == 0) &&
                    (i == len -1 || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1;
                count++;
                i++;
            }
        }
        return count >= n;
    }
}
