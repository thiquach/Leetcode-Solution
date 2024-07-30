package main.java.com.leetcode;

import java.util.HashMap;

public class IsAnagram {
    public static void main(String[] args) {
        String s = "12345";
        String t = "54321";
        System.out.println("s " + s + " t " + t);
        System.out.println("is Anagram? " + isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> count = new HashMap<>();

        for (Character ch : s.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        for (Character ch : t.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) - 1);
        }
        for (int v : count.values()) {
            if (v != 0) {
                return false;
            }

        }
        return true;
    }
}
