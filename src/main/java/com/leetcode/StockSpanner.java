package main.java.com.leetcode;

import java.util.Stack;
// 901 monotonic stack
public class StockSpanner {
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 0;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            int x = stack.pop()[1];
            span = span + x;
        }
        stack.push(new int[] {price, ++span});
        return span;
    }


    /**
     * Your StockSpanner object will be instantiated and called as such:
     * StockSpanner obj = new StockSpanner();
     * int param_1 = obj.next(price);
     */
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println("28 " + stockSpanner.next(28)); // return 1
        System.out.println("14 " + stockSpanner.next(14)); // return 1
        System.out.println("28 " + stockSpanner.next(28)); // return 1
        System.out.println("35 " + stockSpanner.next(35)); // return 1
        System.out.println("46 " + stockSpanner.next(46)); // return 1
        System.out.println("53 " + stockSpanner.next(53)); // return 1
        System.out.println("66 " + stockSpanner.next(66)); // return 1
        System.out.println("80 " + stockSpanner.next(80)); // return 1
        System.out.println("87 " + stockSpanner.next(87)); // return 1
        System.out.println("88 " + stockSpanner.next(88)); // return 1
    }
}
