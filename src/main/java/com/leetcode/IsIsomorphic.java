package main.java.com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public static void main(String[] args)
    {
        String s = "egg";
        String t = "add";
        System.out.println(s + "," + t + " is isomorphic? " + isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        if (s.length() != t.length())
            return false;

        for (int i=0; i<s.length(); i++) {
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);

            if (sMap.containsKey(sChar)) {
                if (sMap.get(sChar) != tChar) {
                    return false;
                }
            } else {
                sMap.put(sChar, tChar);
            }

            if (tMap.containsKey(tChar)) {
                if (tMap.get(tChar) != sChar) {
                    return false;
                }
            } else {
                tMap.put(tChar, sChar);
            }
        }
        return true;
    }
}