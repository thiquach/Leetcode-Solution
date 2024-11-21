package main.java.com.leetcode;
// 1534 easy by brute force
public class CountGoodTriplets {
    public static void main(String[] args) {
        // 0 <= i < j < k <= len
        // /arr[i] - arr[j]/ <= a  abs(dif) <= a
        // /arr[j] - arr[k]/ <= b
        // /arr[i] - arr[k]/ <= c
        int[] arr = {3,0,1,1,9,7};
        int a = 7, b = 2, c = 3;
//        int[] arr = {1,1,2,2,3}; int a = 0, b = 0, c = 1;
        System.out.println("good triplets " + countGoodTriplets(arr, a, b, c));
    }

    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        if (arr.length < 3)
            return 0;

        int count = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=i; j<arr.length; j++) {
                for (int k=j; k<arr.length; k++) {
                    if (i < j && j < k && Math.abs(arr[i] - arr[j]) <= a &&
                        Math.abs(arr[j] - arr[k]) <= b &&
                        Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}