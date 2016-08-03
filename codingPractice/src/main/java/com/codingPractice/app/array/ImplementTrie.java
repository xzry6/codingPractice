package com.codingPractice.app.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * @author Sean
 *
 */
public class ImplementTrie {
	private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word == null || word.length() == 0) return;

        TrieNode node = root;
        for(char c:word.toCharArray()) {
            if(!node.neighbors.containsKey(c)) node.neighbors.put(c, new TrieNode());
            node = node.neighbors.get(c);
        }
        node.neighbors.put('\n', null);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word == null || word.length() == 0) return false;

        TrieNode node = root;
        for(char c:word.toCharArray()) {
            if(!node.neighbors.containsKey(c)) return false;
            node = node.neighbors.get(c);
        }

        return node.neighbors.containsKey('\n');
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0) return false;

        TrieNode node = root;
        for(char c:prefix.toCharArray()) {
            if(!node.neighbors.containsKey(c)) return false;
            node = node.neighbors.get(c);
        }

        return true;
    }
}

class TrieNode {
    Map<Character, TrieNode> neighbors;
    // Initialize your data structure here.
    public TrieNode() {
        this.neighbors = new HashMap<Character, TrieNode>();
    }
}
