package main.java.com.leetcode;

import java.util.*;

public class SmallestNumber {
    public static void main(String[] args) {
//        long num = 310;
        long num = -7605;
        System.out.println("smallest number " + smallestNumber(num));
    }

    public static long smallestNumber(long num) {
        if (num == 0L)
            return 0L;

        long numAbs = num;
        if (num < 0) {
            numAbs = Math.abs(num);
        }

        List<Character> numAsCharList = new ArrayList<>();
        String numString = Long.toString(numAbs);
        for (int i=0; i<numString.length(); i++) {
            numAsCharList.add(numString.charAt(i));
        }

        if (num < 0) {
            numAsCharList.sort(Collections.reverseOrder());
        }
        else {
            Collections.sort(numAsCharList);
        }

        if (numAsCharList.get(0) == '0') {
            for (int i=1; i<numAsCharList.size(); i++) {
                if (numAsCharList.get(i) != '0') {
                    Collections.swap(numAsCharList, 0, i);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<numAsCharList.size(); i++) {
            sb.append(numAsCharList.get(i));
        }

        return num < 0 ? Long.parseLong(sb.toString()) * -1 : Long.parseLong(sb.toString());
    }
}
