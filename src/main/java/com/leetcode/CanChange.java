package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CanChange {
    public static void main(String[] args) {
        String start = "_L__R__R_";
        String target = "L______RR";
        System.out.println("can change " + canChange(start, target));
    }

    public static boolean canChange(String start, String target) {

        if (start.isEmpty() || target.isEmpty() || start.length() != target.length())
            return false;

        if (!start.replace("_", "").equals(target.replace("_", "")))
            return false;

        List<Integer> lStart = new ArrayList<>();
        List<Integer> rStart = new ArrayList<>();
        List<Integer> lTarget = new ArrayList<>();
        List<Integer> rTarget = new ArrayList<>();
        for (int i=0; i<start.length(); i++) {
            if (start.charAt(i) == 'L') {
                lStart.add(i);
            } else if (start.charAt(i) == 'R') {
                rStart.add(i);
            }
        }

        for (int i=0; i<target.length(); i++) {
            if (target.charAt(i) == 'L') {
                lTarget.add(i);
            } else if (target.charAt(i) == 'R') {
                rTarget.add(i);
            }
        }

        int i=0;
        int j=0;
        while (i < lStart.size() && j < lTarget.size()) {
            if (lStart.get(i) < lTarget.get(j)) {
                return false;
            }
            i++;
            j++;
        }

        i=0;
        j=0;
        while (i < rStart.size() && j < rTarget.size()) {
            if (rStart.get(i) > rTarget.get(j)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}