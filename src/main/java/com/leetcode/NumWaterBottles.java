package main.java.com.leetcode;
// 1518 easy
public class NumWaterBottles {
    public static void main(String[] args) {
        System.out.println("numWaterBottles " + numWaterBottles(15,4));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        if (numExchange < 2)
            return numBottles;

        if (numBottles == 1)
            return numBottles;

        int waterBottles = numBottles;
        int totalWaterBottles = waterBottles;
        int emptyBottles = numBottles;

        while (emptyBottles >= numExchange) {
            waterBottles = emptyBottles / numExchange;
            emptyBottles = waterBottles + emptyBottles % numExchange;
            totalWaterBottles += waterBottles;
        }

        return totalWaterBottles;
    }
}
