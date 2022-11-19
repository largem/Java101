package net.largem.ds.trie;

public class StudyTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("word1");
        trie.insert("word2");
        trie.insert("abcd2");
        trie.insert("2");
        trie.insert("12345");
        trie.insert("123aaa");

        trie.print();
    }
}
