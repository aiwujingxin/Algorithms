package leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 01:30
 */
public class LeetCode140_trie {

    public static class Node {
        Node[] nodes = new Node[256];
        String word = "";
    }

    protected Node root = new Node();

    protected void insert(String word) {
        Node node = root;
        for (int pos = 0; pos < word.length(); ++pos) {
            char v = word.charAt(pos);
            if (node.nodes[v] == null) {
                node.nodes[v] = new Node();
            }
            node = node.nodes[v];
        }
        node.word = word;
    }


    List<String> out = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> words) {
        if (s.isEmpty() || words.isEmpty()) {
            return out;
        }

        //~ initialize trie
        for (String word : words) {
            insert(word);
        }

        //~ backtrack along side trie traversal
        backtrack(s, 0, root, new LinkedList<>());
        return out;
    }

    void backtrack(String s, int k, Node node, LinkedList<String> current) {
        if (k >= s.length()) {
            out.add(String.join(" ", current));
            return;
        }
        for (int pos = k; pos < s.length() && node != null; ++pos) {
            node = node.nodes[s.charAt(pos)];
            if (node == null || node.word.isEmpty()) {
                continue;
            }
            current.addLast(node.word);
            backtrack(s, pos + 1, root, current);
            current.removeLast();
        }
    }
}
