package main.java.com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class NumberContainers {
    private final Map<Integer, TreeSet<Integer>> indicesSet;
    private Map<Integer, Integer> indexMap;

    public NumberContainers() {
        indicesSet = new HashMap<>();
        indexMap = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexMap.containsKey(index)) {
            int oldNumber = indexMap.get(index);
            if (indicesSet.containsKey(oldNumber)) {
                indicesSet.get(oldNumber).remove(index);
                if (indicesSet.get(oldNumber).isEmpty()) {
                    indicesSet.remove(oldNumber);
                }
            }
        }
        indexMap.put(index, number);
        indicesSet.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        if (!indicesSet.containsKey(number) || indicesSet.get(number).isEmpty())
            return -1;
        else {
            return indicesSet.get(number).first();
        }
    }

    public static void main(String[] args) {
        NumberContainers nContainers = new NumberContainers();
        int result = nContainers.find(10);
        System.out.println(" find 10 -> result " + result);
        nContainers.change(2,10);
        nContainers.change(1,10);
        nContainers.change(3,10);
        nContainers.change(5,10);
        nContainers.change(4,40);
        result = nContainers.find(10);
        System.out.println(" find 10 -> result " + result);
        nContainers.change(1,20);
        System.out.println(" change index 1 to 20");
        result = nContainers.find(10);
        System.out.println(" find 10 -> result " + result);
        System.out.println(" find 20 -> result " +nContainers.find(20)); // 1
    }
}
/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */

