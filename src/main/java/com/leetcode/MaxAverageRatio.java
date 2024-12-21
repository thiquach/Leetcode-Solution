package main.java.com.leetcode;

import java.util.PriorityQueue;

public class MaxAverageRatio {
    public static void main(String[] args) {
        int[][] classes = {{1,2},{3,5},{2,2}};
        int extraStudents = 2;
        System.out.println("max avearge ratio " + maxAverageRatio(classes, extraStudents));
    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        if (classes == null || classes.length == 0) {
            return 0.0;
        }

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] cls : classes) {
            double amount = calculateChange(cls[0], cls[1]);
            pq.add(new double[]{amount, cls[0], cls[1]});
        }

        while (extraStudents > 0) {
            double[] entry = pq.poll();
            if (entry != null) {
                int currentPassed = (int) entry[1];
                int currentTotal = (int) entry[2];
                int nextPassed = currentPassed + 1;
                int nextTotal = currentTotal + 1;

                double newAmount = calculateChange(nextPassed, nextTotal);
                pq.offer(new double[]{newAmount, nextPassed, nextTotal});
            }
            extraStudents--;
        }

        double totalAverage = 0.0;
        while (!pq.isEmpty()) {
            double[] entry = pq.poll();
            totalAverage += entry[1] / entry[2];
        }

        return totalAverage / classes.length;
    }

    private static double calculateChange(double passed, double total) {
        double newPassed = passed + 1;
        double newTotal = total + 1;

        double previousRatio = (double) passed / total;
        double newRatio = (double) newPassed / newTotal;

        return newRatio - previousRatio;
    }
}
