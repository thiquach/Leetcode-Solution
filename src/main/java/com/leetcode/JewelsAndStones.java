package main.java.com.leetcode;

public class JewelsAndStones {
    public static void main(String[] args) {
        String stones = "ZZ";
        String jewels = "z";
        int matchCount = 0;
        char[] stonesArray = stones.toCharArray();
        char[] jewelsArray = jewels.toCharArray();

        for (int i=0; i<stonesArray.length; i++) {
            for (int j=0; j<jewelsArray.length; j++) {
                if (jewelsArray[j] == stonesArray[i]){
                    matchCount++;
                }
            }
        }
        System.out.println(" matchCount " + matchCount);
    }
}
