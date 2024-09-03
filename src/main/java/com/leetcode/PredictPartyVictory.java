package main.java.com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

// 649 Queue greedy
public class PredictPartyVictory {
    public static void main (String[] args) {
        String senate =  "RD";
        String result = predictPartyVictory(senate);
        System.out.println("\npredict party victory " + result);
    }

    public static String predictPartyVictory(String senate) {
        if (senate == null)
            return "";

        Deque<Integer> queueRadiant = new LinkedList<>();
        Deque<Integer> queueDire = new LinkedList<>();

        int len = senate.length();
        for (int i=0; i<len; i++) {
            char ch = senate.charAt(i);
            if (ch == 'R') {
                queueRadiant.addLast(i);
            } else if (ch == 'D') {
                queueDire.addLast(i);
            } else {
                System.out.println("Unknown team");
            }
        }

        while (!queueDire.isEmpty() && !queueRadiant.isEmpty()) {
            int dire = queueDire.peekFirst();
            int radiant = queueRadiant.peekFirst();

            if (dire < radiant) {
                dire = queueDire.pollFirst();
                queueRadiant.pollFirst();
                queueDire.addLast(dire + len);
            } else {
                radiant = queueRadiant.pollFirst();
                queueDire.pollFirst();
                queueRadiant.addLast(radiant + len);
            }
        }

        if (queueRadiant.isEmpty()) {
            return "Dire";
        } else {
            return "Radiant";
        }
    }
}