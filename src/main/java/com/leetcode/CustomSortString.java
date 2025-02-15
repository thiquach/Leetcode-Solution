package main.java.com.leetcode;

import java.util.*;

// 791
public class CustomSortString {
    public static void main(String[] args) {
//        String order = "cba";
        String order = "bcafg";
        String s = "abcd";
        System.out.println(order + " " + s + " -> " + customSortString(order, s));
    }

    public static String customSortString(String order, String s) {
        if (s.isEmpty() || order.isEmpty())
            return "";

        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i=0; i<order.length(); i++) {
            char ch = order.charAt(i);
            orderMap.put(ch, orderMap.getOrDefault(ch, 0) + 1);
        }

        StringBuilder unorderedChars = new StringBuilder();
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (orderMap.containsKey(ch)) {
                sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
            } else {
                unorderedChars.append(ch);
            }
        }

        StringBuilder orderChars = new StringBuilder();
        for (int i=0; i<order.length(); i++) {
            char ch = order.charAt(i);
            if (sMap.containsKey(ch)) {
                int val = sMap.get(ch);
                while (val > 0) {
                    orderChars.append(ch);
                    val--;
                }
            }
        }
        return orderChars.append(unorderedChars).toString();
    }
}