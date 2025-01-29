package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;
// 118 Pascal Triangle
public class Generate {
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(" generate " + generate(numRows));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        for (int i=0; i<numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            for (int j=0; j<=i; j++) {
                if (j == 0 || j == i) {
                    currentRow.add(1);
                } else {
                    currentRow.add(triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
                }
            }
            triangle.add(currentRow);
        }
        return triangle;
    }
}