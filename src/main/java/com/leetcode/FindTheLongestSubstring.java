package main.java.com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindTheLongestSubstring {
    public static void main(String[] args) {
//        String s = "eleetminicoworoep";
//        String s = "leetcodeisgreat";
        String s = "bcbcbc";
        System.out.println(s + " longest substring " + findTheLongestSubstring(s));
    }

    public static int findTheLongestSubstring(String s) {
        if (s.isEmpty())
            return 0;

        Map<Integer, Integer> sMap = new HashMap<>();
        sMap.put(0, -1);
        int vowelCountMask = 0;
        int maxLen = 0;
        for (int i = 0; i<s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a': vowelCountMask ^= 1; break;
                case 'e': vowelCountMask ^= 2; break;
                case 'i': vowelCountMask ^= 4; break;
                case 'o': vowelCountMask ^= 8; break;
                case 'u': vowelCountMask ^= 16; break;
            }

            if (sMap.containsKey(vowelCountMask)) {
                maxLen = Math.max(maxLen, i - sMap.get(vowelCountMask));
            } else {
                sMap.put(vowelCountMask, i);
            }
        }
        return maxLen;
    }
}
