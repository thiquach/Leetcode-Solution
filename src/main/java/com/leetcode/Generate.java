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
        List<List<Integer>> nRows= new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            nRows.add(new ArrayList<Integer>(row));
        }
        return nRows;
    }
}