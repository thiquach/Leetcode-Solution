package main.java.com.leetcode;

import java.util.*;

public class SortPeople {
    public static void main(String[] args) {
//        String[] names = {"Mary","John","Emma"};
//        int[] heights = {180,165,170};
        String[] names = {"Alice","Bob","Bob"};
        int[] heights = {155,185,150};
        String[] result = sortPeople(names, heights);
        System.out.println(" sort people " + Arrays.deepToString(result));
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        List<String> result = new ArrayList<>();
        if (names.length == 0 || heights.length == 0)
            result.toArray(new String[0]);

        Map<Integer, String> heightMap = new HashMap<>();
        for (int i=0; i<heights.length; i++) {
            heightMap.put(heights[i], names[i]);
        }

        Integer[] heightArray = Arrays.stream(heights).boxed().toArray(Integer[]::new);
        Arrays.sort(heightArray, Collections.reverseOrder());
        for (int i = 0; i<heightArray.length; i++) {
            for (Map.Entry<Integer, String> m : heightMap.entrySet()) {
                if (m.getKey().equals(heightArray[i])) {
                    result.add(m.getValue());
                }
            }
        }

        return result.toArray(new String[0]);
    }
}
