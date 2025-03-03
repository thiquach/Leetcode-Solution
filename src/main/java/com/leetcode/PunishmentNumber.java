package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 2698
public class PunishmentNumber {
    public static void main(String[] args) {
        int n = 10;
//        int n = 37;
//        int n = 91;
        System.out.println("punish # " + punishmentNumber(n));
    }

    public static int punishmentNumber(int n) {
        if (n==0 || n > 1000)
            return 0;

        List<List<Integer>> partitions = new ArrayList<>();
        int punishmentNumber = 0;
        for (int i=1; i<=n; i++) {
            int product = i * i;
            String iSquare = String.valueOf(product);
            findPartitions(iSquare, 0, new ArrayList<>(), partitions);
            for (List<Integer> partition: partitions) {
                if (sumPartitions(partition, i) == i) {
                    punishmentNumber += product;
                    break;
                }
            }
            partitions.clear();
        }
        return punishmentNumber;
    }

    private static int sumPartitions(List<Integer> partitions, int curNum) {
        int sum = 0;
        for (Integer part: partitions) {
            sum += part;
            if (sum > curNum)
                break;
        }
        return sum;
    }

    private static void findPartitions(String s, int start,
                                         List<Integer> current, List<List<Integer>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String subString = s.substring(start, i + 1);
            current.add(Integer.parseInt(subString));
            findPartitions(s,i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}