package main.java.com.leetcode;
// 208
public class Trie {
    public class TrieNode {
        boolean wordEnd;
        TrieNode[] children;

        public TrieNode() {
            this.wordEnd = false;
            this.children = new TrieNode[26]; // 26 letters of the alphabet
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.wordEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.wordEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c: prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        String[] commands = {"Trie", "insert", "search", "search", "startsWith", "insert", "search"};
        String[] strings = {"", "apple", "apple", "app", "app", "app", "app"};
        Trie trie = new Trie();
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "Trie":
                    break;
                case "insert":
                    trie.insert(strings[i]);
                    System.out.println(" insert " + strings[i]);
                    break;
                case "startsWith":
                    System.out.println(" startwith " + strings[i] + " -> " + trie.startsWith(strings[i]));
                    break;
                case "search":
                    System.out.println(" search " + strings[i] + " -> " + trie.search(strings[i]));
                    break;
            }
        }
    }
}