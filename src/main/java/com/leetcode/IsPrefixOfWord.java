package main.java.com.leetcode;

public class IsPrefixOfWord {
    public static void main(String[] args) {
//        String sentence = "i love eating burger";
//        String serachWord = "burg";
//        String sentence = "this problem is an easy problem";
//        String serachWord = "prob";
        String sentence = "i am tired";
        String serachWord = "you";
        System.out.println(" is prefix " + isPrefixOfWord(sentence, serachWord));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        if (sentence.isEmpty())
            return 0;

        String[] sentenceWords = sentence.split(" ");
        for (int i=0; i<sentenceWords.length; i++) {
            if (sentenceWords[i].indexOf(searchWord) == 0)
                return i + 1;
        }
        return -1;
    }
}
