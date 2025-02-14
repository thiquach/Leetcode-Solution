package main.java.com.leetcode;

import java.math.BigInteger;
import java.util.*;

public class LargestNumber {
    public static void main(String[] args) {
//        int[] nums = {3,2,5};
//        int[] nums = {3,30,34,5,9};
        int[] nums = {0,0};
//        int[] nums = {1,2,3,4,5,6,7,8,9,0};
        System.out.println(Arrays.toString(nums) + " largest number " + largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        int length = nums.length;

        if (length == 0)
            return "";

        List<String> listStrings = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            listStrings.add(Integer.toString(nums[i]));
        }

        Collections.sort(listStrings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                StringBuilder sb1 = new StringBuilder();
                sb1.append(o1).append(o2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(o2).append(o1);
                BigInteger order1Value = new BigInteger(sb1.toString());
                BigInteger order2Value = new BigInteger(sb2.toString());

                // Compare BigInteger values
                return order2Value.compareTo(order1Value);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<listStrings.size(); i++) {
            sb.append(listStrings.get(i));
        }

        int index = 0;
        while (sb.length() > 0 && sb.charAt(index) == '0') {
            sb.deleteCharAt(index);
        }
        return (sb.length() == 0) ? "0" : sb.toString();
    }
}
