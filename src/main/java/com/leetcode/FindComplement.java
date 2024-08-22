package main.java.com.leetcode;

public class FindComplement {
    public static void main(String[] args) {
        int n = 5;
        int result = findComplement(5);
        System.out.println("n is " + n + " compliment is " + result);
    }

    public static int findComplement(int num) {
        int numCopy = num;
        int bitPosition = 0;
        while(numCopy != 0) {
            bitPosition++;
            numCopy = numCopy >> 1;
        }

        int nMask = 0;
        for (int i=0; i<bitPosition; i++) {
            nMask |= (1 << i);
        }
        return nMask ^ num;
    }
}
