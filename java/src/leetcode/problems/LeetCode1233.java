package leetcode.problems;

import java.util.*;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 4/14/25 23:27
 */
public class LeetCode1233 {

    public List<String> removeSubfolders(String[] folder) {
        Trie tree = new Trie();
        for (String f : folder) {
            tree.insert(f);
        }
        List<String> res = new ArrayList<>();
        for (String f : folder) {
            if (tree.startsWith(f)) {
                res.add(f);
            }
        }
        return res;
    }
}


class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (String key : word.split("/")) {
            if (key.isEmpty()) continue;
            if (!node.children.containsKey(key)) {
                node.children.put(key, new TrieNode(key));
            }
            node = node.children.get(key);
        }
        node.isEnd = true;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        int len = 0;
        String[] plist = prefix.split("/");
        for (String key : plist) {
            if (key.isEmpty()) continue;
            node = node.children.get(key);
            if (node.val != null)
                len++;
            if (node.isEnd) {
                return len == plist.length - 1;
            }
        }
        return false;
    }

    public static class TrieNode {
        public String val;
        public Map<String, TrieNode> children;
        public boolean isEnd;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isEnd = false;
        }

        public TrieNode(String val) {
            this.val = val;
            this.children = new HashMap<>();
            this.isEnd = false;
        }
    }
}
