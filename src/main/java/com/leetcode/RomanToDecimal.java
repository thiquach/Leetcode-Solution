package main.java.com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToDecimal {
    public static void main(String[] args) {
        String roman = "MCMLXXXVI";
        System.out.println("Roman " + roman + " Decimal " + romanToDecimal(roman));
    }

    private static int romanToDecimal(String roman) {
        if (roman == null || roman.isEmpty())
            return 0;

        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        roman = roman.toUpperCase();
        int result = 0;
        int length = roman.length();


        for (int i=0; i<length; i++) {

            int currentValue = romanMap.get(roman.charAt(i));

            if ((i + 1) < length) {
                int nextValue = romanMap.get(roman.charAt(i + 1));
                if (nextValue > currentValue) {
                    result += (nextValue - currentValue);
                    i++;
                    continue;
                }
            }
            result += currentValue;
        }
        return result;
    }
}